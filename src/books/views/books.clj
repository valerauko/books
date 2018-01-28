(ns books.views.books
  (:require [hiccup.form :refer :all]
            [clojure.string :refer [join]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn user-wrap
  "Add navbar for user"
  [body]
  [:div
    [:nav [:ul {:class "nav nav-pills justify-content-center"}
      [:li {:class "nav-item"} [:a {:class "nav-link active" :href "/read"} "Add a new read"]]
      [:li {:class "nav-item"} [:a {:class "nav-link" :href "/logout"} "Log out"]]]]
    body])

(defn list-all
  "Show all the reads from the current user"
  [books]
  [:ol {:class "list-group"}
    (map
      (fn
        [{title :title authors :authors}]
        [:li {:class "list-group-item list-group-item-dark"}
          (join ", " authors) " - " title])
      books)])

(defn new
  "Form for a new read"
  []
  (form-to {:class "form-signin"} [:post "/read"]
    (anti-forgery-field)
    (text-field {:class "form-control" :required true} :book)
    (submit-button {:class "btn btn-lg btn-primary btn-block"} "Read it!")))
