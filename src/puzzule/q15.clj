(ns puzzule.q15)

(def n 10)
(def steps 4)

(defn move-pares [max-num]
  (for [i (range 1 (inc max-num))
        j (range 1 (inc max-num))] [i j]))

(defn move [steps a b cnt]
  (cond
    (> a b) 0
    (= a b) 1
    :else (+ cnt
             (reduce + (map (fn [move-pare] (apply #(move steps (+ a %1) (- b %2) cnt) move-pare))
                            (move-pares steps))))))

(move steps 0 n 0)
