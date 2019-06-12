(ns app.people
  (:require
   [re-frame.core :refer [reg-sub]]
   [app.common :refer [<sub]]
   ["@smooth-ui/core-sc" :refer [Box Typography]]))


(reg-sub
  :characters
  (fn [db _]
   (vals (get-in db [:people]))))


(defn character-card
  [character]
  [:> Box (:name character)])


(defn character-list
  [characters]
  [:> Box
   (for [character characters]
     ^{:key (:id character)}
     [character-card character])])


(defn people-page
  []
  (let [chars (<sub [:characters])]
    [:<>
     [:> Box {:display         "flex"
              :justify-content "center"}
      [:> Typography {:variant     "h2"
                      :py          20
                      :font-weight 700}
       "Personajes"]]

     [character-list chars]]))
