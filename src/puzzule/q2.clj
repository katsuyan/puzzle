(require '[clojure.string :as string])

(defn palindromes-num? [num1 num2]
  (let [num1-str (str num1)
        num2-str (str num2)]
    (if (>= num2 1000)
      (= num1-str (apply str (reverse num2-str)))
      false)))

(defn join-num [num1 num2]
  (+ (* num2 10) num1))

(defn operators-list []
  (let [operators [* join-num]]
  (for [x operators y operators z operators :when (not= x y z join-num)] [x y z])))

(defn make-numbers-list [num]
  (vec (map read-string (string/split (str num) #""))))

(defn answer? [num]
  (let [opls (operators-list)
        nums (make-numbers-list num)]
        (loop [opls opls]
          (if (empty? opls)
          false
          (do
            (let [ops (first opls)]
              (if (or (palindromes-num? num ((ops 0) ((ops 1) ((ops 2) (nums 3) (nums 2)) (nums 1)) (nums 0)))
                      (palindromes-num? num ((ops 0) ((ops 1) (nums 3) (nums 2)) ((ops 2) (nums 1) (nums 0))))
                      (palindromes-num? num ((ops 0) ((ops 1) (nums 3) ((ops 1) (nums 2) (nums 1))) (nums 0))))
              true
              (recur (rest opls)))))))))

(defn get-answer []
  (loop [num 1000]
    (if (> num 9999) nil
    (do
      (if (answer? num)
      (println num))
    (recur (+ num 1))))))
