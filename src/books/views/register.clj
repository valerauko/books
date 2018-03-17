(ns books.views.register
  (:require [hiccup.form :refer :all]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn success
  "Success message"
  [message]
  [:p message])

(defn form
  "General form used by the two below"
  ([title]
    (form "" title))
  ([message title]
    (form-to [:post "/login"]
      [:div
        {:class "form-group"}
        (if (> (count message) 0)
          [:div {:class "alert alert-dark" :role "alert"} message])
        (anti-forgery-field)
        [:input {:type "email"
                 :class "form-control"
                 :placeholder "Email address"
                 :name "email"
                 :required true}]]
      (submit-button {:class "btn btn-lg btn-primary btn-block"} title))))

(defn register
  "Registration form"
  []
  (form "Register"))

(defn reset
  "Password reset form"
  []
  (form "Set password"))
