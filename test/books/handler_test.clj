(ns books.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [books.handler :refer :all]))

(deftest main-route
  (testing "redirects to /login without auth"
    (let [response (handler (mock/request :get "/"))]
      (is (= (:status response) 302))
      (is (=
        (re-find #"/login$" (get (:headers response) "Location"))
        "/login")))))

(deftest not-found-route
  (testing "status 404 render"
    (let [response (handler (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

(deftest resources
  (testing "can retrieve resources"
    (let [response (handler (mock/request :get "/favicon.png"))]
      (is (= (:status response) 200)))))
