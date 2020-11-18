(ns beginner_guide.section2.sequences)

(defn Seq []
  (let [colors (seq ["red" "green" "blue"])]
    (println colors)

    (println (cons "yellow" colors))
    (println (cons colors "yellow"))

    (println (conj colors "yellow"))
    (println (conj ["red" "green" "blue"] "yellow"))

    (println (concat colors (seq ["black" "white"])))
    (println (distinct (seq [1 2 3 4 5 4 3 6 7])))

    (println (reverse colors))
    (println (first colors))
    (println (rest colors))
    (println (last colors))

    (println (sort (seq [3 223 3 4 453 16 7 1])))))
(Seq)