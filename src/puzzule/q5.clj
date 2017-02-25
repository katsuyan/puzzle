(ns puzzule.q5)

(def coins [10 50 100 500])

(defn exchange-recur [acc money coin-num]
  (cond (or (< coin-num 0) (> acc 15)) 0
        (= money 0) 1
        :else (+ (exchange-recur (inc acc)
                                 (- money (get coins coin-num))
                                 coin-num)
                  (exchange-recur acc
                                  money
                                  (dec coin-num)))))

(defn exchange []
  (exchange-recur 0 1000 3))

(exchange)
