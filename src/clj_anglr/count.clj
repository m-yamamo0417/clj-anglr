(ns clj-anglr.count)

(def count (atom 0))

(defn count-up []
  (reset! count (inc @count)))


