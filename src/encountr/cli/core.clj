(ns encountr.cli.core
  (:require [clojure.tools.cli :as cli]))

(def cli-options
  [["-n" "--name NAME" "Name"]
   ["-c" "--count COUNT" "Count" :parse-fn #(Integer/valueOf %)]
   ["-r" "--[no-]roll" "Roll rather than use default values"]
   ["-h" "--help" "Show help"]])

(defn main
  "Generate a combat encounter from the provided options.

  `lein run -- monster -k Bugbear -c 2 monster -k Owlbear -r`"
  [& args]
  (let [{:keys [options arguments errors summary] :as parsed-options} (cli/parse-opts args cli-options :in-order true)]
    (println (with-out-str (clojure.pprint/pprint options)))
    (cond
      (:help options) (println summary)
      :else (condp = (some-> arguments first keyword)
              :monster (apply main (rest arguments))
              (println summary)))))

