(ns encountr.dice.core-test
  (:require [encountr.dice.core :as dice]
            [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(def ^:private number-of-trials 10000)

(defspec parse-dice-notation-into-dice-and-faces
         number-of-trials
         (prop/for-all [number-of-dice gen/int number-of-faces gen/int]
                       (let [dice-notation (format "%sd%s" number-of-dice number-of-faces)
                             {:keys [dice faces]} (dice/parse dice-notation)]
                         (println (format "number-of-dice %s number-of-faces %s" number-of-dice number-of-faces))
                         (println (format "dice %s faces %s" dice faces))
                         (and (= dice number-of-dice)
                              (= faces number-of-faces)))))
