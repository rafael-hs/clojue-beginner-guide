(ns beginner_guide.section3.namespaces
  (:require [clojure.string :refer [capitalize]]))
  ; (:require [clojure.string :refer :all]))
  ; (:require [clojure.string]))

(defn -main
  []
  (println (capitalize "hello")))
  ; (println (clojure.string/capitalize "hello")))

(-main)