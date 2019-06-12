(ns app.people
  (:require
   [re-frame.core :refer [reg-sub]]
   [app.common :refer [<sub]]
   ["@smooth-ui/core-sc" :refer [Box Typography]]))


;;;;;;;;;;;;;;;;;;;
;; Suscripciones ;;
;;;;;;;;;;;;;;;;;;;


(reg-sub
  :characters
  (fn [db _]
    (vals (get-in db [:people]))))



;;;;;;;;;;;;
;; Vistas ;;
;;;;;;;;;;;;

(defn character-card
  [character]
  [:> Box  ;; card
   [:> Box ;; image
    ]

   [:> Box ;; name
    [:> Typography {:variant     "h6"
                    :font-weight 700}
     (:name character)]]

   [:> Box ;; birth year
    ]

   [:> Box ;; homeworld
    ]])


(defn character-list
  [characters]
  [:> Box {:style {:display               "grid"
                   :grid-template-columns "repeat(auto-fill, minmax(250px, 1fr))"
                   :grid-gap              "20 px"
                   :padding-bottom        "50px"}}
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
