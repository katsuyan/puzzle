(defn check-recur [n start]
  (cond (= n start) true
        (= n 1) false
        :else (if (even? n)
                  (check-recur (/ n 2) start)
                  (check-recur (+ (* n) 1) start))))

(defn check [n]
  (check-recur (+ (* n) 1) n))
