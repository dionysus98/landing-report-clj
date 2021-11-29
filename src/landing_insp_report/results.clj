(ns landing-insp-report.results)

(defrecord createResult [el result reqNum])

(def soil-one (createResult. "pH" 7.5 [6.5 7.5]))
(def soil-two (createResult. "Electric Conductivity(EC)" 0.12 1.0))
(def soil-three (createResult. "Organic Carbon (OC)" 4069.80 5110.00))

(def mainEl-one (createResult. "Nitrogen (N)" 180.00 184.00))
(def mainEl-two (createResult. "Phosphours (P2O5)" 11.45 37.76))
(def mainEl-three (createResult. "Potassium (K2O)" 80.64 178.80))

(def otherEl-one (createResult. "Sulfur (S)" 11.17 7.98))
(def otherEl-two (createResult. "Iron (Fe)" 2.0 2.00))
(def otherEl-three (createResult. "Zinc (Zn)" 0.72 0.48))
(def otherEl-four (createResult. "Copper (Cu)" 0.06 0.16))
(def otherEl-five (createResult. "Boron (B)" 0.47 0.40))

(def results [soil-one soil-two soil-three mainEl-one mainEl-two mainEl-three otherEl-one otherEl-two otherEl-three otherEl-four otherEl-five])
