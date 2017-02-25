(ns puzzule.q4)

(defn cutbar-rec [m n current-num]
  (cond
    (>= current-num n) 0
    (< current-num m) (inc (cutbar-rec m n (* 2 current-num)))
    :else (inc (cutbar-rec m n (+ current-num m)))))

(defn cutbar [m n]
  (cutbar-rec m n 1))

(def answer-1 (cutbar 3 20))
(def answer-2 (cutbar 5 100))
