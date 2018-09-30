(ns encountr.spec.initiative.core
  (:require [clojure.spec.alpha :as s]
            [encountr.spec.core :as core]))

(s/def ::score int?)

(s/def ::label string?)

(s/def ::initiative-value (s/keys :req-un [::score ::label]))

(s/def ::initiative-order (s/coll-of ::initiative-value))

(defn conform
  [data]
  (core/conform ::initiative-order data))

