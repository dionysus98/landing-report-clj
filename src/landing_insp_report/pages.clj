(ns landing-insp-report.pages
  [:require [hiccup.page :refer [html5]]
   [landing-insp-report.results :refer [data]]
   [landing-insp-report.images :refer [logo footer]]])



(defn style [& info]
  {:style (.trim (apply str (map #(let [[kwd val] %]
                                    (str (name kwd) ":" val "; "))
                                 (apply hash-map info))))})

(defn unit-conv [num key]
  (let [x #(str (% num) " Kg/Acre")]
    (x key)))

(defn check-result [result]
  (if result
    [:div
     [:div.box
      [:div.success (style :background-color "green")]
      [:div.fail]]
     [:p "પુરતા પ્રમાણમાં છે."]]
    [:div
     [:div.box
      [:div.success]
      [:div.fail (style :background-color "red")]]
     [:p "ઉણપ છે."]]))


(defn td-disp [data kw color header title]
  [:tr (style :background-color color)
   title
   header
   [:td.result (unit-conv (:results data) kw)]
   [:td  (unit-conv (:required data) kw)
    [:br] "ઓછી"]
   [:td (check-result (-> data :indicators kw))]])


;; (def req (:required data))
;; (def res (:results data))

;; (def main-el (into {}
;;                    [(dissoc req :Cu :OC :EC :B :Zn :pH :Fe :S)
;;                     (dissoc res :Cu :OC :EC :B :Zn :pH :Fe :S)])) 

;; (defn req [data kw]
;;   (filter #(= % (for [[k v] (:required data)] k)) (into [] kw)))
;; (defn res [data kw]
;;   (filter #(= % (for [[k v] (:result data)] k)) (into [] kw)))

;; (defn td-disp [data & kw]
;;   (req data kw))

;; (td-disp data :k :n)

(defn base-page [data]
  (html5 {:lang "en"}
         [:head
          [:meta {:charset "UTF-8"}]
          [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
          [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
          [:title "Landing page report"]
          [:style "
                   @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Gujarati:wght@100;200;300;400;500;600;700;800;900&display=swap');
                   * {
  box-sizing: border-box;
}
html {
  font-size: 62.5%;
}
:root {
  --color__green: #085c5c;
  --color__blue-light: #e8fcfc;
  --color__purple-light: #ffe4fc;
  --color__yellow-light: #fffcdc;
  --color__white: #fff;
  --color__black: #000; 
  --font__family-default : 'Noto Sans Gujarati', sans-serif;
}
body {
  width: 800px;
  margin: 0 auto;
  font-family: var(--font__family-default);
}
header p {
  font-size: 1.8rem;
  font-weight: bolder;
  margin: 0;
}
header span {
  font-size: 1.8rem;
  font-weight: normal;
}
header h1 {
  margin-bottom: 0.5rem;
  text-align: left;
  font-size: 3rem;
  display: inline-block;
  border-bottom: 3px solid var(--color__black);
}
.header__details{
  float: left;
  width: 80%;
  height : 14.69rem;
  border-bottom: 4.5px solid black;
  margin-top: 0.75rem;
}
.header__logo{
  float: right;
  width: 20%;
  height : 14.69rem;
  border-bottom: 4.5px solid black;
  margin-top: 0.75rem;
}
.farmer {
  float: left;
  width: 50%;
  border-right: 3px solid var(--color__black) !important;
  padding-top: 0.5rem;
}
.farm { 
  float: right;
  width: 40%;
  line-height: 3rem;
  padding-top: 0.5rem;
  }
.name {
  display: inline-block;
  font-weight: bolder;
  }

table {
  margin: 0 auto;
  width: 100%;
  font-size: 1.2rem;
  font-family: inherit;
  text-align: center;
}
  th{
  font-size: 2.5rem;
  font-weight: 600;
  color: var(--color__white);
  padding: 1rem;
  border: none !important;
  }
  .hdr{
  background-color: var(--color__green);
  border-radius: 4px;
  }
  td{
  font-size: 1.45rem;
  }
  .result {
  font-weight: bold;
  }
  .box{
  width: 80%;
  margin : 0.4rem auto;
  border-radius: 5px;
  background-color: #fff;
  }
  .success,.fail {
  width: 2.2rem;
  height: 2.2rem;
  border-radius: 100%;
  }
  .success {
  display: inline-block;
  margin: 0.4rem 1rem;
  border: 3px solid green;
  }
  .fail {
  display: inline-block;
  margin: 0.4rem 1rem;
  border: 3px solid red;
  }
  footer p,
  footer div {
  text-align: center;
  margin: 0.5rem;
  padding: 0.5rem;
  }
  footer p{
  font-size: 2rem;
  }
  "]]
         [:body
          [:header
           [:div
            [:div.header__details
             [:h1 "જમીન ચકાસણી રીપોર્ટ"]
             [:p "જમીન ચકાસણી કેન્દ્ર: " [:span (str  (-> data :testing-center :name))]]
             [:span (str (-> data :testing-center :address))]
             [:br]
             [:span (str "Number: " (:whatsapp-number data))]]
            [:div.header__logo
             [:img {:src logo :width "125rem"}]]]
           [:div
            [:div.farmer
             [:p "ખેડૂતનું નામ: " [:span.name (:farmer-name data)]]
             [:p "પીન કોડ: " [:span (:farmer-pincode data)]]
             [:p "પાકનું નામ: " [:span (:crop-name data)]]
             [:p "વોટ્સએપ નંબર.: " [:span (:whatsapp-number data)]]]
            [:div.farm
             [:p "ખેતરનું નામ: " [:span (:farm-name data)]]
             [:p "સેમ્પલ તારીખ: " [:span (:sample-date data)]]
             [:p "ચકાસણીની તારીખ: " [:span (:test-date data)]]]]]
          [:table (style :border-collapse "collapse")
           [:tbody
            [:tr.hdr (style :border-radius "5px")
             [:th ""]
             [:th "તત્વો"]
             [:th "પરિણામ"]
             [:th "જરૂરી સંખ્યા"]
             [:th "પ્રમાણ"]]
            [:tr (style :background-color "var(--color__blue-light)")
             [:td {:rowspan 3} "જમીનના ઘટક તત્વો"]
             [:td "1] pH"]
             [:td.result (str (-> data :results :pH))]
             [:td (clojure.string/join " - " (-> data :required :pH))
              [:br] "ની વચ્ચે"]
             [:td (check-result (-> data :indicators :pH))]]
            [:tr (style :background-color "var(--color__blue-light)")
             [:td "2] ઈલેક્ટ્રીકલ કંડક્ટીવિટી (EC)"]
             [:td.result (str (-> data :results :EC) "dS/m")]
             [:td  (-> data :required :EC) " dS/m" [:br] "થી ઓછી"]
             [:td (check-result (-> data :indicators :EC))]]
            [:tr (style :background-color "var(--color__blue-light)")
             [:td "3] ઓર્ગેનિક કાર્બન (OC)"]
             [:td.result (unit-conv (:results data) :OC)]
             [:td  (unit-conv (:required data) :OC)
              [:br] "ઓછી"]
             [:td (check-result (-> data :indicators :OC))]]
            (td-disp
             data :n "#fffcdc"
             [:td "4] નાઇટ્રોજન (N)"]
             [:td {:rowspan 3} "જમીનના ઘટક તત્વો"])
            (td-disp
             data :p "#fffcdc"
             [:td "5] " "ફોસ્ફરસ (P" [:sub "2"] "O" [:sub "5"] ")"]
             "")
            (td-disp
             data :k "#fffcdc"
             [:td "6] " "પોટેશિયમ (K" [:sub "2"] "O)"]
             "")
            (td-disp
             data :S "#ffe4fc"
             [:td "7] " "સલ્ફર (S)"]
             [:td {:rowspan 5} "સુક્ષ્મ તથા અન્ય તત્વો"])
            (td-disp
             data :Fe "#ffe4fc"
             [:td "8] " "આયર્ન (Fe)"]
             "")
            (td-disp
             data :Zn "#ffe4fc"
             [:td "9] " "ઝીંક (Zn)"]
             "")
            (td-disp
             data :Cu "#ffe4fc"
             [:td "10] " "કોપર (Cu)"]
             "")
            (td-disp
             data :B "#ffe4fc"
             [:td "11] " "બોરોન (B)"]
             "")]]
          [:footer
           [:p "System Approved by Indian Council of Agriculture Research (ICAR) affiliated Institution."]
           [:div
            [:img {:src footer :width "225rem"}]]]]))


(spit "test.html" (base-page data))

(defn index []
  (base-page data))
