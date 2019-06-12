(ns app.modal
  (:require [re-frame.core :refer [reg-sub reg-event-db reg-event-fx]]
            [app.common :refer [<sub >evt]]
            ["@smooth-ui/core-sc" :refer [Box Typography Button
                                          Modal ModalContent ModalDialog ModalBody ModalFooter]]))

;;;;;;;;;;;;;;;;;;;
;; Suscripciones ;;
;;;;;;;;;;;;;;;;;;;

(reg-sub
  :show-modal
  (fn [db _]
    (get db :show-modal)))


(reg-sub
  :active-character
  (fn [db _]
    (get db :active-character)))


(reg-sub
  :quote
  (fn [db [_ character-id]]
    (get-in db [:quotes character-id])))


(reg-sub
  :appears-in
  (fn [db [_ character-id]]
    (let [character (get-in db [:people character-id])
          film-ids  (map
                      (comp
                        int
                        second
                        #(re-matches #"https://swapi.co/api/films/(\d+)/" %))
                      (:films character))]
      (->> (get db :films)
           (keep (fn [[k v]]
                   (when (some #{k} film-ids)
                     (:title v))))))))


;;;;;;;;;;;;;
;; Eventos ;;
;;;;;;;;;;;;;

(reg-event-db
  :open-modal
  (fn [db _]
    (assoc db :show-modal true)))


(reg-event-db
  :close-modal
  (fn [db _]
    (-> db
        (dissoc :set-active-character)
        (dissoc :show-modal))))


(reg-event-db
  :set-active-character
  (fn [db [_ character]]
    (assoc db :active-character character)))


;;;;;;;;;;;;
;; Vistas ;;
;;;;;;;;;;;;

(defn modal []
  (let [{:keys [name id]} (<sub [:active-character])
        quote             (<sub [:quote id])]
    [:> Modal {:opened   (<sub [:show-modal])
               :on-close #(>evt [:close-modal])}
     [:> ModalDialog
      [:> ModalContent
       [:> Typography {:pt      15
                       :pl      15
                       :variant "h4"}
        name]
       [:> ModalBody
        [:> Box {:pb 2}
         [:> Typography {:style       {:font-style "italic"}
                         :pb          2
                         :font-family "Consolas"}
          (str "-- " quote)]]
        [:> Box
         [:> Typography {:variant "h6"}
          "Aparece en:"]
         [:ul
          (for [film (<sub [:appears-in id])]
            ^{:key film}
            [:li film])]]]

       [:> ModalFooter
        [:> Box
         [:> Button {:variant  "light"
                     :on-click #(>evt [:close-modal])}
          "Cerrar"]]]]]]))
