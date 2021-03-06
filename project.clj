(defproject books "0.1.5"
  :description "Clojure app to track what you read"
  :url "https://books.valerauko.net"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [hiccup "1.0.5"]
                 [congomongo "2.2.1"]
                 [compojure "1.6.1"]
                 [mount "0.1.16"]
                 [buddy/buddy-hashers "1.4.0"]
                 [ring-logger "1.0.1"]
                 [ring/ring-core "1.8.1"]
                 [ring/ring-jetty-adapter "1.8.1"]
                 [ring/ring-defaults "0.3.2"]]
  :main ^:skip-aot books.handler
  :jvm-opts ["-Xmx100m" "-server"]
  :jar-name "books-%s-slim.jar"
  :profiles {:uberjar {:uberjar-name "books-%s.jar"
                       :aot :all}
             :dev {:dependencies [[ring/ring-mock "0.4.0"]]
                   :plugins [[lein-ancient "0.6.15"]]}})
