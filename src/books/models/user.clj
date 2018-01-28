(ns books.models.user
  (:require [books.mongo :refer [conn]]
            [somnium.congomongo :refer :all]
            [clojure.string :refer [trim]]
            [buddy.hashers :as hashers]))

(defn generate-salt
  "Make a new salt for if there's none"
  []
  (reduce (fn [acc _] (str acc (char (+ (rand-int 94) 32)))) "" (range 512)))

(def salt
  "Read the hash salt from file"
  (let [current-salt (try
                       (trim (slurp ".salt"))
                     (catch Exception e
                       (spit ".salt" "")))]
    (if current-salt
      current-salt
      (do
        (spit ".salt" (generate-salt))
        salt))))

(defn id-by-login
  [email pass]
  (:_id
    (with-mongo conn
      (fetch-one :users :where {
        :email email
        :pass (hashers/derive pass {:alg :pbkdf2+sha3-256 :salt salt})}))))
