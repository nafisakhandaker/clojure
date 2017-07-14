(:require [ring.adapter.jetty :as jetty]
          [hellojson.core :as web])

(run-jetty #'web/app {:port 8080})