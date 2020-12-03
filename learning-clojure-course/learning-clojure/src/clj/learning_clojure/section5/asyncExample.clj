(ns learning-clojure.section5.asyncExample
  (:require [clojure.core.async :refer [chan go >! <! go-loop]]
            [clojure.core.async :as async]))

(def myChan (chan))

(defn myProcess [])

(go (println (<! myChan)))

(go (>! myChan "Hello"))

(go-loop []
  (println "!" (<! myChan))
  (recur))

(defn print-listener [chan]
  (go-loop []
    (println (<! chan))
    (recur))
  chan)

(def new-chan (chan))

(defn reverser [in-chan]
  (let [out-chan (chan)]
    (go-loop []
      (>! out-chan (reverse (<! in-chan)))
      (recur))
    out-chan))

(def in-chan (chan))
(def rev-chan (reverser in-chan))
(print-listener rev-chan)

(go (>! in-chan [1 2 3]))

(defn combine-chans [& chans]
  (let [out-chan (chan)]
    (go-loop []
      (let [[value c] (async/alts! chans)]
        (>! out-chan value))
      (recur))
    out-chan))

(def chan1 (chan))
(def chan2 (chan))
(def both-chans (combine-chans chan1 chan2))

(print-listener both-chans)

(go (>! chan2 "test chan2"))

(def in-chan-1 (chan))
(def rev-chan-1 (async/map reverse [in-chan-1]))
(print-listener rev-chan-1)

(go (>! in-chan-1 [3 2 1]))

(def in-chan-2 (chan))
(def sum-chan (async/reduce + 0 in-chan-2))
(go (println (<! sum-chan)))
(go (>! in-chan-2 4))

(async/close! in-chan-2)


