(ns clj.learning-clojure.thread)

;Thread mythread = new Thread () {
; public void run() {
;   System.out.println("Running in a thread");
;   }
;}

(def mythread
  (proxy [Thread] []
    (run [] (println "Running in a thread"))))

(.run mythread)

(import 'java.util.concurrent.Executors)
(def mypool (Executors/newFixedThreadPool 4))

(.submit mypool mythread)

(def myrunnable
  (proxy [Runnable] []
    (run [] (println "Running in a runnable"))))

(.submit mypool myrunnable)

(def myreified
  (reify
    Comparable
    (compareTo [this other] -1)
    Runnable
    (run [this] (println "Running via reify"))))

(.submit mypool myreified)

(.compareTo myreified "Not myreifeid")