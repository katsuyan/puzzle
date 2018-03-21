(ns puzzule.q16
  (:require [clojure.math.combinatorics :as combo]
            [clojure.math.numeric-tower :as math]))

(defn area-from-pare [pare]
  (apply * pare))

(defn pares [half-line]
  (defn pares-rec [x y pare-list]
    (if (>= y x)
      pare-list
      (recur (dec x) (inc y) (conj pare-list [x y]))))
  (pares-rec (dec half-line) 1 []))

(defn include? [seq key]
  (some #(= key %) seq))

(defn eq_filter [half-line half-line-pares]
  (if (= (area-from-pare [(/ half-line 2) (/ half-line 2)])
          (+ (area-from-pare (first half-line-pares))
             (area-from-pare (second half-line-pares))))
    half-line-pares))

(defn eq_sq? [half-line]
  (map #(eq_filter half-line %)
          (combo/combinations (pares half-line) 2)))

(defn get-min-from-pare-pare [pare-pare]
  (let [gcd1 (apply math/gcd (first pare-pare))
        gcd2 (apply math/gcd (second pare-pare))]
    (math/gcd gcd1 gcd2)))

(defn sq-normalization [pare-pare]
  (let [min-val (get-min-from-pare-pare pare-pare)]
    (map #(map (fn [n] (/ n min-val)) %) pare-pare)))

(defn remove-nil [lst]
  (map #(remove nil? %) lst))

(defn remove-empty [lst]
  (remove empty? lst))

(defn even-list [max]
  (filter #(= 0 (mod % 2)) (range 1 (inc max))))

(defn half-number-in-list [lst]
  (map #(/ % 2) lst))

(defn answer [max]
  (count (distinct
    (map sq-normalization
         (apply concat
           (remove-empty (remove-nil (map eq_sq? (half-number-in-list (even-list max))))))))))
