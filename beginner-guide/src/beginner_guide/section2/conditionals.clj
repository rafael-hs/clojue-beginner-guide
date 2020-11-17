(ns beginner_guide.section2.conditionals)

(defn condIf
  []
  (prn "\ncondIf")
  (if (= 5 5)
    (println "Equal")
    (println "Not equal")))
(condIf)

; (defn condIfAlone
;   []
;   (prn "\ncondIfAlone")
;   (if (= 2 2)
;     (println "True")))
; (condIfAlone)

(defn condIfDo
  []
  (prn "\ncondIfDo")
  (if (= 5 5)
    (do (println "equal this is the first statement")
        (println "Second statement"))
    (do (println " Not equal first statement")
        (println "second statement"))))
(condIfDo)

(defn condNestedIf
  []
  (println "\nNestedIf")
  (if (and (= 5 5) (or (= 2 2) (not true)))
    (println "true")
    (println "false")))
(condNestedIf)

; without parameter
; (defn condCase
;   []
;   (println "\ncondCase")
;   (let [pet "dog"]
;     (case pet
;       "cat" (println "I have a cat")
;       "dog" (println "I have a dog")
;       "fish" (println "I have a fish"))))

; with parameter
(defn condCase
  [pet]
  (println "\ncondCase")
  (case pet
    "cat" (println "I have a cat")
    "dog" (println "I have a dog")
    "fish" (println "I have a fish")))
(condCase "cat")

(defn condCond
  [amount]
  (println "\ncondCond")
  (cond
    (<= amount 2) (println "Few")
    (<= amount 10) (println "Several")
    (<= amount 100) (println "Many")
    :else (println "Loads")))

(condCond 132)