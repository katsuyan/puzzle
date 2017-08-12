(ns puzzule.q13
  (:require [clojure.math.combinatorics :as combo]))

(defn equal_str_num? [r e a d w i t l k s]
  (if (or (= r 0) (= w 0) (= t 0) (= s 0)
      (>= 10 r e a d w i t l k s)
      (< 0 r e a d w i t l k s))
    false
    (let [read  (+ (* r 1000) (* e 100) (* a 10) d)
          write (+ (* w 10000) (* r 1000) (* i 100) (* t 10) e)
          talk  (+ (* t 1000) (* a 100) (* l 10) k)
          skill (+ (* s 10000) (* k 1000) (* i 100) (* l 10) l)]
      (= (+ read write talk) skill))))

(count (filter #(apply equal_str_num? %) (combo/permutations (range 10))))
