(ns app.modal
  (:require [re-frame.core :refer [reg-sub reg-event-db]]
            [app.common :refer [<sub >evt]]
            ["@smooth-ui/core-sc" :refer [Box Typography Button
                                          Modal ModalContent ModalDialog ModalBody ModalFooter]]))

(reg-sub
  :show-modal
  (fn [db _]
    (get db :show-modal)))


(reg-event-db
  :open-modal
  (fn [db _]
    (assoc db :show-modal true)))


(reg-event-db
  :close-modal
  (fn [db _]
    (dissoc db :show-modal)))


(defn modal []
  [:> Modal {:opened   (<sub [:show-modal])
             :on-close #(>evt [:close-modal])}
   [:> ModalDialog
    [:> ModalContent
     [:> Typography {:p       15
                     :variant "h4"}
      "El título"]
     [:> ModalBody
      [:> Box
       "El cuerpo"]]
     [:> ModalFooter
      [:> Box
       "El pie"]]]]])
