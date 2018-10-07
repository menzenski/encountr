(ns encountr.tools.initiative
  (:require [encountr.tools.dice :as dice]))

(defn roll-initiative
  [{:keys [name initiative]}]
  (->> (dice/roll 1 20)
       (+ initiative)
       (assoc {:label name} :score)))
