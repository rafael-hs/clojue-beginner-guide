(ns learning-clojure.section4.callJavaClass
  (:import MyClass))

(def myclass (MyClass. "Rafael"))

(.getName myclass)
