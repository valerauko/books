(ns books.models.user
  (:require [books.mongo :refer [conn]]
            [somnium.congomongo :refer :all]
            [clojure.string :refer [trim]]
            [buddy.hashers :as hashers]))

(def salt
  "Read the hash salt from file"
  (trim (slurp ".salt")))

(defn id-by-login
  [email pass]
  (:_id
    (with-mongo conn
      (fetch-one :users :where {
        :email email
        :pass (hashers/derive pass {:alg :pbkdf2+sha3-256 :salt salt})}))))
