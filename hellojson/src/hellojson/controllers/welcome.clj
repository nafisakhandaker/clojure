(ns hellojson.controllers.welcome
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]
            [ring.util.response :as ring]
            [hellojson.views.welcome :as view]))

(defroutes routes
  (GET  "/" [] (view/index "welcome"))
  (GET "/displayjson" [] (view/json-response "welcome")))