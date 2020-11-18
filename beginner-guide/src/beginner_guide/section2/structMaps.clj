(ns beginner_guide.section2.structMaps)


; definition


; (defstruct pet :PetType :PetName)


(def myPet (struct pet "dog" "Fido"))
(def myOtherPet (struct-map pet :PetName "Link" :PetType "cat"))
(def myNewPet (assoc myPet :PetName "Max"))
(def myNewOtherPet (assoc myOtherPet :PetAget 10))

(defn Pets []

  (println myPet)
  (println (:PetName myPet))

  (println myOtherPet)
  (println (:PetName myOtherPet))

  (println myNewPet)
  (println myNewOtherPet))
(Pets)

