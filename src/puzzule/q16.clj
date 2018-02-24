(ns puzzule.q16
  (:require [clojure.math.combinatorics :as combo]))

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

(count (distinct (filter #(not (nil? %)) (map eq_sq? (map #(/ % 2) (filter #(= 0 (mod % 4)) (range 1 (inc 500))))))))
