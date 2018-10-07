(ns encountr.spec-builder.monster.core
  (:require [encountr.spec.monster.core :as spec]))

(defn monster*
  [{:keys [_id index name size alignment armor_class hit_points hit_dice url challenge_rating initiative] :as all}]
  (spec/conform (assoc all :challenge_rating (rationalize challenge_rating))))

(defn monster
  [& {:keys [_id index name size alignment armor_class hit_points hit_dice url challenge_rating initiative] :as all}]
  (monster* all))
