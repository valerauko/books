(ns books.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [mount.core :as mount :refer [defstate]]
            [ring.logger :refer [wrap-with-logger]]
            [books.actions [books :as books]
                           [session :as session]]
            [ring.middleware.defaults :refer :all]
            [ring.adapter.jetty :refer [run-jetty]]))

(defroutes book-routes
  (GET  "/"
    {{user :books} :session}
    (session/wrap-login user books/index))
  (GET  "/read"
    {{user :books} :session}
    (session/wrap-login user books/new))
  (POST "/read"
    {{user :books} :session {book :book} :params}
    (session/wrap-login user (books/create book)))
  (GET  "/login"
    {{user :books} :session}
    (session/new user))
  (POST "/login"
    {{email :email pass :password} :params}
    (session/create email pass))
  (GET  "/logout"
    []
    (session/destroy))
  (route/resources "/")
  (route/not-found "oh fuck"))

(def handler
  (wrap-with-logger (wrap-defaults book-routes (assoc site-defaults :proxy true))))

(defstate http-server
  :start
    (run-jetty handler {:port (or (System/getenv "BOOKS_PORT") 3000)
                        :host (or (System/getenv "BOOKS_HOST") "0.0.0.0")
                        :send-server-version? false}))

(defn -main [& _args]
  (mount/start))
