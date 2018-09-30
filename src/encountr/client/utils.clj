(ns encountr.client.utils)

(defn get-id
  [url]
  (re-find "/(\d+)$" url))
