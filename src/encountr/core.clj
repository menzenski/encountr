(ns encountr.core
  (:require [carica.core :as carica]
            [encountr.spec-builder.config.core :as config-spec-builder]
            [encountr.spec-builder.monster.core :as monster-spec-builder]
            [encountr.client.core :as client]
            [encountr.tools.ability-scores :as ability-scores]
            [encountr.tools.initiative :as initiative]))

(defn- main
  "Generate a combat encounter from a provided configuration file."
  []
  (let [initiative-base (reduce #(assoc %1 %2 []) {} (range -5 26))
        encounter-config (-> :encounter carica/config config-spec-builder/config*)
        monster-initiative-order (some->> encounter-config
                                          :monsters
                                          (map (fn [{:keys [name] :as all}]
                                                 (let [full-monster (client/get-by-name :monsters name)
                                                       dex-modifier (some-> full-monster :dexterity ability-scores/ability-modifier)]
                                                   (assoc full-monster :initiative dex-modifier))))
                                          (map monster-spec-builder/monster*)
                                          (map initiative/roll-initiative))
        other-combatant-initiative-order (some->> encounter-config
                                                  :other-combatants
                                                  (map initiative/roll-initiative))
        initiative-order (->> monster-initiative-order
                              (concat other-combatant-initiative-order)
                              (reduce #(assoc %1 (:score %2) (into [] (sort (concat (get %1 (:score %2)) [(:label %2)])))) initiative-base)
                              (into (sorted-map-by >)))]
    (doall
     (println (with-out-str (clojure.pprint/pprint initiative-order))))
    (println (with-out-str (clojure.pprint/pprint encounter-config)))))
