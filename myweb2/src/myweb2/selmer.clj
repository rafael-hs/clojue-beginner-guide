(ns myweb2.selmer
  (:require [selmer.parser :as tmpl]))

(tmpl/render "<h1> Hello, {{ name }}</h1>" {:name "Natius"})

(tmpl/render-file "templates/hello.html" {:name "Natius"})

; (require '[clojure.java.io :as io])
; (tmpl/set-resource-path! (io/resource "templates"))

(defn respond-html [s]
  {:body s
   :status 200
   :header {"Content-Type" "text/html"}})

(def respond-tmpl (comp respond-html tmpl/render-file))

(defn myapp [{{name "name"} :params}]
  (respond-tmpl "hello.html"  {:name name}))

; (defn respond-html [template-path template-params]
;   (respond-html (tmpl/render-file template-path template-params)))

(myapp {:params {"name" "rafael"}})