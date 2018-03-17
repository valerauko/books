(ns books.fixtures.mongo-wrap
  (:require [somnium.congomongo :refer :all]))

(def test-db "booklog_test")

(def conn
  (make-connection test-db))

(defn clear-mongo [block]
  (do
    (block)
    (println "Clearing test database.")
    (with-mongo conn (drop-database! test-db))))
