(ns puzzule.q9)

(defn path-recur [b g]
  (cond (or (= b g) (= (- b g) 10)) 0
        (or (= b 0) (= g 0)) 1
        :else (+ (path-recur (- b 1) g)
                 (path-recur b (- g 1)))))

(defn path [b g]
  (path-recur (- b 1) g))

(path 20 10)
