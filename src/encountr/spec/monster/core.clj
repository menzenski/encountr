(ns encountr.spec.monster.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]
            [encountr.spec.combatant.core :as combatant-spec]))

(s/def ::challenge_rating #{0 1/8 1/4 1/2 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 26 30})

(s/def ::monster (s/merge ::combatant-spec/combatant
                          (s/keys :req-un [::challenge_rating])))

(defn conform
  [data]
  (core/conform ::monster data))
