(def N 100)
(def START 2)

(defn make-cards [num]
  (for [x (range 1 (inc N)) y [false]] [x y]))

(defn reverse-cards [cards reverse-num]
  (map (fn [[num side]]
         (if (= 0 (mod num reverse-num))
             [num (not side)]
             [num side]))
       cards))

(defn reverse [cards num]
  (if (= num N)
      (reverse-cards cards num)
      (reverse (reverse-cards cards num) (inc num))))

(defn get-answer []
  (let [cards (make-cards N)]
    (map (fn [[num _]] num)
         (filter (fn [[_ side]] (not side))
                 (reverse cards START)))))
