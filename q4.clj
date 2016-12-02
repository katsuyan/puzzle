(defn cutbar-rec [m n current]
  (cond
    (>= current n) 0
    (< current m) (inc (cutbar-rec m n (* 2 current)))
    :else (inc (cutbar-rec m n (+ current m)))))

(defn cutbar [m n]
  (cutbar-rec m n 1))

(def answer-1 (cutbar 3 20))
(def answer-2 (cutbar 5 100))
