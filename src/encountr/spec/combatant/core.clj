(ns encountr.spec.combatant.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]
            [encountr.spec.helpers.core :as helpers]))

(s/def ::_id string?)

(s/def ::index (s/and int? #(> % 0)))

(s/def ::name string?)

(s/def ::size ::helpers/size)

(s/def ::alignment ::helpers/alignment)

(s/def ::armor_class ::helpers/armor-class)

(s/def ::hit_points ::helpers/hit-points)

(s/def ::hit_dice ::helpers/hit-dice)

(s/def ::combatant (s/keys :req-un [::_id ::index ::name ::size ::alignment ::armor_class ::hit_points ::hit_dice]))

(defn conform
  [data]
  (core/conform ::combatant data))

