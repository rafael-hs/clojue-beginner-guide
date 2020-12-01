(ns section2.collections)

(def x (list 1 2 3))
(def v [1 2 3])
(cons 0 x)

(print x)

(first x)
(last x)
(nth x 1)

(cons 0 x)
(conj x 0)
(conj v 0)

(type (concat x v))

(def m {:a 1 :b 2})
(type m)
(array-map :a 1 :b 2)
(hash-map :a 1 :b 2)

(assoc {:a 1} :b 2)
(assoc-in {:settings {:a 1 :b 2}} [:settings :a] "a")
(update-in {:settings {:a 1 :b 2}} [:settings :a] inc)

(get m :a)

(def s #{1 2 3})

(conj s 4)
(disj s 3)
(contains? s 3)
(get s 2)