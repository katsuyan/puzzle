(ns puzzule.q18)

(defn check [last_n used lst]
  (let [now_lst (get lst last_n)]
    (if (and (every? #(= true %) used) (.contains (vec (get lst 1)) last_n))
      [1]
      (loop [i (first now_lst) now_lst_recur (rest now_lst)]
        (if (nil? i)
          []
          (let [i-1 (- i 1)]
            (if (= (get used i-1) false)
              (let [result (check i (assoc used i-1 true) lst)]
                (if (not (empty? result))
                  (concat [i] result)
                  (recur (first now_lst_recur) (rest now_lst_recur))))
              (recur (first now_lst_recur) (rest now_lst_recur)))))))))

(defn square [n]
  (map #(Math/pow % 2) (range 2 (+ 1 (int (Math/sqrt (* n 2)))))))

(defn lll [n i lst]
  (if (< i 1)
    lst
    (recur n (dec i) (assoc lst i (filter #(> % 0) (map #(- % i) (map int (square n))))))))

(loop [i 2]
  (let [cake (check 1 (vec (cons true (take (dec i) (repeat false)))) (lll i i {}))]
    (if (empty? cake)
      (recur (inc i))
      i)))
