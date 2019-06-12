(ns app.people
  (:require
   [re-frame.core :refer [reg-sub]]
   [app.common :refer [<sub]]
   ["@smooth-ui/core-sc" :refer [Box Typography]]
   ["styled-icons/fa-solid/BirthdayCake" :refer [BirthdayCake]]
   ["styled-icons/boxicons-regular/Planet" :refer [Planet]]))


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
  [{:keys [name image birth_year homeworld]}]
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

   [:> Box {:pl      2  ;; birth year
            :pb      2
            :display "flex"}
    [:> Box {:display     "flex"
             :align-items "center"
             :pl          5}
     [:> BirthdayCake {:size 16}]
     [:> Box {:pl 10} birth_year]]]

   [:> Box {:pl      2
            :pb      2
            :display "flex"}
    [:> Box {:display     "flex"
             :align-items "center"
             :pl          5}
     [:> Planet {:size 16}]
     [:> Box {:pl 10} homeworld]]]])


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
