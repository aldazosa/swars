(ns app.theme
  (:require ["@smooth-ui/core-sc" :refer [theme]]))


(def swars-theme
  (merge
    (js->clj theme :keywordize-keys true)
    {:black        "#2A2435"
     :primary      "#597496"
     :secondary    "#6D7391"
     :success      "#509d66"
     :info         "#272534"
     :warning      "#ce8d2e"
     :danger       "#f44336"
     :light        "#8D9B9E"
     :dark         "#6D7391"
     :yikTextLight "#ECEFEF"
     :yikTextDark  "#2A2435"

     :borderRadius           "14px"
     :borderRadiusSm         "10px"
     :borderRadiusLg         "18px"
     :modalHeaderBorderColor "white"}))
