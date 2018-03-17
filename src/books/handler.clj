(ns books.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.logger :refer [wrap-with-logger]]
            [books.actions [books :as books]
                           [users :as users]
                           [session :as session]]
            [books.view :refer [e404]]
            [ring.middleware.defaults :refer :all]))

(defroutes book-routes
  (context "/" {{user :books} :session}
    (GET "/" []
      (session/wrap-login user books/index))
    (context "/read" []
      (GET  "/" []
        (session/wrap-login user books/new))
      (POST "/" {{book :book} :params}
        (session/wrap-login user (books/create book))))
    (context "/login" []
      (GET  "/" []
        (session/new user))
      (POST "/" {{email :email pass :password} :params}
        (session/create email pass)))
    (GET  "/logout" []
      (session/destroy))
    (context "/register" []
      (GET  "/" []
        (users/new user))
      (POST "/" {{email :email} :params}
        (users/create email))))
  (route/resources "/")
  (route/not-found (e404)))

(def app
  (wrap-with-logger
    (wrap-defaults book-routes (assoc site-defaults :proxy true))))
