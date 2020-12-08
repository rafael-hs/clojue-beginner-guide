(ns blogapp.core
  (:require [net.cgrand.enlive-html :as enlive]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [resources]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]
            [markdown.core :refer [md-to-html-string]]))

;; create a interfaces
(defrecord Tweed [title content])
(defrecord AtomStore [data])

(defprotocol TweedStore
  (get-tweeds [store])
  (put-tweed! [store tweed]))

(extend-protocol TweedStore
  AtomStore
  (get-tweeds [store]
    (get @(:data store) :tweeds))
  (put-tweed! [store tweed]
    (swap! (:data store)
           update-in [:tweeds] conj tweed)))

(def store (->AtomStore (atom {:tweeds '()})))

(get-tweeds store)
(put-tweed! store (->Tweed "Test Title4" "test content2"))

(enlive/defsnippet tweed-tmpl "tweedler/index.html"
  [[:article.tweed enlive/first-of-type]]
  [tweed]
  [:.title] (enlive/html-content (:title tweed))
  [:.content] (enlive/html-content (md-to-html-string (:content tweed))))

(enlive/deftemplate index-tmpl "tweedler/index.html"
  [tweeds]
  [:section.tweeds] (enlive/content (map tweed-tmpl tweeds))
  [:form] (enlive/set-attr :method "post" :action "/"))

(defn handler-create [{{title "title" content "content"} :params}]
  (put-tweed! store (->Tweed title content))
  {:body "" :status 302 :headers {"Location" "/"}})

(defroutes app-routes
  (GET "/" [] (index-tmpl (get-tweeds store)))
  (POST "/" req (handler-create req))
  (resources "/css" {:root "tweedler/css"})
  (resources "/img" {:root "tweedler/img"}))

(def app (-> app-routes
             (wrap-params)))

(def server (jetty/run-jetty #'app {:port 3000 :join? false}))

