(ns app.people
  (:require
   [re-frame.core :refer [reg-sub]]
   [app.common :refer [<sub]]
   ["@smooth-ui/core-sc" :refer [Box Typography]]
   ["styled-icons/fa-solid/BirthdayCake" :refer [BirthdayCake]]))


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
  [{:keys [name image]}]
  [:> Box  ;; card
   [:> Box ;; image
    {:class            "image-card"
     :background-image (portrait-url image)
     :min-height       "250px"
     :alt              name}]

   [:> Box ;; name
    [:> Typography {:variant     "h6"
                    :font-weight 700}
     name]]

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
