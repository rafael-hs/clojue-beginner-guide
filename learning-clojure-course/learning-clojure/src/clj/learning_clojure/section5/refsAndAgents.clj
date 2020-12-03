(ns learning-clojure.section5.refsAndAgents)

;(def acct1 (ref 1000 :validator #(>= % 0)))
;(def acct2 (ref 1000 :validator #(>= % 0)))
(def my-agent (agent 0 :validator #(>= % 0) :error-mode :continue
								:error-handler println))

;(send my-agent dec)
;(restart-agent my-agent 0)

(defn transfer [fromAcct toAcct amount]
	(dosync
		(alter toAcct + amount)
		(alter fromAcct - amount)))

;(defn doProcess []
;	(dotimes [_ 5]
;		(future (transfer acct2 acct1 100)))
;	)