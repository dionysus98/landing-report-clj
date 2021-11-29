(ns landing-insp-report.pages
  [:require [hiccup.page :refer [html5 include-css]]
   [landing-insp-report.results :as results]])


(defn base-page [& body]
  (html5
   [:head [:title "Landing Inspection report"]
    (include-css "/css/style.css")]
   [:body
    [:main.main
     [:header.header
      [:div.header__content
       [:div.header__name
        [:h1.header__title "Landing Inspection Report"]
        [:p.header__text "Land testing center:"]]
       [:div.header__info
        [:div.header__info-farmer
         [:p.farmer-info "Farmer Name: TEST"]
         [:p.farmer-info "Pin Code: 121212"]
         [:p.farmer-info "Crop Name: Potato (LR - lady Ressota)"]
         [:p.farmer-info "Whatsapp-No: 9876543210"]]
        [:div.header__info-farm
         [:p.farm-info "Farm Name: TEST"]
         [:p.farm-info "Sample Name: x"]
         [:p.farm-info "Verfication Date: 12/12/22"]]]]
      [:div.header__logo
       [:img.logo__image {:src "https://www.seekpng.com/png/detail/138-1382998_red-lion-head-logo.png" :width "180rem"}]
       [:p.logo__text "Krishimandir"]]]
     body]]))


(defn table-body [results]
  (base-page
   [:div.conatainer
    [:table.table__layout {:border 2 :bordercolor "#333"}
     [:tbody [:tr.table__row
              [:th.table__header "Info"]
              [:th.table__header "Elements"]
              [:th.table__header "Result"]
              [:th.table__header "Req. Number"]
              [:th.table__header "Proportions"]]
      [:tr.table__row
       [:td.table__info {:rowspan 3} "Components of soil"]
       [:td.table__content (str (:el (get results 0)))]
       [:td.table__content (str (:result (get results 0)))]
       [:td.table__content (str "Between " (:reqNum (get results 0)))]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__success]
          [:div.prop-box__none]]
         [:div.prop-text
          [:p.text "Enough"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 1)))]
       [:td.table__content (str (:result (get results 1)) " ds/m")]
       [:td.table__content (str "< " (:reqNum (get results 1)) " ds/m")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__success]
          [:div.prop-box__none]]
         [:div.prop-text
          [:p.text "Enough"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 2)))]
       [:td.table__content (str (:result (get results 2)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 2)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__none]
          [:div.prop-box__fail]]
         [:div.prop-text
          [:p.text "Shortage"]]]]]
      [:tr.table__row
       [:td.table__info {:rowspan 3} "Main Elements"]
       [:td.table__content (str (:el (get results 3)))]
       [:td.table__content (str (:result (get results 3)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 3)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__none]
          [:div.prop-box__fail]]
         [:div.prop-text
          [:p.text "Shortage"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 4)))]
       [:td.table__content (str (:result (get results 4)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 4)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__none]
          [:div.prop-box__fail]]
         [:div.prop-text
          [:p.text "Shortage"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 5)))]
       [:td.table__content (str (:result (get results 5)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 5)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__none]
          [:div.prop-box__fail]]
         [:div.prop-text
          [:p.text "Shortage"]]]]]
      [:tr.table__row
       [:td.table__info {:rowspan 5} "Sub/other elements"]
       [:td.table__content (str (:el (get results 6)))]
       [:td.table__content (str (:result (get results 6)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 6)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__success]
          [:div.prop-box__none]]
         [:div.prop-text
          [:p.text "Enough"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 7)))]
       [:td.table__content (str (:result (get results 7)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 7)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__none]
          [:div.prop-box__fail]]
         [:div.prop-text
          [:p.text "Shortage"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 8)))]
       [:td.table__content (str (:result (get results 8)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 8)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__success]
          [:div.prop-box__none]]
         [:div.prop-text
          [:p.text "Enough"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 9)))]
       [:td.table__content (str (:result (get results 9)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 9)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__none]
          [:div.prop-box__fail]]
         [:div.prop-text
          [:p.text "Shortage"]]]]]
      [:tr.table__row
       [:td.table__content (str (:el (get results 10)))]
       [:td.table__content (str (:result (get results 10)) " kg/acre")]
       [:td.table__content (str "> " (:reqNum (get results 10)) " kg/acre")]
       [:td.table__content
        [:div.table__content-prop
         [:div.prop-box
          [:div.prop-box__success]
          [:div.prop-box__none]]
         [:div.prop-text
          [:p.text "Enough"]]]]]]]
    [:footer.footer
     [:div.table__footer]
     [:p.footer__text "System Approved by Indian Council of Agriculture Research (ICAR) affiliated Institution."]
     [:div.footer__logo
      [:img {:src "/footer.png" :width "225rem"}]]]]))


(defn index []
  (table-body results/results))







