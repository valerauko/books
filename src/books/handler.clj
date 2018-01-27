(ns books.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [books.actions [books :as books]
                           [session :as session]]
            [ring.middleware.defaults :refer :all]))

(defroutes book-routes
  (GET  "/"       {{session :books} :session} (books/index session))
  (GET  "/login"  {{session :books} :session} (session/new session))
  ;(POST "/login"  [request] (session/create request))
  (GET  "/logout" []                          (session/destroy))
  (route/not-found "oh fuck"))

(def app
  (wrap-defaults book-routes site-defaults))
