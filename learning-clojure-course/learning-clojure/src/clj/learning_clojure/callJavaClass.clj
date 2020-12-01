(ns clj.learning-clojure.callJavaClass
  (:import java.MyClass))

(def myclass (MyClass. "Rafael"))

(.getName myclass)
