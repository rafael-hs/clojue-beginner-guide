(ns learning-clojure.section4.javaIntegration
  (:import [java.util Date Calendar]))

(System/currentTimeMillis)

(. (Date.) getTime)
(.getTime (Date.))

(doto (Calendar/getInstance)
  (.set Calendar/YEAR 1985)
  (.set Calendar/MONTH 9)
  (.set Calendar/DATE 26))

(def myarray (into-array String ["this" "is" "an" "array"]))

(aget myarray 1)
(aset myarray 1 "was")

(amap myarray idx ret
      (aset ret idx
            (apply str (reverse (aget myarray idx)))))

(areduce myarray idx ret
         (long 0) (+ ret (count (aget myarray idx))))

(set! *warn-on-reflection* true)

(defn strlen [^String s] (.length  s))
(defn badstrlen [s] (.length s))

(time (reduce + (map badstrlen (repeat 100000 "asdf"))))
(time (reduce + (map strlen (repeat 100000 "asdf"))))

(defn -main [] (println "Done."))