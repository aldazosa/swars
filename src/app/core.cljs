(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            [app.common :refer [<sub >evt]]
            [app.theme :refer [swars-theme]]
            [app.people :refer [people-page]]
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Button Grid Row Col]]))


(defn app
  []
  [:<>
   [:> Normalize]
   [:> ThemeProvider {:theme swars-theme}
    [people-page]]])


(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (r/render [app]
            (.getElementById js/document "app")))


(defn ^:export init
  []
  (start))
