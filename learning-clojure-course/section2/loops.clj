(ns section2.loops)

(defn my-sum [total vals]
  (if (empty? vals)
    total
    (my-sum (+ (first vals) total) (rest vals))))

(my-sum 0 [0 1 2 3 4])
