(ns encountr.spec-builder.monster.core
  (:require [encountr.spec.monster.core :as spec]
            [encountr.tools.ability-scores :as ability-scores]))

(defn monster*
  [{:keys [_id index name size alignment armor_class hit_points hit_dice url challenge_rating initiative] :as all}]
  (let [challenge-rating (rationalize challenge_rating)
        ability-modifiers (ability-scores/ability-modifiers all)]
    (spec/conform (merge all ability-modifiers {:challenge_rating challenge-rating}))))

(defn monster
  [& {:keys [_id index name size alignment armor_class hit_points hit_dice url challenge_rating initiative] :as all}]
  (monster* all))
