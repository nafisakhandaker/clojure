(ns helloworld.core
  (:require [clojure.browser.repl :as repl])
  
(defonce conn
  (repl/connect "http://localhost:9000/repl")
  (js/alert "Hello World")
  
  
  
;(defn handler [request]
;  {:status 200
;   :headers {"Content-Type" "text/plain"}
;   :body "Hello Clojure, Hello Ring!"})

;(defn server []
 ;(jetty/run-jetty #'handler {:port 8080 :join? false}))
 
 