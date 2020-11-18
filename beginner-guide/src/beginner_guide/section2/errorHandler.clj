(ns beginner_guide.section2.errorHandler)

(defn ExHandling
  [x]
  (try
    (inc x)
    (catch ClassCastException e (println "Caught exception" (.getMessage e)))
    (catch Exception e (println "Caught generic exception" (.getMessage e)))
    (finally  (println "cleanup and move on")))) ; execute every time in try catch block
; (ExHandling "rafa")
(ExHandling 2)