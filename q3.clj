(def N 100)
(def cards (for [x (range 1 (inc N)) y [false]] [x y]))

(defn reverse-cars [cards num]
  (map #(if (= 0 (mod (first %) num))
            [(first %) (not (second %))]
            %)
       cards))
