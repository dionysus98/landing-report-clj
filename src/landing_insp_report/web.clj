(ns landing-insp-report.web
  (:require
   [ring.adapter.jetty :as jetty]
   [compojure.handler :as ch]
   [landing-insp-report.handler :as blog]))

(defn -main [& args]
  (let [port 3000]
    (jetty/run-jetty (ch/site #'blog/app)
                     {:port port
                      :join? false})))