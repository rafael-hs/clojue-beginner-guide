(ns learning-clojure.section6.protocols)

(defprotocol Shape
  (area [this])
  (perimeter [this]))

(defrecord Circle [r]
  Shape
  (area [this] (* (. Math PI) (:r this) (:r this)))
  (perimeter [this] (* 2 (:r this) (. Math PI))))

(area (->Circle 5))
(perimeter (->Circle 5))

(deftype Square [s])

(extend-protocol Shape
  Square
  (area [this] (* (.s this) (.s this)))
  (perimeter [this] (* (.s this) 4)))

(area (->Square 10))
(perimeter (->Square 5))

(import '[java.util Date Calendar])

(defprotocol RoundableDate
  (nearrest-day [this]))

(extend-protocol RoundableDate
  Long
  (nearrest-day [this] (- this (mod this 864000000)))

  Date
  (nearrest-day [this] (Date. (nearrest-day (.getTime this))))

  Calendar
  (nearrest-day [this]
    (doto this
      (.set Calendar/HOUR 0)
      (.set Calendar/MINUTE 0)
      (.set Calendar/SECOND 0)
      (.set Calendar/MILLISECOND 0))))

(nearrest-day (System/currentTimeMillis))
(nearrest-day (Date.))
(nearrest-day (Calendar/getInstance))