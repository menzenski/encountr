(ns encountr.core
  (:require [carica.core :refer [config]]))

(defn- main
  "Generate a combat encounter from a provided configuration file."
  []
  (let [encounter-config (config :encounter)]
    (println (with-out-str (clojure.pprint/pprint encounter-config)))))
