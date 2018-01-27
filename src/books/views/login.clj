(ns books.views.login
  (:require [hiccup.form :refer :all]))

(defn form
  "Login form"
  []
  (form-to [:post "/login"]
    [:h2 "Log in"]
    (text-field :username)
    (password-field :password)
    (submit-button "Log in")))
