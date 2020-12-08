(ns myweb2.interface)

(defprotocol UserStore
  (get-user-by-email [store email])
  (put-user! [store user]))

(defrecord AtomStore [data])
(defrecord DBStore [db-spec])
; (atom {:users []})

(extend-protocol UserStore
  AtomStore
  (get-user-by-email [store email]
    (let [users (:users @(:data store))]
      (first (filter #(= (:email %) email) users))))
  (put-user! [store user]
    (swap! (:data store) update-in [:users] conj user))

  DBStore
  (get-user-by-email [store email]
    ;... implementation
    )
  (put-user! [store user]
      ;... implementation
    ))

(def store (->AtomStore (atom {})))

(put-user! store {:email "test2@example.com"})

(get-user-by-email store "test2@example.com")

(defn wrap-store-middleware [handler store]
  (fn [request]
    (handler (assoc request :store store))))

(defn myapp [request]
  {:body "Hello" :status 200 :headers {"Content-Type" "text/html"}})

(def handler (-> myapp
                 (wrap-store-middleware (->AtomStore (atom {})))))