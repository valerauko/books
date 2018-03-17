(ns books.views.login
  (:require [hiccup.form :refer :all]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn form
  "Login form"
  ([]
    (form ""))
  ([message]
    (form-to {:class "form-signin"} [:post "/login"]
      (if (> (count message) 0)
        [:div {:class "alert alert-dark" :role "alert"} message])
      (anti-forgery-field)
      [:input {:type "email"
               :class "form-control"
               :placeholder "Email address"
               :name "email"
               :required true}]
      (password-field {:class "form-control"
                       :placeholder "Password"
                       :required true}
                      :password)
      (submit-button {:class "btn btn-lg btn-primary btn-block"} "Log in")
      [:nav {:class "nav nav-pills justify-content-center"}
        [:a {:class "nav-link" :href "/register"} "Want in?"]
        [:a {:class "nav-link text-secondary" :href "/reset"} "Forgot your password?"]])))
