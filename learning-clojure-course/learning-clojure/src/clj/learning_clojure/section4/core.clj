(ns learning-clojure.section4.core
  (:gen-class)
  ; (:require [clojure.string :as st])
  (:use clojure.string)
  (:import [java.util Date]))

; (require '[clojure.string :as s])
; (require '[clojure.string :refer [split]])
; (require '[clojure.string :refer :all])
; (use 'clojure.string)

; (split "a,b,c" #",")
; (Date.)

(defn foo
  "I don't do a whole lot"
  [x]
  (str x "Hello, World!"))

(comment
  (require '[clojure.test :refer [is testing]]
           (testing "Make sure foo works"
             (is (= (foo "") "Hello, World!"))
             (is (= (foo "Hey, ") "Hey, Hello, World!")))))

(foo "Hey, ")