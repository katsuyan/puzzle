(ns puzzule.q15
  (:require [clojure.math.combinatorics :as combo]))

(def n 10)
(def steps 4)

(defn move [a b cnt]
  (cond
    (> a b) 0
    (= a b) 1
    :else (+ cnt
             (reduce + (map (fn [n] (apply #(move (+ a %1) (- b %2) cnt) n))
                            [[1 1] [1 2] [1 3] [1 4] [2 1] [2 2] [2 3] [2 4] [3 1] [3 2] [3 3] [3 4] [4 1] [4 2] [4 3] [4 4]])))))

(move 0 n 0)
(map #(apply + %) (combo/combinations (range 1 5) 2))
