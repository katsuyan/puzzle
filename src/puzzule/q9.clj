(ns puzzule.q9)

(defn path [b g]
  (cond (= b g) 0
        (= (- b g) 9) (path (- b 1) g)
        (or (= b 0) (= g 0)) 1
        :else (+ (path (- b 1) g)
                 (path b (- g 1)))))

(path 19 10)
