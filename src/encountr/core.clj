(ns encountr.core
  (:require [clojure.tools.cli :as cli]))

(def cli-options
  [["-h" "--help"]])

(defn- main
  [& args]
  (cli/parse-opts args cli-options))

