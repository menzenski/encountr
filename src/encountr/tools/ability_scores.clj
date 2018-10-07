(ns encountr.tools.ability-scores
  (:require [clojure.math.numeric-tower :as math]))

(defn ability-modifier
  [score]
  (some-> score (- 10) (/ 2) math/floor int))


(defn ability-modifiers
  [{:keys [strength dexterity constitution intelligence wisdom charisma]}]
  {:strength-modifier (ability-modifier strength)
   :dexterity-modifier (ability-modifier dexterity)
   :constitution-modifier (ability-modifier constitution)
   :intelligence-modifier (ability-modifier intelligence)
   :wisdom-modifier (ability-modifier wisdom)
   :charisma-modifier (ability-modifier charisma)})