(ns encountr.spec.monster.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]
            [encountr.spec.helpers.core :as helpers]))

(s/def ::_id string?)

(s/def ::index (s/and int? #(> % 0)))

(s/def ::name string?)

(s/def ::size ::helpers/size)

(s/def ::alignment ::helpers/alignment)

(s/def ::armor-class ::helpers/armor-class)

(s/def ::hit-points ::helpers/hit-points)

(s/def ::hit-dice ::helpers/hit-dice)

(s/def ::monster (s/keys :req-un [::_id ::index ::name ::size ::alignment ::armor-class ::hit-points ::hit-dice]))

(defn conform
  [data]
  (core/conform ::monster data))
