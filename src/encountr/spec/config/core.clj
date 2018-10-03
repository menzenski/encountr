(ns encountr.spec.config.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]))

(s/def ::roll-hit-points? boolean?)

(s/def ::name string?)

(s/def ::number int?)

(s/def ::monsters (s/coll-of (s/keys :req-un [::name]
                                     :opt-un [::number])))

(s/def ::initiative-modifier int?)

(s/def ::other-combatants (s/coll-of (s/keys :req-un [::name]
                                             :opt-un [::initiative-modifier])))

(s/def ::config (s/keys :req-un [::roll-hit-points? ::monsters]
                        :opt-un [::other-combatants]))

(defn conform
  [data]
  (core/conform ::config data))
