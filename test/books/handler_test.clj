(ns books.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [books.handler :refer :all]))

(deftest main-route
  (testing "redirects to /login without auth"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 302))
      (is (=
        (first (re-seq #"/login$" (get (:headers response) "Location")))
        "/login")))))

(deftest not-found-route
  (testing "status 404 render"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
