(ns books.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [books.actions [books :as books]]
            [ring.middleware.defaults :refer :all]))

(defroutes book-routes
  (GET  "/"       {{session :books} :session} (books/index session))
  (route/not-found "oh fuck"))

(def app
  (wrap-defaults book-routes site-defaults))
