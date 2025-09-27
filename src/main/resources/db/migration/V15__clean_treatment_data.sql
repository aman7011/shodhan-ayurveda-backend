-- Clean up treatment field to focus only on treatment, removing FAQ content

-- SKIN DISEASES - Clean treatment data
UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana, Vamana (as per dosha). Shamana - Neem, Guduchi, Manjistha, Khadira, Haridra; Mahatikta ghrita, Panchatikta ghrita guggulu. External - Nimbadi taila, Jatyadi taila. Lifestyle - Avoid incompatible foods, alcohol; eat light bitter foods, do yoga & pranayama.' WHERE name = 'Psoriasis';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Guduchi, Neem, Manjistha, Haridra. External - Coconut oil, Neem oil, Yashtimadhu taila. Diet - Light, easily digestible foods; avoid milk, curd, sour foods.' WHERE name = 'Eczema';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Vamana, Virechana. Shamana - Haridra, Neem, Shunthi, Guduchi. External - Cooling pastes of sandalwood, aloe vera. Lifestyle - Avoid triggers, cold water, and allergenic foods.' WHERE name = 'Urticaria';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Manjistha, Neem, Haridra, Guduchi. External - Aloe vera gel, Lodhra churna face pack, Triphala wash. Diet - Avoid oily, fried foods; increase fresh fruits, vegetables.' WHERE name = 'Acne';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Khadira, Neem, Haridra, Triphala. External - Application of antifungal herbal pastes, Neem oil, Khadira churna. Lifestyle - Keep skin dry, maintain hygiene, avoid tight clothes.' WHERE name = 'Fungal Infections';

-- JOINT DISEASES - Clean treatment data
UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Basti (especially Tikta Ksheera basti), Virechana. Shamana - Dashamoola, Guggulu (Yogaraj guggulu, Simhanada guggulu). External - Abhyanga with Mahanarayana taila, Pinda taila; Swedana. Lifestyle - Gentle yoga, avoid excessive exertion, maintain healthy weight.' WHERE name = 'Osteoarthritis';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Basti (Niruha, Anuvasana), Raktamokshana. Shamana - Simhanada guggulu, Rasna, Eranda taila. External - Abhyanga, Swedana. Lifestyle - Avoid heavy foods, maintain regular exercise, consume light digestible food.' WHERE name = 'Rheumatoid Arthritis';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Guduchi, Neem, Manjistha, Kaishora guggulu. Lifestyle - Avoid alcohol, red meat, sour foods; increase hydration, use light diet.' WHERE name = 'Gout';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Basti chikitsa, Virechana. Shamana - Dashamoola, Guggulu preparations, Rasna. External - Abhyanga, Swedana. Lifestyle - Yoga (stretching), avoid prolonged sitting, maintain posture.' WHERE name = 'Ankylosing Spondylitis';

-- LIFESTYLE DISEASES - Clean treatment data  
UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Vamana, Virechana, Basti. Shamana - Nishamalaki churna, Gudmar, Jamun, Shilajit. Lifestyle - Regular exercise, yoga (Surya Namaskar, Kapalabhati), avoid heavy/sweet food, practice meditation.' WHERE name = 'Diabetes';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Vamana, Lekhana basti. Shamana - Triphala, Guggulu, Trikatu, Medohara yoga. Lifestyle - Regular exercise, yoga (Surya Namaskar, Kapalabhati), fasting, light diet.' WHERE name = 'Obesity';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Basti. Shamana - Katuki, Bhumiamalaki, Punarnava, Triphala. Lifestyle - Avoid alcohol, reduce fatty food, regular exercise, light diet.' WHERE name = 'Fatty Liver';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Vamana, Virechana, Basti. Shamana - Shatavari, Ashoka, Triphala, Trikatu. Lifestyle - Regular exercise, yoga (Surya Namaskar, Pranayama), avoid junk food, maintain routine.' WHERE name = 'PCOS/PCOD';

-- DIGESTIVE DISEASES - Clean treatment data
UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana. Shamana - Yashtimadhu, Amalaki, Shatavari, Kamdudha rasa. Lifestyle - Avoid spicy food, eat on time, practice pranayama.' WHERE name = 'GERD';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana. Shamana - Amalaki, Yashtimadhu, Musta, Kamdudha rasa. Lifestyle - Eat light food, avoid alcohol, maintain meal timings.' WHERE name = 'Gastritis';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana. Shamana - Shatavari, Amalaki, Yashtimadhu, Kamdudha rasa. Lifestyle - Eat small meals, avoid spicy/oily food, practice pranayama.' WHERE name = 'Acidity';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Basti. Shamana - Triphala, Haritaki, Castor oil. Lifestyle - Drink warm water, eat fiber-rich food, practice yoga (Pawanmuktasana).' WHERE name = 'Constipation';

UPDATE diseases SET treatment = 'Ayurvedic Treatment: Shodhana - Virechana, Basti, Raktamokshana. Shamana - Arshoghni vati, Triphala, Haritaki. External - Kshara sutra, local application of herbal oils. Lifestyle - Avoid constipation, eat high-fiber diet, drink water.' WHERE name = 'Hemorrhoids';