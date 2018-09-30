(ns encountr.core
  (:require [encountr.cli.core :as cli]))

(defn- main
  "Generate a combat encounter from the provided options.

  `lein run -- monster -k Bugbear -n Steve -c 2 monster -k Owlbear -r`"
  [& args]
  (apply cli/main args))

