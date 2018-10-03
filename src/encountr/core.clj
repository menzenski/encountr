(ns encountr.core
  (:require [carica.core :as carica]
            [encountr.spec-builder.config.core :as config]
            [encountr.client.core :as client]))

(defn- main
  "Generate a combat encounter from a provided configuration file."
  []
  (let [encounter-config (-> :encounter carica/config config/config*)]
    (when-let [monsters (some-> encounter-config :monsters)]
      (doall (map #(println (with-out-str (clojure.pprint/pprint (client/get-by-name :monsters (:name %))))) monsters)))
    (println (with-out-str (clojure.pprint/pprint encounter-config)))))
