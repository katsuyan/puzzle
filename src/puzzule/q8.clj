(ns puzzule.q8)

(defn walk [move-num current route]
  (if (some #(= % current) route)
      0
      (if (= move-num 0)
          1
          (+ (walk (dec move-num) [(inc (first current)) (second current)] (conj route current))
             (walk (dec move-num) [(dec (first current)) (second current)] (conj route current))
             (walk (dec move-num) [(first current) (inc (second current))] (conj route current))
             (walk (dec move-num) [(first current) (dec (second current))] (conj route current))))))


(walk 12 [0 0] [])
