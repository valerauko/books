(ns books.actions.users
  (:require [books.view :refer [render]]
            [books.views.register :refer :all]))

(defn new
  "Show registration form"
  [session]
  (if session
    {:status 302 :headers {"Location" "/"}}
    (render (register))))

;(defn send-pass-mail)

(defn create
  "Accept registration"
  [])
