(ns beginner_guide.section2.descructuring)

(def myVect [1 2 3 4 5])
(def myMap {'name "Rafael" 'lastname "Honório"})

(defn Destruct
  []
  (let [[a b c] myVect] (println a b c))
  (let [[a b & rest] myVect] (println a b rest))
  (let [{a 'name b 'lastname} myMap] (println a b))
  (let [{a 'name b 'lastname c 'noname} myMap] (println a b c)))
(Destruct)