(ns books.models.book
  (:require [books.mongo :refer [conn]]
            [somnium.congomongo :refer :all]
            [clojure.string :refer [join split]]))

(defn all
  "Get all reads by user"
  [user]
  (with-mongo conn (fetch :books :where {:user user} :sort {:read -1})))

(defn create
  "Add new read"
  [raw user]
  (let [[author title] (split raw #" - " 2)
        authors (split author #", ")]
    (with-mongo conn
      (insert! :books {:user user :authors authors :title title
                       :read (java.util.Date.)}))))
