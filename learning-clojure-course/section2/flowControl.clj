(ns section2.flowControl)

(let [x "steve"]
  (print "Hello, " x))

(if (empty? x)
  "X is empty"
  "x is not empty")

(case x
  "Goodbye" :goodbye
  "Hello" :hello
  :nothing)

(def x "Hello")

(cond
  (= x "Goodbye") :goodbye
  (= (apply str (reverse x)) "olleH")  :olleh
  :otherwise :nothing)