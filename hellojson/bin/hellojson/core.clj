(ns hellojson.core
(:require [ring.middleware.reload :refer [wrap-reload]]
          [ring.middleware.json :refer [wrap-json-params]]
          [compojure.core :refer [defroutes GET]]
          [compojure.route :as route]
          [compojure.handler :as handler]
          [ring.adapter.jetty :as jetty]
          [clojure.data.json :as json]))


(def data (json/read-str (slurp "src/clingen.json"):key-fn keyword))

;handler functions

(defn json-response
   "Welcome to json world"
  [request]
  {:status 200
   :body (json/write-str data)
   :headers {"Content-Type" "application/json"}})


(defn welcome
  "Welcome to clojure world"
  [request]
  {:status 200
   :body "<h1>Hello, Clojure World</h1>  <p>Welcome to your first Clojure app.<p>"
   :headers {}})

(defroutes app-routes
      (GET "/" [] json-response)
      (GET "/welcome" [] welcome)
      (route/not-found "Not Found"))

(def app
  (-> app-routes
   wrap-json-params))
        

(defn -main []
  "A very simple web app using Ring & Jetty web server"
  (jetty/run-jetty ;Adaptor
    app
     {:port 8080}))
