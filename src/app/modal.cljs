(ns app.modal
  (:require [app.common :refer [<sub >evt]]
            ["@smooth-ui/core-sc" :refer [Box Typography Button
                                          Modal ModalContent ModalDialog ModalBody ModalFooter]]))


(defn modal []
  [:> Modal {:opened true}
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
