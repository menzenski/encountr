(ns encountr.spec.helpers.core
  (:require [clojure.spec.alpha :as s]
            [cemerick.url :as url]))

(s/def ::dice-notation (s/and string?
                              #(re-matches #"^\d+d\d+$" %)))

(s/def ::size #{"Tiny" "Small" "Medium" "Large" "Huge" "Gargantuan"})

(s/def ::alignment #{"lawful good" "neutral good" "chaotic good" "lawful neutral" "true neutral" "chaotic neutral"
                     "lawful evil" "neutral evil" "chaotic evil" "unaligned"})

(s/def ::armor-class int?)

(s/def ::hit-points int?)

(s/def ::hit-dice ::dice-notation)

(s/def ::url (s/and string?
                    #(try
                       (do (url/url %) true)
                       (catch Throwable _ false))))
