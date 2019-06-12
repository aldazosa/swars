(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            [app.common :refer [<sub >evt]]
            [app.theme :refer [swars-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Button Grid Row Col]]))



(defn app
  []
  [:<>
   [:> Normalize]
   [:> ThemeProvider {:theme swars-theme}
    [:> Button {:on-click #(js/alert "Hi there!")}
     "Click me"]]])


(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (r/render [app]
            (.getElementById js/document "app")))


(defn ^:export init
  []
  (start))
