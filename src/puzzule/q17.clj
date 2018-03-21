(ns puzzule.q17)

(def fib-seq
     (lazy-cat [1 1] (map + (rest fib-seq) fib-seq)))

(defn answer [num]
  (last (take (+ num 2) fib-seq)))

(answer 30)
