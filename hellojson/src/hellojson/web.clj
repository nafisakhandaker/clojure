(ns hellojson.web
  (:require [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [compojure.handler :as handler]           
            [hellojson.views.layout :as layout]
            [clojure.data.json :as json]
            [compojure.core :refer [defroutes GET POST]]
            [ring.middleware.json :refer [wrap-json-params]]
            [hellojson.controllers.welcome :as welcome])
  (:gen-class))

(defroutes app-routes
 welcome/routes
 (route/resources "/")
 (route/not-found (layout/four-oh-four)))

;(def application (handler/site routes))

(def application (handler/site app-routes
                 wrap-json-params))
        
(defn start [port]
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  "A very simple web app using Ring & Jetty web server"
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))