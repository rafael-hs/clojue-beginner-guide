(ns learning-clojure.core-test
  (:require [clojure.test :refer [is deftest testing]])
  (:require [clojure.core] :refer :all)
  (:require [learning-clojure.core] :refer [foo]))
; [learning-clojure.core :refer :all]


(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest my-test
  (testing "1 + 1 = 2"
    (is (= (+ 1 1) 2)))

  (testing "Ensure 2 - 1 = 1"
    (is (= (- 2 1) 1))))

(deftest foo-test
  (testing "Make sure foo works"
    (is (= (foo "") "Hello, World!"))
    (is (= (foo "Hey, ") "Hey, Hello, World!"))))