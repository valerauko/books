(defproject books "0.1.3"
  :description "Clojure app to track what you read"
  :url "https://books.valerauko.net"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [hiccup "1.0.5"]
                 [congomongo "0.5.1"]
                 [compojure "1.6.0"]
                 [buddy/buddy-hashers "1.3.0"]
                 [ring-logger "0.7.7"]
                 [ring/ring-defaults "0.3.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler books.handler/app}
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[ring/ring-mock "0.3.2"]]}})
