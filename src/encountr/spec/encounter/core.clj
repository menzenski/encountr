(ns encountr.spec.encounter.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.combatant.core :as combatant-spec]
            [encountr.spec.core :as core]
            [encountr.spec.initiative.core :as initiative-spec]))

(s/def ::name (s/nilable string?))

(s/def ::location (s/nilable string?))

(s/def ::xp int?)

(s/def ::difficulty #{"Easy" "Medium" "Hard" "Deadly"})

(s/def ::initiative-order ::initiative-spec/initiative-order)

(s/def ::combatants (s/coll-of ::combatant-spec/combatant))

(s/def ::encounter (s/keys :req-un [::initiative-order]))

(defn conform
  [data]
  (core/conform ::encounter data))


