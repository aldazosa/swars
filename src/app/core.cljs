(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            [app.common :refer [<sub]]
            [app.theme :refer [swars-theme]]
            ;; --- personas ---
            ;; [app.personas.views :refer [Personas]]
            ;; [app.personas.views.personas-page :refer [personas-page]]
            ;; app.personas.subs
            ;; app.personas.events
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Button Grid Row Col]]))



(defn app
  []
  [:<>
   [:> Normalize]
   [:> ThemeProvider {:theme swars-theme}
    [:div "Star Wars"]]])


(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (r/render [app]
            (.getElementById js/document "app")))


(defn ^:export init
  []
  (start))
