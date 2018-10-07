(ns encountr.spec.helpers.ability-scores
  (:require [clojure.spec.alpha :as s]))

(s/def ::name #{:strength :dexterity :constitution :intelligence :wisdom :charisma})

(s/def ::score int?)

(s/def ::modifier int?)

(s/def ::ability-score (s/keys :req-un [::name ::score ::modifier]))
