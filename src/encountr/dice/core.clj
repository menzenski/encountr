(ns encountr.dice.core)

(defn parse
  [string]
  (let [[_ dice faces] (re-find #"(\d+)d(\d+)" string)]
    {:dice dice :faces faces}))

(defn roll
  ([string]
   (let [{:keys [dice faces]} (parse string)]
     (roll dice faces)))
  ([dice faces]
   nil))
