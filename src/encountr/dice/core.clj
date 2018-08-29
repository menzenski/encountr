(ns encountr.dice.core)

(defn- string->int
  [s]
  (->> s (re-find #"\d+") (Integer.)))

(defn parse
  [string]
  (let [[_ dice faces] (re-find #"(\d+)d(\d+)" string)]
    {:dice (string->int dice) :faces (string->int faces)}))

(defn roll
  ([string]
   (let [{:keys [dice faces]} (parse string)]
     (roll dice faces)))
  ([dice faces]
   nil))
