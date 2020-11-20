(ns beginner-guide.section2.watchers)

(defn watchf []
  (def x (atom 5))
  (add-watch x :xWatcher
             (fn [key atom old-state new-state]
               (println key)
               (println atom)
               (println old-state)
               (println new-state)))
  (reset! x 10)
  (remove-watch x :xWatcher)
  (reset! x 14))
(watchf)