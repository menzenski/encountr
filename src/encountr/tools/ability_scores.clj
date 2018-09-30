(ns encountr.tools.ability-scores
  (:require [clojure.math.numeric-tower :as math]))

(defn ability-modifier
  [score]
  (-> score (- 10) (/ 2) math/floor))
