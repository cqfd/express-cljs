(ns express-cljs.core
  (:require [cljs.nodejs :as n]))

(def express (n/require "express"))

(defn main []
  (let [app (express.)]
    (. app (get "/:name"
                (fn [req res]
                  (let [greeting (str "hello " (.. req -params -name) "!")]
                    (. res (send greeting))))))
    (. app (listen 34567))))

(set! *main-cli-fn* main)
