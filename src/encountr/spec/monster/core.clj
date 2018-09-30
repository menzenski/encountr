(ns encountr.spec.monster.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]
            [encountr.spec.combatant.core :as combatant-spec]))

(s/def ::monster ::combatant-spec/combatant)

(defn conform
  [data]
  (core/conform ::monster data))
