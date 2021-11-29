(ns landing-insp-report.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [landing-insp-report.pages :as pg]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (pg/index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
