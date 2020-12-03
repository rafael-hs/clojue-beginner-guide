(ns learning-clojure.section6.types)

(deftype MyPerson [name])

(.name (->MyPerson "Rafaelhus"))

(defrecord MyPersonRecord [name])

(map->MyPersonRecord {:name "Rafaqueijos"})

(deftype MyRunnable [name]
  Runnable
  (run [this] (println (.name this))))

(.run (MyRunnable. "Rafelhus"))