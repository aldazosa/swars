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


;;;;;;;;;;;;;
;; Eventos ;;
;;;;;;;;;;;;;

(reg-event-db
  :open-modal
  (fn [db _]
    (assoc db :show-modal true)))


(reg-event-fx
  :close-modal
  (fn [{:keys [db]} _]
    {:db       (dissoc db :show-modal)
     :dispatch [:set-active-character nil]}))


(reg-event-db
  :set-active-character
  (fn [db [_ character]]
    (assoc db :active-character character)))


(defn modal []
  (let [{:keys [name]} (<sub [:active-character])]
    [:> Modal {:opened   (<sub [:show-modal])
               :on-close #(>evt [:close-modal])}
     [:> ModalDialog
      [:> ModalContent
       [:> Typography {:p       15
                       :variant "h4"}
        name]
       [:> ModalBody
        [:> Box
         "El cuerpo"]]
       [:> ModalFooter
        [:> Box
         [:> Button {:variant  "light"
                     :on-click #(>evt [:close-modal])}
          "Cerrar"]]]]]]))
