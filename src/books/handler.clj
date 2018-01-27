(ns books.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]))

(defroutes book-routes
  (route/not-found "oh fuck"))

(def app
  (wrap-defaults book-routes site-defaults))
