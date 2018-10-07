(ns encountr.tools.initiative
  (:require [encountr.tools.dice :as dice]))

(defn roll-initiative
  [{:keys [name initiative-modifier]}]
  (->> (dice/roll 1 20)
       (+ initiative-modifier)
       (assoc {:label name} :score)))
