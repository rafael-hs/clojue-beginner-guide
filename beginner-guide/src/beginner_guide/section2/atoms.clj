(ns beginner_guide.section2.atoms)

(defn Atoms []
  (let [amount (atom 100)]
    (println @amount)

    (swap! amount inc)
    (println @amount)

    (reset! amount 110)
    (println @amount)

    (compare-and-set! amount 110 120)
    (println @amount)
    (compare-and-set! amount 110 150)
    (println @amount)))
(Atoms)