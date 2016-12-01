(def N 100)
(def start-num 2)
(def cards (for [x (range 1 (inc N)) y [false]] [x y]))

(defn reverse-cards [cards num]
  (map #(if (= 0 (mod (first %) num))
            [(first %) (not (second %))]
            %)
       cards))

(defn reverse [cards num]
  (if (= num N)
      (reverse-cards cards num)
      (reverse (reverse-cards cards num) (inc num))))

(defn get-answer []
  (map #(first %)
      (filter #(not (second %))
              (reverse cards start-num))))
