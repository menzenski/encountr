(ns encountr.client.core
  (:require [co.dnd5eapi.core :as dnd-5e-api]
            [encountr.client.utils :as client-utils]))

(defn get-by-name
  [resource name]
  (some->> resource
           dnd-5e-api/get
           :results
           (filter #(= name (:name %)))
           first
           :url
           client-utils/get-id
           (dnd-5e-api/get resource :id)))
