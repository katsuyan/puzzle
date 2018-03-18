(ns puzzule.q18)

(defn check [last_n used lst]
  (let [now_lst (get lst last_n)]
    (if (and (every? #(= true %) used) (contains? (first lst) last_n))
      [1]
      (loop [i (first now_lst) now_lst_recur now_lst used_recur used]
        (if (empty? now_lst_recur)
          []
          (let [i-1 (- i 1)]
            (if (= (get used_recur i-1) false)
              (let [result (check i (assoc used_recur i-1 true) lst)]
                (if (empty? result)
                  (concat [i] result)
                  (recur (first now_lst_recur) (rest now_lst_recur) (assoc used_recur i-1 false))))
              (recur (first now_lst_recur) (rest now_lst_recur) used_recur))))))))

(defn square [n]
  (map #(Math/pow % 2) (range 2 (+ 1 (Math/sqrt (* n 2))))))

(defn lll [n i lst]
  (if (< i 1)
    lst
    (recur n (dec i) (assoc lst i (filter #(> % 0) (map #(- % i) (square n)))))))

(check 1 (cons true (take 31 (repeat false))) (lll 32 32 {}))

(map #(lll % % {}) (range 10))
