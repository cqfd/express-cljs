(ns express-cljs.core
  (:require [cljs.nodejs :as n]))

(n/enable-util-print!)

(def express (n/require "express"))

(def app (express.))

(. app (use "/public" (. express (static "public"))))

(. app (get "/"
            (fn [req res]
              (. res (sendfile "public/index.html")))))

(defn main []
  (. app (listen 34567)))

(set! *main-cli-fn* main)
