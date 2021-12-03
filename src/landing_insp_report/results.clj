(ns landing-insp-report.results)

;; (def required {:pH [6.5 7.5]
;;                :EC 1.0
;;                :OC 5110
;;                :N 184
;;                :P2O5 37.36
;;                :K20 178
;;                :s 7.98
;;                :fe 2.0
;;                :zn 0.48
;;                :cu 0.16
;;                :b 0.40})

;; (def result {:pH 7.5
;;              :EC 0.12
;;              :OC 4000
;;              :N 180
;;              :P2O5 12
;;              :K20 80.64
;;              :s 11.178
;;              :fe 2.0
;;              :zn 0.5
;;              :cu 0.06
;;              :b 0.47})

;; (defn x [k]
;;   (let [s #(str (% k) "kg/acre")]
;;     (s :pH)))

;; (x result)


;; (filter #(fn [e] (> (second e) 50)) result)



;; (def strn "Abskmkmdkcmdc")

;; (defn chg-b [strn]
;;   (if (>= (count strn) 9)
;;     (clojure.string/replace strn "b" "W")))

;; (let [x "sldjkfksdfjlskd"]
;;   (if (>= (count x) 10)
;;     (clojure.string/replace "abcwerx" "b" "W")))

;; (float (/ 1000 6))


;; (test-result result required)

;; (def els  (dissoc result :pH :EC))

;; (for [[k v] els]
;;   {k (> (k required) (k result))})


;; (> 1 0.5)

;; (:EC required)



;; (defn check-results)

;; (defrecord createResult [el result reqNum])

;; (def soil-one (createResult. "pH" 7.5 [6.5 7.5]))
;; (def soil-two (createResult. "Electric Conductivity(EC)" 0.12 1.0))
;; (def soil-three (createResult. "Organic Carbon (OC)" 4069.80 5110.00))

;; (def mainEl-one (createResult. "Nitrogen (N)" 180.00 184.00))
;; (def mainEl-two (createResult. "Phosphours (P2O5)" 11.45 37.76))
;; (def mainEl-three (createResult. "Potassium (K2O)" 80.64 178.80))

;; (def otherEl-one (createResult. "Sulfur (S)" 11.17 7.98))
;; (def otherEl-two (createResult. "Iron (Fe)" 2.0 2.00))
;; (def otherEl-three (createResult. "Zinc (Zn)" 0.72 0.48))
;; (def otherEl-four (createResult. "Copper (Cu)" 0.06 0.16))
;; (def otherEl-five (createResult. "Boron (B)" 0.47 0.40))

;; (def results [soil-one soil-two soil-three mainEl-one mainEl-two mainEl-three otherEl-one otherEl-two otherEl-three otherEl-four otherEl-five])



(def farmer-data {:farmer-pincode 382449
                  :farmer-name "Rajesh Patel"
                  :whatsapp-number 6383846284
                  :farm-name "Pehlu"
                  :testing-center {:name "Umiya Agro center"
                                   :address "N-4, Jalaram Complex, Gokulnagar, Ranasan"}
                  :test-date "27 Oct, 2021"
                  :sample-date "27 Oct, 2021"
                  :crop-name "Potato (LR – Lady Ressota)"
                  :required {:Cu 0.20
                             :OC 5997.60
                             :n 176.80
                             :EC 1.00
                             :B 0.50
                             :Zn 1.00
                             :k 192.50
                             :pH [6.5 7.5]
                             :Fe 3.60
                             :S 18.80
                             :p 68.30}
                  :results {:Cu 0.18
                            :OC 6942.60
                            :n 98.28
                            :EC 0.07
                            :B 0.20
                            :Zn 0.58
                            :k 132.33
                            :pH 7.91
                            :Fe 3.31
                            :S 7.25
                            :p 18.22}})


(defn test-result [values required]
  (let [ph (<= (first (:pH required))
               (:pH values)
               (second (:pH required)))
        ec (> 1.0 (:EC values))
        elements (dissoc values :pH :EC)
        rs (into {} (for [[k v] elements]
                      {k (> (k required) (k values))}))]
    (assoc rs
           :pH ph
           :EC ec)))

(def data (assoc farmer-data
                 :indicators
                 (test-result (:results farmer-data) (:required farmer-data))))

