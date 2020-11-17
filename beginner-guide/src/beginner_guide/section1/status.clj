(ns beginner_guide.section1.status (:gen-class))

(defn variables []

  (def status true)
  (def STATUS false)

  (println status)
  (println STATUS))
(variables)
