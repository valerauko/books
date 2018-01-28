(ns books.actions.session
  (:require [books.view :refer [render]]
            [books.views [login :as login]]
            [books.models.user :refer [id-by-login]]))

(defn new
  "The login page"
  [session]
  (if session
    {:status 302 :headers {"Location" "/"}}
    (render (login/form))))

(defn create
  "Auth user and create session"
  [email pass]
  (let [id (id-by-login email pass)]
    (if id
      {:status 302 :headers {"Location" "/"} :session {:books id}}
      (render (login/form "No such user.")))))

(defn destroy
  "Log the user out"
  []
  {:status 302 :headers {"Location" "/login"} :session nil})

(defn wrap-login
  "Redirect people to the login page"
  [user f]
  (if user
    (f user)
    {:status 302 :headers {"Location" "/login"} :body "Please log in."}))
