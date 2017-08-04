(ns hellojson.views.welcome
  (:require [hellojson.views.layout :as layout]
            [clojure.data.json :as json]
            [cheshire.core :as json2]
            [hiccup.core :refer [h]]
            [hiccup.form :as form]
            [clojure.java.io :as io]))

;Reading json file using clojure.data.json library
;(def data (json/read-str (slurp "src/test.json"):key-fn keyword)){:key2 "val2", :key1 "val1"}
;Reading json file using cheshire.core library
(def pdata (json2/parse-stream (io/reader "src/test.json")))
(def cdata (get-in pdata ["items" "Cake"]))
(def ddata (get-in pdata ["items" "Donut"]))

(defn json-response
  "Welcome to json world"
  [jsondata]   
  [:table {:class "clingendata"}    
	  [:tr  
    ;(for [elm cdata]
	   [:td  "Key: "                  
           [:ul "Cake: "             
            [:li "cake id: " (get-in cdata [0 "id"])]
            [:li "type: " (get-in cdata [0 "type"])]
            [:li "name: " (get-in cdata [0 "name"])]
            [:li "ppu: " (get-in cdata [0 "ppu"])]
            [:li "batters: " (get-in cdata [0 "batters" "batter" 0 "type"])]];)
            
           [:ul "Donut: " 
            [:li "Donut id: "  (get-in ddata [0 "id"])]
            [:li "type: " (get-in ddata [0 "type"])]
            [:li "name: " (get-in ddata [0 "name"])]
            [:li "ppu: " (get-in ddata [0 "ppu"])]] ;)]
          ]]])
           
           
(defn index [welcome]
  (layout/common "<h1>Hello Json</h1>"                 
                 (json-response [pdata])
                 [:div {:class "clear"}]))
                
                 
