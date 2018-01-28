(ns books.actions.books
  (:require [books.models.book :as book]
            [books.views.books :as view]
            [books.view :refer [render]]))

(defn index
  "Top page"
  [user]
  (-> user book/all
           view/list-all
           view/user-wrap
           render))

(defn new
  "Form for a new read"
  [user]
  (render (view/user-wrap (view/new))))

(defn create
  "Add new read"
  ([read] (fn [user] (create user read)))
  ([user read]
    (book/create read user)
    {:status 302 :headers {"Location" "/"}}))
