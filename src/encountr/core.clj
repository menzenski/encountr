(ns encountr.core
  (:require [carica.core :as carica]
            [encountr.spec-builder.config.core :as config]))

(defn- main
  "Generate a combat encounter from a provided configuration file."
  []
  (let [encounter-config (-> :encounter carica/config config/config*)]
    (println (with-out-str (clojure.pprint/pprint encounter-config)))))
