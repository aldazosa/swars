(ns app.people
  (:require
   [re-frame.core :refer [reg-sub]]
   [app.common :refer [<sub]]
   ["@smooth-ui/core-sc" :refer [Box Typography]]))


(defn portrait-url
  [image]
  (str "url(/img/" (or image "unknown-person.png") ")"))


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
    {:style {:border-radius "10px 10px 0px 0px";
             :background-size "cover"}
     :background-image (portrait-url (:image character))
     :min-height       "250px"
     :alt              (:name character)}]

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
  [:> Box {:class "cards"}
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
