(ns app.people
  (:require ["@smooth-ui/core-sc" :refer [Box Typography]]))


(defn people-page
  []
  [:<>
   [:> Box {:display         "flex"
            :justify-content "center"}
    [:> Typography {:variant     "h2"
                    :py          20
                    :font-weight 700}
     "Personajes"]]])
