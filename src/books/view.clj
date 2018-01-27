(ns books.view
  (:require [hiccup.page :refer [html5]]))

(defn title
  ([] "Vale reads")
  ([subtitle] (str subtitle " | " (title))))

(defn render
  ([body] (render "Vale reads" body))
  ([title body]
    (html5 {:lang "en"}
      [:head
        [:meta {:charset "utf-8"}]
        [:meta {:http-equiv "Content-Type" :content "text/html; charset=utf-8"}]
        [:meta {:name "viewport" :content "width=device-width, initial-scale=1, shrink-to-fit=no"}]
        [:title title]
        [:link {:type "text/css" :rel "stylesheet"
                :href "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                :integrity "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                :crossorigin "anonymous"}]]
      [:body
        [:h1 title]
        body])))
