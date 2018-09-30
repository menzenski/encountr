(ns encountr.spec-builder.monster.core-test
  (:require [clojure.test :refer :all]
            [encountr.spec-builder.monster.core :as monster-builder]))

(deftest monster-builder-test
  (testing "valid monster is built and returned"
    (is (= {:_id "123"
            :index 57
            :name "Bugbear"
            :size "Medium"
            :alignment "chaotic evil"
            :armor_class 16
            :hit_points 27
            :hit_dice "5d8"
            :challenge_rating 1
            :url "http://www.dnd5eapi.co/api/monsters/57"
            :initiative 2}
           (monster-builder/monster :_id "123"
                                    :index 57
                                    :name "Bugbear"
                                    :size "Medium"
                                    :alignment "chaotic evil"
                                    :armor_class 16
                                    :hit_points 27
                                    :hit_dice "5d8"
                                    :challenge_rating 1
                                    :url "http://www.dnd5eapi.co/api/monsters/57"
                                    :initiative 2)))))
