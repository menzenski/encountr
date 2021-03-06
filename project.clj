(defproject encountr "0.1.1-SNAPSHOT"
  :description "A tool for generating 5E combat encounters."
  :url "https://github.com/menzenski/encountr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main encountr.core/main
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/spec.alpha "0.2.168"]
                 [org.clojure/test.check "0.9.0"]
                 [org.clojure/tools.trace "0.7.10"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [com.cemerick/url "0.1.1"]
                 [dnd5eapi "0.1.1-SNAPSHOT"]
                 [sonian/carica "1.2.2"]])
