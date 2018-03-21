(ns puzzule.q17)

(def fib-seq
     (lazy-cat [1 1] (map + (rest fib-seq) fib-seq)))


(last (take 32 fib-seq))
