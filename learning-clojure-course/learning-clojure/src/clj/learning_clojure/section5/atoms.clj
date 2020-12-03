(ns learning-clojure.section5.atoms)

(def count (atom 0 :validator integer?))
;(reset! count 1)


;get variable
;(deref count)
; or
;@count

(defn showAtomsMutable []
  (dotimes [_ 1000]
		;(future (reset! count (inc @count)))
    (future (swap! count inc)))

  @count)