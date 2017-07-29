(ns puzzule.q12
  (:require [clojure.string :as string]))

(defn ten-chars? [c-list]
  (= 10 (count c-list)))

(defn full-num-10? [num]
  (ten-chars? (distinct (take 10 (string/replace (str (Math/sqrt num)) "." "")))))

(defn full-num-10?? [num]
  (ten-chars? (distinct (take 10 (second (string/split (str (Math/sqrt num)) #"\."))))))

(first (filter full-num-10? (range)))
(first (filter full-num-10?? (range)))
