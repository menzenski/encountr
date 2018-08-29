(ns encountr.dice.core-test
  (:require [encountr.dice.core :as dice]
            [clojure.test :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(def number-of-trials 10000)

(defspec parse-dice-notation-into-dice-and-faces
         number-of-trials
         (prop/for-all [number-of-dice gen/pos-int number-of-faces gen/pos-int]
                       (let [{:keys [dice faces]} (dice/parse (format "%sd%s" number-of-dice number-of-faces))]
                         (and (= dice number-of-dice)
                              (= faces number-of-faces)))))
