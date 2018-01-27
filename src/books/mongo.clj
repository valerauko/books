(ns books.mongo
  (:require [somnium.congomongo :refer :all]))

(def conn
  (make-connection "local"))
