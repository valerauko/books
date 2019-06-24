(ns books.mongo
  (:require [somnium.congomongo :refer :all]
            [mount.core :refer [defstate]]))

(defstate conn
  :start
    (make-connection (System/getenv "MONGO_URL"))
  :stop
    (close-connection conn))
