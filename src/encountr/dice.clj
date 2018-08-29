(ns encountr.dice)

(defn- string->int
  [s]
  (->> s (re-find #"\d+") (Integer.)))

(defn parse
  [string]
  (let [[_ dice faces] (re-find #"(\d+)d(\d+)" string)]
    {:dice (string->int dice) :faces (string->int faces)}))

(defn roll
  "Roll the specified dice and return the result.
  Input may be either a `string` in dice notation, e.g., `(roll \"2d12\")`, `(roll \"5d8\")`, et cetera, or int `dice` and `faces`, e.g.,
  `(roll 2 12)`, `(roll 5 8)`, et cetera. Returns the result of the roll as an int."
  ([string]
   (let [{:keys [dice faces]} (parse string)]
     (roll dice faces)))
  ([dice faces]
   (->> dice
        range
        (reduce (fn [total _] (+ total 1 (rand-int faces))) 0))))
