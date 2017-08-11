(def countries_org ["Brazil", "Croatia", "Mexico", "Cameroon", "Spain", "Netherlands",
                   "China", "Australia", "Colombia", "Greece", "Cote d'Ivoire", "Japan",
                   "Uruguay", "Costa Rica", "England", "Italy", "Switzerland", "Euador",
                   "France", "Honduras", "Argentina", "Bosnia and Herzegovina", "Iran",
                   "Nigeria", "Germany", "Portugal", "Ghana", "USA", "Belgium", "Algeria",
                   "Russia", "Korea Republic"])

(def countries (map #(.toLowerCase %) countries_org))

(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(def a-to-z (map str (char-range \a \z)))

(defn filter-from-initial [initial strs]
  (filter #(= (first %) initial) strs))

(defn max-shiritori [prev countries]
  (let [filtered-countris (filter-from-initial (last prev) countries)]
    (if (= 0 (count filtered-countris))
      0
      (+ 1 (apply max (map #(max-shiritori % (remove #{%} countries)) filtered-countris))))))

(def answer (apply max (map #(max-shiritori % countries) a-to-z)))
