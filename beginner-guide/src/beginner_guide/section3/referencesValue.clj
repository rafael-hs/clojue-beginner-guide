(ns beginner-guide.section3.referencesValue)

(defn refs []
  (def amount (ref 100))
  (println @amount)

  (dosync
   (ref-set amount 1002))
  (println @amount)

  (dosync
   (alter amount inc))
  (println @amount))
(refs)