(ns puzzule.q11)

(def fibs (lazy-cat [1 1]   (map + fibs (rest fibs))))

(defn num-to-digits [num]
  (loop [n num res []]
    (if (zero? n)
      res
      (recur (quot n 10) (cons (mod n 10) res)))))

(defn num-to-digits-sum [num]
  (reduce + (num-to-digits num)))

(defn be-divisible? [num]
  (= 0 (mod num (num-to-digits-sum num))))

(def answer (take 13 (filter be-divisible? fibs)))
