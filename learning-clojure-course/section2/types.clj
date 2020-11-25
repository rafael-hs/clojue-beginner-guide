(ns section2.types)

(type 1)
(type 1.1)
(type true)
(type "true")

(type :a)
(type (quote a))
(type 'a)

(type '(1 2 3))
(type (list 1 2 3))
(type [1 2 3])
(type (vector 1 2 3))
(nth (vector 1 2 3) 2)
(last (vector 1 2 3))

(type {:a 1 :b 2})
(type #{1 2 3 4})