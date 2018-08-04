(defproject books "0.1.4"
  :description "Clojure app to track what you read"
  :url "https://books.valerauko.net"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [hiccup "1.0.5"]
                 [congomongo "0.5.2"]
                 [compojure "1.6.1"]
                 [buddy/buddy-hashers "1.3.0"]
                 [ring-logger "1.0.1"]
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler books.handler/app}
  :profiles {:uberjar {:aot :all
                       :uberjar-name "books.jar"}
             :dev {:dependencies [[ring/ring-mock "0.3.2"]]
                   :plugins [[lein-ancient "0.6.15"]]}})
