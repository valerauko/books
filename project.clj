(defproject books "0.0.1"
  :description "Vale reading"
  :url "https://valerauko.net/books"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :main ^:skip-aot books.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
