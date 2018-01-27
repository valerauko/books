(ns books.actions.session
  (:require [books.view :refer [render]]
            [books.views [login :as login]]))

(defn new
  "The login page"
  [session]
  (if session
    {:status 302 :headers {"Location" "/"}}
    (render (login/form))))

(defn destroy
  "Log the user out"
  []
  {:status 302 :headers {"Location" "/login"} :session nil})
