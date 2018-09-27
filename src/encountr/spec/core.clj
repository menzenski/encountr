(ns encountr.spec.core
  (:require [clojure.spec.alpha :as s])
  (:import (clojure.lang Keyword Var)))

(defonce ^{:added "0.1.0" :dynamic true} *log?* true)

;; https://github.com/clojure/spec.alpha/blob/master/src/main/clojure/clojure/spec/alpha.clj#L290
(defn- ->sym
  "Returns a symbol from a symbol or var"
  [x]
  (if (var? x)
    (let [^Var v x]
      (symbol (str (.name (.ns v)))
              (str (.sym v))))
    x))

(defn explain
  {:added "0.1.0"}
  [tag sdef data]
  (let [explanation (assoc (s/explain-data sdef data) ::s/args data)
        explain-str (str tag (->sym sdef) ":\n" (with-out-str (s/explain-out explanation)))]
    (when *log?*
      (print explain-str))
    {:explain-data explanation
     :explain-str explain-str}))

(defmacro conform
  {:added "0.1.0"}
  [^Keyword sdef data & {:keys [^Boolean safe] :or {safe false}}]
  `(let [data# ~data
         sdef# ~sdef
         parsed# (s/conform sdef# data#)]
     (if (= parsed# ::s/invalid)
       (if ~safe
         (do (explain "SAFE CONFORM failure " sdef# data#) nil)
         (let [explanation# (explain "CONFORM failure " sdef# data#)]
           (throw (ex-info (str "Invalid input:\n" (:explain-str explanation#)) (:explain-data explanation#)))))
       data#)))


