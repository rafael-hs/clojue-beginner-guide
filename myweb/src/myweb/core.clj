(ns myweb.core
  (:require [compojure.core :refer [context defroutes GET POST]]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]))

(defroutes myapp
  (context "/admin/:id" [id]
    (GET "/login" [] (str "Logging in id: " id))
    (GET "/logout" [] (str "Logging out id: " id)))
  (GET "/" [] "Hello from compojure2")
  (POST "/:name" [] (fn [req] (str "Hello, " (-> req :route-params :name))))
  (GET ["/hex-id/:id" :id #"[a-fA-F0-9]+"] [id] (str "ID: " id))
  (GET "/route1" [] "Hello from route1")
  (GET "/route2" [] "Hello from route2")
  ; (route/not-found "404 Not Found")
  (route/resources "/static"))

(myapp {:uri "/hex-id/ham" :request-method :get})
(myapp {:uri "/static/teste.txt" :request-method :get})
(myapp {:uri "/admin/2/login" :request-method :get})

; (defn myapp [request]
;   (str "Hello, " (get (:params request) "name")))

; (defn string-response-middleware [handler]
;   (fn [request]
;     (let [response (handler request)]
;       (if (instance? String response)
;         {:body response
;          :status 200
;          :headers {"Content-Type" "text/html"}}
;         response))))

; (def handler
;   (-> myapp
;       string-response-middleware
;       wrap-params))

(defn -main []
  (jetty/run-jetty myapp {:port 3000}))
