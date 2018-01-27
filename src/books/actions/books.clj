(ns books.actions.books
  (:require [books.mongo :refer [conn]]
            [somnium.congomongo :refer :all]))

(defn index
  "Top page"
  ([]
    {:status 302 :headers {"Location" "/"} :body "Please log in."})
  ([user]
    (let [result (with-mongo conn (insert! :test {:hello "world"}))
          total (with-mongo conn (fetch-count :test))]
      (str
        "Hello, " user "<br/>"
        (if result "Added a new item!" "Failed to add a new item.")
        "<br/>Total items: " total "."))))
