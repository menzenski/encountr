(ns encountr.client.utils)

(defn get-id
  [url]
  (some->> url
           (re-find #"/(\d+)$")
           second))
