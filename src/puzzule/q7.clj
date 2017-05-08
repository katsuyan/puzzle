(ns puzzule.q7
  (:require [clj-time.core :as t]
            [clj-time.format :as f]
            [clojure.string :as string]))

(defn- parse-int [x]
  (Integer/parseInt x))

(defn- int-to-binary-string [n]
  (Integer/toBinaryString n))

(defn- binary-string-to-int [n]
  (Integer/parseInt n 2))

(defn reverse-same-binary? [bin]
  (= bin (string/reverse bin)))

(def days (for [n (range)
        :while (not (t/after?
                      (t/plus (t/date-time 1964 10 10) (t/days n))
                      (t/date-time 2020 7 24)))]
  (t/plus (t/date-time 1964 10 10) (t/days n))))

(defn time-to-str [time]
  (let [custom-formatter (f/formatter "yyyyMMdd")]
    (f/unparse custom-formatter time)))

(map binary-string-to-int
    (filter reverse-same-binary?
            (map (comp int-to-binary-string
                       parse-int
                       time-to-str)
                 days)))
