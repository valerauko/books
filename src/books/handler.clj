(ns books.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [books.actions [books :as books]
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
  (route/resources "/")
  (route/not-found "oh fuck"))

(def app
  (wrap-defaults book-routes (assoc secure-site-defaults :proxy true)))
