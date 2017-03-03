(ns puzzule.q6)

(defn check-recur [n start]
  (cond (= n start) true
        (= n 1) false
        :else (if (even? n)
                  (check-recur (/ n 2) start)
                  (check-recur (+ (* n 3) 1) start))))

(defn check [n]
  (check-recur (+ (* n 3) 1) n))

(defn get-answer [n]
  (let [even-nums (range 2 (+ n 1) 2)]
    (count (filter check even-nums))))

(def answer (get-answer 10000))
