(ns beginner-guide.section3.macros)

;; macro is shortcut to another keywords in clojure
(macroexpand-1 '(when true (println "hello")))
;=> (if true (do (println "hello")))