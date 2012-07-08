(ns clj-anglr.core
  (:use [clojure.data.json :only [read-json json-str]]
	[compojure.core :only [defroutes GET POST]]
	[compojure.route :only [not-found files]]
	[compojure.handler :only [api]]
	[ring.adapter.jetty :only [run-jetty]]
	[ring.middleware.params :only [wrap-params]]
	[clj-anglr.count :only [count-up]]))

(def messages (atom '()))

(defn add-message [message]
  (reset! messages (cons message @messages)))

(defn get-json [request]
  (read-json (slurp (:body request))))

(defroutes main-routes
  (POST "/send" request (add-message (:message (get-json request))))
  (GET "/fetch" [] (json-str (take 10 @messages)))
  (GET "/count" [] (json-str (count-up)))
  (files "/")
  (not-found "Page not found"))

(defn -main []
  (run-jetty (api main-routes) {:port 8080}))

