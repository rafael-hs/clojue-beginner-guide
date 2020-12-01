(ns section2.functions)

(def hello1 (fn []  "hello"))

(hello1)

(#(str "Hello"))

(defn hello2 [] "Hello")
(defn hello [name] (str "Hello ", name))

(hello "Rafael")

(defn helloTittle
  "Greets a person named <name> with their <title>" [name tittle] (str "Hello, " tittle " " name))

(helloTittle "Brazilian" "Admiral")
(require '[clojure.repl :refer [doc]])
(doc helloTittle)

(defn helloTwoArguments
  ([] (helloTwoArguments "World"))
  ([name] (str "Hi, " name)))

(helloTwoArguments)
(helloTwoArguments "Rafael")

(defn helloWithParams [{name :name}]
  (str "Hello, " name))

(helloWithParams {:name "Rafael"})