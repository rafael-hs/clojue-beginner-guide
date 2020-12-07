(ns myweb2.core
  (:require [net.cgrand.enlive-html :as enlive]))

(enlive/deftemplate hello-tpl "templates/hello2.html"
  [name]
  [:h1] (enlive/html-content (str "Hello, " name)))

(hello-tpl "Rafa")