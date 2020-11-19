(ns beginner_guide.section2.CarCouponChallengeUpdate)

;; (def cars {"bmw" 60000 "ferrari" 100000 "fiat" 20000})

;; (defstruct coupon :Name :Discount)
;; (def validCoupon (struct coupon "20Percent" 0.8))

;; (defn isCouponValid
;;   [coupon]
;;   (let [validCoupon (struct coupon "20Percent" 0.8)]
;;     (if (= (:Name validCoupon) coupon)
;;       true
;;       false)))

;; (defn getCarPrices
;;   [budget coupon]
;;   (if (isCouponValid coupon)
;;     (do (println "The coupon is valid")
;;         (let [discount (:Discount validCoupon)]
;;           (doseq [car cars]
;;             (let [carType (first car)]
;;               (let [price  (last car)]
;;                 (let [priceDiscount (* price discount)]
;;                   (if (<= priceDiscount budget)
;;                     (println "The" carType "costs" priceDiscount))))))))
;;     (do (println "The code is invalid")
;;         (let [discount (:Discount validCoupon)]
;;           (doseq [car cars]
;;             (let [carType (first car)]
;;               (let [price  (last car)]
;;                 (let [priceDiscount (* price discount)]
;;                   (if (<= price budget)
;;                     ((println "The" carType "costs" priceDiscount)))))))))))
;; (getCarPrices 50000 "20Percent")