(ns books.mongo-test
  (:require [clojure.test :refer :all]
            [books.fixtures.mongo-wrap :refer :all]
            [somnium.congomongo :refer :all]))

(use-fixtures :once clear-mongo)

(deftest connection
  (testing "can see test database"
    (is (= (some #(= test-db %) (with-mongo conn (databases)))))))

(deftest write-permission
  (testing "can write test database"
    (let [name (rand-int 1000)]
      (is (=
        (:name (with-mongo conn (insert! :users {:name name})))
        name)))))
