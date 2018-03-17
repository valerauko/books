(ns books.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.logger :refer [wrap-with-logger]]
            [books.actions [books :as books]
                           [users :as users]
                           [session :as session]]
            [ring.middleware.defaults :refer :all]))

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
  (GET  "/register"
    {{user :books} :session}
    (users/new user))
  (POST "/register"
    {{email :email} :params}
    (users/create email))
  (route/resources "/")
  (route/not-found "oh fuck"))

(def app
  (wrap-with-logger (wrap-defaults book-routes (assoc site-defaults :proxy true))))
