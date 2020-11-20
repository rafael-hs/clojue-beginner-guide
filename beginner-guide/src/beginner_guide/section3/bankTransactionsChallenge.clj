(ns beginner-guide.section3.bankTransactionsChallenge)

(def buyerAccount (ref 100))
(def merchantAccount (ref 0))
(def prices {'pen 1, 'notebook 5, 'backpack 90})
(def items (ref []))

(defn printInfo []
  (println "\nPrintInfo:")
  (println "\nbuyerAccount:" @buyerAccount)
  (println "\nmerchantAccount:" @merchantAccount)
  (println "\nItems:"  @items))

(defn buy
  [item]
  (def itemPrice (get prices item))
  (if (<= itemPrice @buyerAccount)
    (dosync
     (ref-set merchantAccount (+ @merchantAccount itemPrice))
     (ref-set  buyerAccount (- @buyerAccount itemPrice))
     (def newItems (cons item @items))
     (ref-set items newItems))
    (println "Insufficient funds"))
  (printInfo))

(buy 'pen)
(buy 'notebook)
(buy 'notebook)
(buy 'backpack)
(buy 'notebook)
