(ns express-cljs.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.nodejs :as n]
            [cljs.core.async :refer [<! timeout]]))

(n/enable-util-print!)

(def express (n/require "express"))

(def app (express.))

(. app (use "/public" (. express (static "public"))))

(. app (get "/"
            (fn [req res]
              (go (<! (timeout 1000))
                  (. res (sendfile "public/index.html"))))))

(defn main []
  (. app (listen 34567)))

(set! *main-cli-fn* main)
