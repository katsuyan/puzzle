(ns puzzule.q5)

(defn exchange-recur [acc money coin-num coins max]
  (cond (or (< coin-num 0) (> acc max)) 0
        (= money 0) 1
        :else (+ (exchange-recur (inc acc)
                                 (- money (get coins coin-num))
                                 coin-num
                                 coins
                                 max)
                  (exchange-recur acc
                                  money
                                  (dec coin-num)
                                  coins
                                  max))))

(defn exchange [money coins max]
  (let [coin-num (- (count coins) 1)]
    (exchange-recur 0 money coin-num coins max)))

(def answer (exchange 1000 [10 50 100 500] 15))
