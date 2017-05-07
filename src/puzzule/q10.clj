(ns puzzule.q10)

(def european [0 32 15 19 4 21 2 25 17 34 6 27 13 36 11 30 8 23
               10 5 24 16 33 1 20 14 31 9 22 18 29 7 28 12 35 3 26])

(def american [0 28 9 26 30 11 7 20 32 17 5 22 34 15 3 24 36 13 1
               00 27 10 25 29 12 8 19 31 18 6 21 33 16 4 23 35 14 2])

(defn sum-max-recur [roulette-2 n m c-max]
  (if (< m 0) c-max
              (recur roulette-2 n (dec m) (max c-max (reduce + (take n (subvec roulette-2 m)))))))

(defn sum-max [roulette n]
  (sum-max-recur (vec (concat roulette roulette)) n (dec (count roulette)) 0))

(defn get-answer [n-min n-max count]
  (if (> n-min n-max) count
      (recur (inc n-min)
             n-max
             (if (> (sum-max american n-min) (sum-max european n-min)) (inc count)
                                                                       count))))

(def answer (get-answer 2 36 0))
