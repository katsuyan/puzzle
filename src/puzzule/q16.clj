(ns puzzule.q16
  (:require [clojure.math.combinatorics :as combo]))

(range 1 (inc 500))

(def line 20)
(def half-line (/ line 2))

(defn area [x y]
  (* x y))

(defn area-from-pare [pare]
  (apply * pare))

(area (/ half-line 2) (/ half-line 2))

(defn pares [half-line]
  (defn pares-rec [x y pare-list]
    (if (>= y x)
      pare-list
      (recur (dec x) (inc y) (conj pare-list [x y]))))
  (pares-rec (dec half-line) 1 []))

(pares half-line)

(combo/combinations (pares half-line) 2)

(map #(+ (area-from-pare (first %))
         (area-from-pare (second %)))
     (combo/combinations (pares half-line) 2))

(defn include? [seq key]
  (some #(= key %) seq))

(include? [25 30 33] 25)
