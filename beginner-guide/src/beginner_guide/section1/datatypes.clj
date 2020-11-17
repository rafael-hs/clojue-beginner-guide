(ns beginner_guide.section1.datatypes
  (:gen-class))

(defn DateTypes []
  (def a 1) ;integer
  (def b 1.25) ;float
  (def c 1.25e-12) ;scientific notation
  (def d 0xfbfc) ;hexa
  (def e nil) ;null
  (def f true) ;boolean
  (def g "Hello") ;string
  (def h 'thanks) ;keyword

  (println a)
  (println b)
  (println c)
  (println d)
  (println e)
  (println f)
  (println g)
  (println h))

(DateTypes)