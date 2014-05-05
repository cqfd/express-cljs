(defproject express-cljs "0.1.0-SNAPSHOT"
  :description "express + cljs"
  :url "https://github.com/happy4crazy/express-cljs"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [org.clojure/core.async "0.1.301.0-deb34a-alpha"]]

  :node-dependencies [[express "*"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-npm "0.4.0"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "express-cljs"
              :source-paths ["src"]
              :compiler {
                :output-to "out/express-cljs.js"
                :target :nodejs
                :optimizations :simple}}]})
