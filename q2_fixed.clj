(require '[clojure.string :as str])

(defn reverse-same-num? [num1 num2]
  (= (str num1)
     (str/join (reverse (str num2)))))

(defn join-num [num1 num2]
  (+ (* num2 10) num1))

(def operators
  (let [operators [* join-num]]
    (for [x operators
          y operators
          z operators
          :when (not= x y z join-num)]
      [x y z])))

(defn- parse-long [x]
  (Long/parseLong x 10))

(defn make-numbers-list [num]
  (map parse-long (str/split (str num) #"")))

(defn answer? [num]
  (let [[num1 num2 num3 num4] (make-numbers-list num)]
    (reduce (fn [b [op1 op2 op3]]
              (if-let [result (or (reverse-same-num? num (op1 (op2 (op3 num4 num3) num2) num1))
                                  (reverse-same-num? num (op1 (op2 num4 num3) (op3 num2 num1)))
                                  (reverse-same-num? num (op1 (op2 num4 (op2 num3 num2)) num1)))]
                (reduced result)
                b))
            false
            operators)))

(defn get-answer []
  (doseq [num (range 1000 10000)
          :when (answer? num)]
    (println num)))
