(ns gh-trending.core
  (:require [net.cgrand.enlive-html :as html]
            [clj-http.client :as client]))

(def lang-repos
  "Which languages to look up for trending repos."
  ["clojure" "haskell"])

(def gh-trending-url
  "https://github.com/trending?l=")

(def ^:dynamic *repo-selector*
  [[:li.repo-list-item]])

(def ^:dynamic *repo-name*
  [[:li.repo-list-item :h3.repo-list-name :a :span.prefix]])

(def ^:dynamic *repo-prefix*
  [[:li.repo-list-item :h3.repo-list-name :a :span.prefix]])

(def ^:dynamic *repo-url*
  [[:li.repo-list-item :h3.repo-list-name :a]])

(def ^:dynamic *repo-description*
  [[:li.repo-list-item :p.repo-list-description]])

(defn download-trend
  [lang]
  (html/html-resource
   (java.net.URL. (str gh-trending-url lang))))

;;(first (map html/html (html/select (html/html-resource (java.net.URL. "https://github.com/trending?l=clojure")) #{[:li.repo-list-item]} )))



(def extract [node]
  (let [url (first (html/select [node] *repo-url*))
        name (first (html/select [node] *repo-name*))
        description (first (html/select [node] *repo-description*))]
    ))
        
  
