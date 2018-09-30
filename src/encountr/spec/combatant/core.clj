(ns encountr.spec.combatant.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]
            [encountr.spec.helpers.core :as helpers-spec]))

(s/def ::_id string?)

(s/def ::index (s/and int? #(> % 0)))

(s/def ::name string?)

(s/def ::size ::helpers-spec/size)

(s/def ::alignment ::helpers-spec/alignment)

(s/def ::armor_class ::helpers-spec/armor-class)

(s/def ::hit_points ::helpers-spec/hit-points)

(s/def ::hit_dice ::helpers-spec/hit-dice)

(s/def ::initiative int?)

(s/def ::url ::helpers-spec/url)

(s/def ::combatant (s/keys :req-un [::_id ::index ::name ::size ::alignment ::armor_class ::hit_points ::hit_dice ::url ::initiative]))

(defn conform
  [data]
  (core/conform ::combatant data))

