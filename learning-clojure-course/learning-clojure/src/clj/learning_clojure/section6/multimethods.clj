(ns learning-clojure.section6.multimethods)

(defmulti hello :language)

(defmethod hello ::french [_] "Bonjour")
(defmethod hello :default [_] "Hello")
(defmethod hello ::spanish [_] "Hola")
(defmethod hello ::english [_] "Hi")

(hello {:language ::english})

(derive ::cockney ::english)

(isa? ::cockney ::english)