(ns encountr.spec-builder.config.core
  (:require [encountr.spec.config.core :as spec]))

(defn config*
  [{:keys [encounter] :as all}]
  (spec/conform all))

(defn config
  [& {:keys [encounter] :as all}]
  (config* all))
