(ns books.mongo
  (:require [somnium.congomongo :refer :all]))

(def conn
  (make-connection (System/getenv "MONGO_URL")))
