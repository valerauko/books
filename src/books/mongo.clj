(ns books.mongo
  (:require [somnium.congomongo :refer :all]))

(def conn
  (make-connection
    "local"
    :instances [{:host "mongo-db" :port 27017}]))
