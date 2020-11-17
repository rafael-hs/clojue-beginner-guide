(ns beginner_guide.section2.loops)

; simple loop
(defn Loop
  []
  (println "\nLoop:")
  (loop [x 0]
    (when (< x 10)
      (println x)
      (recur (inc x)))))
(Loop)

; doTimes type to loop
(defn DoTimes
  []
  (println "\nDoTimes:")
  (dotimes [x 10]
    (println x)))
(DoTimes)

; while do loop
(defn whileDo
  [count]
  (println "\nWhileDo:")
  (let [x (atom 0)]
    (while (< @x count)
      (do
        (println @x)
        (swap! x inc)))))
(whileDo 10)

;
(defn DoSeq
  [seq]
  (println "\nDoSeq:")
  (doseq [x seq]
    (println (inc x))))

(DoSeq [1 2 3 4 5])