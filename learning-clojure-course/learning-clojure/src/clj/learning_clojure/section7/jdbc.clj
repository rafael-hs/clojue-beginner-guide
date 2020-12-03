(ns learning-clojure.section7.jdbc
  (:require [clojure.java.jdbc :as db]
            [jdbc.pool.c3p0 :as pool]))

(def my-db {:subprotocol "postgresql"
            :subname "//127.0.0.1:5432/postgres"
            :user "postgres"
            :password "Pass2020!"})

(def my-pool (pool/make-datasource-spec my-db))

(db/execute! my-pool
             ["DROP TABLE IF EXISTS employees"])

(db/execute! my-pool
             ["CREATE TABLE employees (
               id serial PRIMARY KEY,
               name text,
               email text)"])

(db/execute! my-pool
             ["INSERT INTO employees (name, email) VALUES (?, ?)"
              "Rafael" "rafa.cont@gmail.com"])

(db/insert! my-pool
            "employees"
            {:name "Jackie" :email "jackie@example.com"})

(db/insert! my-pool
            "employees"
            ["name" "email"]
            ["sandrita" "sandrita@example.com"])

(def employees (db/query my-pool ["SELECT * FROM employees"]))
(db/query my-pool ["SELECT * FROM employees WHERE id=? LIMIT 1" 1])
(db/query my-pool ["SELECT * FROM employees"])

(db/update! my-pool
            "employees"
            {:name "Joey"}
            ["name=? AND email=?" "Rafael" "rafa.cont@gmail.com"])

(db/delete! my-pool
            "employees"
            ["name=?" "Jackie"])

(db/with-db-transaction [transaction my-pool]
  (db/delete! transaction "employees" ["name='Jackie'"])
  (db/delete! transaction "employees" ["name=opsdkopsdakdopas"]))

