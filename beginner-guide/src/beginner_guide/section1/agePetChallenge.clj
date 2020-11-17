(ns beginner_guide.section1.challenge1 (:gen-class))

; My implementation
(defn agePetToHuman
  "Given the age of a pet in human years"
  [age]
  (println "dog age:" (* age 7))
  (println "cat age:" (* age 5))
  (println "fish age:" (* age 10)))

(agePetToHuman 20)

; teacher implementation

(defn petToHumanAge
  "This function returns the age of a pet in human years"
  [x]
  (def petStore {'dog 7, 'cat 5, 'fish 10})
  (get petStore x))

(defn age
  "This function returns the age of a pet"
  [petName petType petAge]
  (def ratio (petToHumanAge petType))
  (println petName "is" (* ratio petAge) "years old in human years"))

(age "Link" 'dog 5)
(age "Dante" 'cat 2)
(age "Nemo" 'fish 3)