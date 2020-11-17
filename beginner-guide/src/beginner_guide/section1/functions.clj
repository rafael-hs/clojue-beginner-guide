(ns beginner_guide.section1.functions
  (:gen-class))

(defn -main
  "First function"
  []
  (println "Hello my name is John")
  (prn "loving Clojure so far")
  (+ 2 5))

;; ways to create a function
;fn (+ 2 2)
;#(+ 2 2)
;#(println "Hello" %)

(def increment
  (fn [x] (+ x 1)))

(defn increment_set
  [x]
  (map increment x))

(increment_set [1 2 3 4])