(ns encountr.spec.monster.core-test
  (:require [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [encountr.spec.monster.core :as monster-spec]))

(deftest monster-spec-test
  (testing "valid monster is valid"
    (is (s/valid? ::monster-spec/monster {:_id "5a52bc6f559f00418e5331ea"
                                          :index 57
                                          :name "Bugbear"
                                          :size "Medium"
                                          :type "humanoid"
                                          :subtype "goblinoid"
                                          :alignment "chaotic evil"
                                          :armor_class 16
                                          :hit_points 27
                                          :hit_dice "5d8"
                                          :speed "30 ft."
                                          :strength 15
                                          :dexterity 14
                                          :constitution 13
                                          :intelligence 8
                                          :wisdom 11
                                          :charisma 9
                                          :stealth 6
                                          :survival 2
                                          :damage_vulnerabilities ""
                                          :damage_resistances ""
                                          :damage_immunities ""
                                          :condition_immunities ""
                                          :senses "darkvision 60 ft. passive Perception 10"
                                          :languages "Common Goblin"
                                          :challenge_rating 1
                                          :special_abilities [{:attack_bonus 0
                                                               :desc "A melee weapon deals one extra die of its damage when the bugbear hits with it (included in the attack)."
                                                               :name "Brute"}
                                                              {:damage_dice "2d6"
                                                               :attack_bonus 0
                                                               :desc "If the bugbear surprises a creature and hits it with an attack during the first round of combat the target takes an extra 7 (2d6) damage from the attack."
                                                               :name "Surprise Attack"}]
                                          :actions [{:damage_bonus 2
                                                     :damage_dice "2d8"
                                                     :attack_bonus 4
                                                     :desc "Melee Weapon: Attack +4 to hit reach 5 ft. one target. Hit 11 (2d8 + 2) piercing damage."
                                                     :name "Morningstar"}
                                                    {:damage_bonus 2
                                                     :damage_dice "2d6"
                                                     :attack_bonus 4
                                                     :desc "Melee or Ranged Weapon Attack: +4 to hit reach 5 ft. or range 30/120 ft. one target. Hit 9 (2d6 + 2) piercing damage in melee or 5 (1d6 + 2) piercing damage at range."
                                                     :name "Javelin"}]
                                          :url "http://www.dnd5eapi.co/api/monsters/57"
                                          :initiative 2}))))
