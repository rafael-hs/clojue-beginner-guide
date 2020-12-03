(ns learning-clojure.section7.file)

(def myFilePath "/tmp/test.txt")

(spit myFilePath "Hello Rafael")

(slurp myFilePath)

(require '[clojure.java.io :as io])

(def reader (io/reader myFilePath))
(def lines (line-seq reader))

(.close reader)

(with-open [reader (io/reader myFilePath)
            writer (io/writer (str myFilePath ".out.txt"))]
  (doall (map #(.write writer (apply str (reverse %))) (line-seq reader))))

(slurp (str myFilePath ".out.txt"))