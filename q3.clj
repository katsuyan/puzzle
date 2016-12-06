(defn make-cards [num]
  (for [x (range 1 (inc num)) y [false]] [x y]))

(defn reverse-cards [cards reverse-num]
  (map (fn [[num side]]
         (if (= 0 (mod num reverse-num))
             [num (not side)]
             [num side]))
       cards))

(defn reverse-recur [cards num]
  (if (= num (count cards))
      (reverse-cards cards num)
      (recur (reverse-cards cards num) (inc num))))

(defn get-answer [card-num start-num]
  (let [cards (make-cards card-num)]
    (map (fn [[num _]] num)
         (filter (fn [[_ side]] (not side))
                 (reverse-recur cards start-num)))))

(def N 100)
(def START 2)
(def answer (get-answer N START))
