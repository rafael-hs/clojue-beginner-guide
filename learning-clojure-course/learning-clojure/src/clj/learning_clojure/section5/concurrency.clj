(ns learning-clojure.section5.concurrency)

(instance? Runnable (fn []))

;(.start (Thread. (fn [] (println "Hello"))))

;(promise)

(defn myslowfn []
  (let [p (promise)]
    (.start
     (Thread. (fn []
                (Thread/sleep 3000)
                (deliver p "Hello"))))
    p))

; (deref (myslowfn))
; @(myslowfn)

;(let [p (myslowfn)]
;  (println "Waiting for a promise...")
;  @p)

(defn myslowfn1 []
  (Thread/sleep 3000)
  "Hello")

;@(future (myslowfn1))

(defn slowlog [msg]
  (Thread/sleep 3000)
  (println msg))

(defn myfn []
  (future (slowlog "Called myfn"))
  :ok)


(defn myfn2 []
  (delay (slowlog "Called myfn2"))
  :ok)

(defn fib [n]
  (if (< n 2)
    1
    (+ (fib (- n 1)) (fib (- n 2)))))

(def fib (memoize fib))