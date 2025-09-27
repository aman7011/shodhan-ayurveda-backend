-- Clear existing diseases and add new ones with comprehensive Ayurvedic data
DELETE FROM diseases;

-- ===========================================
-- SKIN CATEGORY DISEASES
-- ===========================================

-- Psoriasis (Kitibha Kushta)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Psoriasis',
    (SELECT id FROM categories WHERE name = 'Skin'),
    'Psoriasis is a chronic, immune-mediated inflammatory skin disorder characterized by excessive proliferation of skin cells, producing scaly, thickened, and itchy patches. In Ayurveda, it is correlated with Kitibha Kushta, caused by vitiation of Vata and Kapha doshas with Rakta dhatu dushti. Dosha involvement: Vata + Kapha predominance, Pitta involvement in inflammation. Dhatu: Rakta, Mamsa. Srotas: Raktavaha and Mamsavaha.',
    'Modern: Autoimmune dysfunction, genetics, infections, medications, stress, alcohol. Ayurvedic: Viruddha ahara (incompatible food), excessive sour/salty foods, fermented items, divaswapna (day sleep), suppression of natural urges, stress. Samprapti: Nidana → Agni dushti → Ama formation → Vata & Kapha aggravation → Entry into Raktavaha & Mamsavaha srotas → Rakta dushti → Lesions appear as Kitibha Kushta.',
    'Scaly thick patches, itching, burning, discoloration, pain, sometimes joint stiffness (psoriatic arthritis). Lakshana: Dry, rough, scaly skin with itching, discoloration, and pain.',
    'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana, Vamana (as per dosha). Shamana - Neem, Guduchi, Manjistha, Khadira, Haridra; Mahatikta ghrita, Panchatikta ghrita guggulu. External - Nimbadi taila, Jatyadi taila. Lifestyle - Avoid incompatible foods, alcohol; eat light bitter foods, do yoga & pranayama.',
    '/images/diseases/psoriasis.jpg'
);

-- Eczema (Vicharchika)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Eczema',
    (SELECT id FROM categories WHERE name = 'Skin'),
    'Eczema is an inflammatory skin condition marked by itching, dryness, and recurrent rashes. Ayurvedic correlation: Vicharchika, caused by Kapha and Pitta dosha vitiation with Rakta dushti. Dosha: Kapha + Pitta. Dhatu: Twak, Rakta. Srotas: Raktavaha. Lakshana: Itching, oozing, scaling, thickened skin.',
    'Modern: Genetics, allergies, immune dysfunction, irritants. Ayurvedic: Oily/heavy diet, excess dairy, sour foods, poor digestion, ama accumulation. Samprapti: Nidana (kapha-aggravating foods, ama formation) → Dosha aggravation (Kapha + Pitta) → Rakta dushti → Obstruction in Raktavaha srotas → Vicharchika (eczema).',
    'Intense itching, redness, dry/scaly skin, oozing patches, thickened skin in chronic cases.',
    'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Guduchi, Neem, Manjistha, Haridra. External - Coconut oil, Neem oil, Yashtimadhu taila. Diet - Light, easily digestible foods; avoid milk, curd, sour foods.',
    '/images/diseases/eczema.jpg'
);

-- Urticaria (Shitapitta)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Urticaria',
    (SELECT id FROM categories WHERE name = 'Skin'),
    'Urticaria, or hives, is an allergic skin reaction producing itchy, raised welts. Ayurvedic correlation: Shitapitta, primarily due to Vata and Kapha vitiation with Pitta involvement. Dosha: Vata, Kapha, Pitta. Dhatu: Rasa, Rakta. Srotas: Rasa, Raktavaha. Lakshana: Itchy red patches, wheals, burning, sudden onset.',
    'Modern: Allergens (food, drugs, insect bites), stress, infections. Ayurvedic: Viruddhahara (incompatible food), exposure to cold, indigestion, ama, excessive salty/sour food. Samprapti: Nidana (allergens, incompatible food, cold exposure) → Aggravation of Vata & Kapha → Association with Pitta → Circulation through Rasa & Rakta → Manifestation as welts & itching.',
    'Sudden wheals, redness, severe itching, burning, sometimes fever or breathing difficulty.',
    'Ayurvedic Treatment: Shodhana - Vamana, Virechana. Shamana - Haridra, Neem, Shunthi, Guduchi. External - Cooling pastes of sandalwood, aloe vera. Lifestyle - Avoid triggers, cold water, and allergenic foods. FAQ: Recurrence can be minimized with shodhana and lifestyle correction. Fermented, sour, salty foods, seafood, alcohol worsen hives. Stress is a trigger.',
    '/images/diseases/urticaria.jpg'
);

-- Acne (Yuvana Pidika)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Acne',
    (SELECT id FROM categories WHERE name = 'Skin'),
    'Acne is a common skin condition during adolescence and adulthood, characterized by pimples, blackheads, and scars. Ayurvedic correlation: Yuvana Pidika, caused by vitiation of Kapha, Vata, and Rakta. Dosha: Kapha + Vata + Rakta. Dhatu: Rakta, Meda. Srotas: Raktavaha, Swedavaha. Lakshana: Pustules, papules, oily skin, scarring.',
    'Modern: Hormonal changes, oily skin, bacterial infection, diet, stress. Ayurvedic: Excess oily, spicy food; irregular lifestyle; hormonal imbalance; ama. Samprapti: Nidana (junk food, excessive oil, hormonal imbalance) → Agni dushti → Kapha + Vata aggravation → Rakta dushti → Blockage of srotas → Yuvana Pidika.',
    'Pimples, blackheads, pustules, redness, scarring, oily skin.',
    'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Manjistha, Neem, Haridra, Guduchi. External - Aloe vera gel, Lodhra churna face pack, Triphala wash. Diet - Avoid oily, fried foods; increase fresh fruits, vegetables. FAQ: Herbs like Kumkumadi taila, Aloe vera, and Triphala help with acne scars. Hormonal imbalance is a major factor. Acne can occur in adults too.',
    '/images/diseases/acne.jpg'
);

-- Fungal Infections (Dadru)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Fungal Infections',
    (SELECT id FROM categories WHERE name = 'Skin'),
    'Fungal infections of the skin cause itching, redness, and circular lesions. Ayurvedic correlation: Dadru, primarily caused by Kapha and Pitta dosha vitiation. Dosha: Kapha + Pitta. Dhatu: Twak, Rakta. Srotas: Raktavaha, Twak. Lakshana: Itching, red circular patches, scaling.',
    'Modern: Dermatophyte fungal infection, excessive sweating, unhygienic conditions. Ayurvedic: Kapha-pitta vitiation, eating excessive sweet and sour foods, poor hygiene. Samprapti: Nidana (moisture, unhygienic habits, kapha-pitta aggravating food) → Dosha aggravation → Rakta dushti → Manifestation as Dadru.',
    'Itching, burning, red circular patches, scaling, spreading lesions.',
    'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Khadira, Neem, Haridra, Triphala. External - Application of antifungal herbal pastes, Neem oil, Khadira churna. Lifestyle - Keep skin dry, maintain hygiene, avoid tight clothes. FAQ: Fungal infections are contagious through contact. Ayurveda can fully cure with proper treatment. Excess sugar, oily and fermented foods worsen infections.',
    '/images/diseases/fungal-infections.jpg'
);

-- ===========================================
-- JOINT CATEGORY DISEASES
-- ===========================================

-- Osteoarthritis (Sandhigata Vata)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Osteoarthritis',
    (SELECT id FROM categories WHERE name = 'Joint'),
    'Osteoarthritis (OA) is a degenerative joint disease characterized by the breakdown of cartilage, leading to pain, stiffness, and reduced mobility. Ayurvedic correlation: Sandhigata Vata, caused by vitiation of Vata dosha affecting the joints. Dosha: Vata. Dhatu: Asthi, Majja. Srotas: Asthivaha, Majjavaha. Lakshana: Joint pain, stiffness, crepitus, reduced movement.',
    'Modern: Ageing, obesity, injury, wear & tear, sedentary lifestyle. Ayurvedic: Ruksha ahara (dry food), ati vyayama (excessive exertion), vata aggravating diet, dhatu kshaya. Samprapti: Nidana (ageing, excessive exertion, dry food, trauma) → Vata aggravation → Depletion of Shleshaka Kapha in joints → Degeneration of cartilage → Pain, stiffness, Sandhigata Vata.',
    'Pain, stiffness, reduced flexibility, swelling, crepitus, worsens with activity.',
    'Ayurvedic Treatment: Shodhana - Basti (especially Tikta Ksheera basti), Virechana. Shamana - Dashamoola, Guggulu (Yogaraj guggulu, Simhanada guggulu). External - Abhyanga with Mahanarayana taila, Pinda taila; Swedana. Lifestyle - Gentle yoga, avoid excessive exertion, maintain healthy weight. FAQ: Degeneration cannot be reversed fully but pain and mobility can improve significantly. Panchakarma basti therapy is highly beneficial. Avoid dry, cold, stale, and vata-aggravating foods.',
    '/images/diseases/osteoarthritis.jpg'
);

-- Rheumatoid Arthritis (Amavata)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Rheumatoid Arthritis',
    (SELECT id FROM categories WHERE name = 'Joint'),
    'Rheumatoid Arthritis (RA) is an autoimmune inflammatory disease affecting multiple joints, causing swelling, pain, and stiffness. Ayurvedic correlation: Amavata, caused by the accumulation of Ama with aggravated Vata dosha. Dosha: Vata + Ama. Dhatu: Asthi, Majja. Srotas: Asthivaha, Majjavaha. Lakshana: Pain, swelling, morning stiffness, fatigue.',
    'Modern: Autoimmune reaction, genetics, infections. Ayurvedic: Ama formation due to weak digestion, sedentary lifestyle, incompatible foods. Samprapti: Nidana (heavy diet, sedentary lifestyle, mandagni) → Ama formation → Vata aggravation → Circulation of Ama with Vata → Deposition in joints → Inflammation, pain, swelling.',
    'Joint pain, swelling, stiffness, fatigue, deformity in advanced stages.',
    'Ayurvedic Treatment: Shodhana - Virechana, Basti (Niruha, Anuvasana), Raktamokshana. Shamana - Simhanada guggulu, Rasna, Eranda taila. External - Abhyanga, Swedana. Lifestyle - Avoid heavy foods, maintain regular exercise, consume light digestible food. FAQ: Early treatment prevents deformities and improves mobility. Symptoms can be well-managed, chronicity determines outcome. Basti is most beneficial in Amavata.',
    '/images/diseases/rheumatoid-arthritis.jpg'
);

-- Gout (Vatarakta)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Gout',
    (SELECT id FROM categories WHERE name = 'Joint'),
    'Gout is a metabolic disorder with deposition of uric acid crystals in joints, especially the big toe, causing severe pain and swelling. Ayurvedic correlation: Vatarakta, caused by vitiation of Vata and Rakta. Dosha: Vata + Rakta. Dhatu: Rakta, Asthi. Srotas: Raktavaha, Asthivaha. Lakshana: Severe joint pain, swelling, redness.',
    'Modern: Hyperuricemia, alcohol, red meat, obesity. Ayurvedic: Excess salty/sour food, alcohol, sedentary habits. Samprapti: Nidana (rich food, alcohol, sedentary lifestyle) → Rakta dushti + Vata aggravation → Deposition in joints → Severe pain, swelling.',
    'Sudden severe pain, redness, swelling in big toe and other joints.',
    'Ayurvedic Treatment: Shodhana - Virechana, Raktamokshana. Shamana - Guduchi, Neem, Manjistha, Kaishora guggulu. Lifestyle - Avoid alcohol, red meat, sour foods; increase hydration, use light diet. FAQ: Herbs like Guduchi, Triphala, Manjistha purify blood and lower uric acid. Light vegetarian diet, avoid alcohol and red meat. Symptoms can be managed and recurrence prevented.',
    '/images/diseases/gout.jpg'
);

-- Ankylosing Spondylitis (Asthi-Majjagata Vata)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Ankylosing Spondylitis',
    (SELECT id FROM categories WHERE name = 'Joint'),
    'Ankylosing spondylitis is a chronic inflammatory arthritis primarily affecting the spine and sacroiliac joints, leading to stiffness and fusion. Ayurvedic correlation: Asthi-Majjagata Vata or a form of inflammatory Vata disorder. Dosha: Vata. Dhatu: Asthi, Majja. Srotas: Asthivaha, Majjavaha. Lakshana: Stiffness, pain in lower back, restricted movements.',
    'Modern: Autoimmune, genetic (HLA-B27), chronic inflammation. Ayurvedic: Vata prakopa, dhatu kshaya, ama. Samprapti: Nidana (vata-aggravating diet/lifestyle, autoimmunity) → Vata aggravation → Asthi and Majja dhatu dushti → Inflammation and fusion of vertebrae → Ankylosing Spondylitis.',
    'Chronic back pain, stiffness, loss of flexibility, fatigue.',
    'Ayurvedic Treatment: Shodhana - Basti chikitsa, Virechana. Shamana - Dashamoola, Guggulu preparations, Rasna. External - Abhyanga, Swedana. Lifestyle - Yoga (stretching), avoid prolonged sitting, maintain posture. FAQ: It can slow progression, relieve pain, and improve flexibility. Stretching and pranayama help improve mobility. Basti is the main therapy.',
    '/images/diseases/ankylosing-spondylitis.jpg'
);

-- ===========================================
-- LIFESTYLE CATEGORY DISEASES
-- ===========================================

-- Diabetes Mellitus (Madhumeha)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Diabetes',
    (SELECT id FROM categories WHERE name = 'Lifestyle'),
    'Diabetes mellitus is a metabolic disorder characterized by chronic hyperglycemia due to defects in insulin secretion or action. Ayurvedic correlation: Madhumeha, a subtype of Prameha, caused by Kapha and Vata imbalance with Ojas depletion. Dosha: Kapha, Vata. Dhatu: Meda, Rakta, Ojas. Srotas: Mutravaha, Medovaha. Lakshana: Prabhuta mutrata (excess urination), kshudha (hunger), pipasa (thirst), karapada daha (burning in hands and feet).',
    'Modern: Genetic predisposition, obesity, insulin resistance, sedentary lifestyle. Ayurvedic: Kapha-aggravating diet (sweets, dairy, oily foods), lack of exercise, stress. Samprapti: Nidana (guru, snigdha ahara, sedentary lifestyle, stress) → Kapha & Meda aggravation → Obstruction of Vata → Aggravated Vata dries up dhatus → Ojas kshaya → Madhumeha.',
    'Excessive urination, thirst, hunger, fatigue, weight changes, delayed wound healing.',
    'Ayurvedic Treatment: Shodhana - Vamana, Virechana, Basti. Shamana - Nishamalaki churna, Gudmar, Jamun, Shilajit. Lifestyle - Regular exercise, yoga (Surya Namaskar, Kapalabhati), avoid heavy/sweet food, practice meditation. FAQ: Type 2 can be managed effectively; Type 1 requires lifelong care. Gudmar, Jamun, Bitter gourd, Shilajit reduce blood sugar. Vamana and Virechana help regulate metabolism.',
    '/images/diseases/diabetes.jpg'
);

-- Obesity (Sthaulya)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Obesity',
    (SELECT id FROM categories WHERE name = 'Lifestyle'),
    'Obesity is excessive accumulation of body fat, increasing the risk of metabolic and cardiovascular diseases. Ayurvedic correlation: Sthaulya, caused by Meda dhatu dushti and Kapha aggravation. Dosha: Kapha, Meda. Dhatu: Meda, Mamsa. Srotas: Medovaha. Lakshana: Excessive fat, heaviness, decreased stamina, sweating.',
    'Modern: Overeating, sedentary lifestyle, hormonal imbalance, stress. Ayurvedic: Kapha-vardhak ahara, divaswapna (day sleep), lack of vyayama (exercise). Samprapti: Nidana (overeating, lack of exercise, kapha-aggravating foods) → Kapha aggravation → Meda dhatu dushti → Accumulation of fat → Sthaulya.',
    'Excessive fat accumulation, breathlessness, fatigue, heaviness, excessive sweating.',
    'Ayurvedic Treatment: Shodhana - Vamana, Lekhana basti. Shamana - Triphala, Guggulu, Trikatu, Medohara yoga. Lifestyle - Regular exercise, yoga (Surya Namaskar, Kapalabhati), fasting, light diet. FAQ: Ayurveda can reduce belly fat with herbal remedies, Panchakarma, and lifestyle correction. Guggulu, Triphala, Trikatu are best herbs. Genetics play a role but lifestyle is the main cause.',
    '/images/diseases/obesity.jpg'
);

-- Fatty Liver (Yakrit Roga)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Fatty Liver',
    (SELECT id FROM categories WHERE name = 'Lifestyle'),
    'Fatty liver disease is the excessive accumulation of fat in liver cells, impairing its function. Ayurvedic correlation: Yakrit vriddhi or Medoroga, caused by Kapha and Pitta imbalance. Dosha: Kapha, Pitta. Dhatu: Meda, Rakta. Srotas: Raktavaha, Medovaha. Lakshana: Heaviness, indigestion, fatigue, enlargement of liver.',
    'Modern: Alcohol, obesity, diabetes, high cholesterol, sedentary lifestyle. Ayurvedic: Excessive oily/heavy foods, alcohol, kapha-pitta aggravation. Samprapti: Nidana (alcohol, junk food, obesity, stress) → Kapha & Pitta aggravation → Meda dhatu dushti → Fat accumulation in liver → Yakrit roga.',
    'Fatigue, indigestion, right upper abdominal discomfort, obesity, metabolic issues.',
    'Ayurvedic Treatment: Shodhana - Virechana, Basti. Shamana - Katuki, Bhumiamalaki, Punarnava, Triphala. Lifestyle - Avoid alcohol, reduce fatty food, regular exercise, light diet. FAQ: Early stages can be reversed with proper treatment. Bhumiamalaki, Katuki, Triphala are best herbs. Obesity and unhealthy diet also cause fatty liver.',
    '/images/diseases/fatty-liver.jpg'
);

-- PCOS/PCOD (Artava Dushti)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'PCOS/PCOD',
    (SELECT id FROM categories WHERE name = 'Lifestyle'),
    'PCOS is a hormonal disorder causing irregular periods, ovarian cysts, and infertility. Ayurvedic correlation: Artava Dushti or Yonivyapad, caused by Kapha and Vata imbalance. Dosha: Kapha, Vata. Dhatu: Rasa, Rakta, Artava. Srotas: Artavavaha. Lakshana: Irregular cycles, weight gain, acne, infertility.',
    'Modern: Insulin resistance, hormonal imbalance, genetics, obesity. Ayurvedic: Kapha aggravation, ama, stress, irregular lifestyle. Samprapti: Nidana (stress, junk food, sedentary lifestyle) → Kapha aggravation → Meda dhatu dushti → Blockage of Artavavaha srotas → Hormonal imbalance → PCOS.',
    'Irregular periods, infertility, acne, obesity, hirsutism, mood swings.',
    'Ayurvedic Treatment: Shodhana - Vamana, Virechana, Basti. Shamana - Shatavari, Ashoka, Triphala, Trikatu. Lifestyle - Regular exercise, yoga (Surya Namaskar, Pranayama), avoid junk food, maintain routine. FAQ: With Panchakarma, diet, and lifestyle regulation, symptoms improve. Shatavari, Ashoka, Triphala are best herbs. Fertility improves with Ayurvedic treatment and lifestyle correction.',
    '/images/diseases/pcos.jpg'
);

-- ===========================================
-- DIGESTIVE CATEGORY DISEASES
-- ===========================================

-- GERD (Amlapitta)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'GERD',
    (SELECT id FROM categories WHERE name = 'Digestive'),
    'GERD is a digestive disorder where stomach acid frequently flows back into the esophagus, causing irritation and heartburn. Ayurvedic correlation: Amlapitta, caused by Pitta dosha vitiation. Dosha: Pitta. Dhatu: Rasa, Rakta. Srotas: Annavaha. Lakshana: Heartburn, sour belching, chest discomfort, nausea.',
    'Modern: Obesity, hiatal hernia, spicy food, alcohol, stress. Ayurvedic: Ati-lavana, amla, katu ahara (excessive salty, sour, pungent food), irregular meals, stress. Samprapti: Nidana (spicy food, stress, irregular eating) → Pitta aggravation → Improper digestion → Acid reflux → GERD.',
    'Heartburn, regurgitation, chest pain, sour taste in mouth, nausea.',
    'Ayurvedic Treatment: Shodhana - Virechana. Shamana - Yashtimadhu, Amalaki, Shatavari, Kamdudha rasa. Lifestyle - Avoid spicy food, eat on time, practice pranayama. FAQ: With diet correction and medicines, long-term relief is possible. Yashtimadhu, Amalaki, Shatavari reduce acidity. Stress aggravates Pitta and worsens GERD.',
    '/images/diseases/gerd.jpg'
);

-- Gastritis (Urdhvaga Amlapitta)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Gastritis',
    (SELECT id FROM categories WHERE name = 'Digestive'),
    'Gastritis is the inflammation of the stomach lining, leading to indigestion, nausea, and abdominal pain. Ayurvedic correlation: Urdhvaga Amlapitta or Annadrava Shoola. Dosha: Pitta, Vata. Dhatu: Rasa, Rakta. Srotas: Annavaha. Lakshana: Epigastric pain, nausea, vomiting, burning sensation.',
    'Modern: H. pylori infection, NSAIDs, alcohol, smoking, stress. Ayurvedic: Ati-amla, katu, lavana ahara (excessive sour, pungent, salty food), viruddha ahara (incompatible food), stress. Samprapti: Nidana (irregular food, spicy food, alcohol, stress) → Pitta aggravation + Vata imbalance → Inflammation in stomach → Gastritis.',
    'Epigastric pain, nausea, vomiting, bloating, burning sensation.',
    'Ayurvedic Treatment: Shodhana - Virechana. Shamana - Amalaki, Yashtimadhu, Musta, Kamdudha rasa. Lifestyle - Eat light food, avoid alcohol, maintain meal timings. FAQ: Herbs that reduce inflammation and balance Pitta help with H. pylori gastritis. Short fasting with light diet may help, but prolonged fasting worsens it. Avoid spicy, oily, fermented, and sour foods.',
    '/images/diseases/gastritis.jpg'
);

-- Acidity (Amlapitta)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Acidity',
    (SELECT id FROM categories WHERE name = 'Digestive'),
    'Acidity is excessive secretion of gastric acid causing burning sensation, sour belching, and discomfort. Ayurvedic correlation: Amlapitta. Dosha: Pitta. Dhatu: Rasa. Srotas: Annavaha. Lakshana: Burning, sour belching, nausea.',
    'Modern: Stress, spicy food, alcohol, smoking, irregular meals. Ayurvedic: Ati-katu, amla ahara (excessive pungent, sour food), viruddha ahara (incompatible food), stress. Samprapti: Nidana (spicy food, irregular meals, stress) → Pitta aggravation → Hyperacidity → Amlapitta.',
    'Heartburn, nausea, sour belching, chest pain.',
    'Ayurvedic Treatment: Shodhana - Virechana. Shamana - Shatavari, Amalaki, Yashtimadhu, Kamdudha rasa. Lifestyle - Eat small meals, avoid spicy/oily food, practice pranayama. FAQ: With proper pitta-shamaka treatment and diet correction, chronic acidity can be cured. Shatavari, Yashtimadhu, Amalaki are best herbs. Milk in moderation soothes burning sensation.',
    '/images/diseases/acidity.jpg'
);

-- Constipation (Vibandha)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Constipation',
    (SELECT id FROM categories WHERE name = 'Digestive'),
    'Constipation is difficulty or infrequent passage of stools. Ayurvedic correlation: Vibandha, caused by Vata dosha aggravation. Dosha: Vata. Dhatu: Purisha. Srotas: Annavaha, Purishavaha. Lakshana: Hard stools, difficulty in evacuation, bloating.',
    'Modern: Low fiber diet, dehydration, sedentary lifestyle, medications. Ayurvedic: Ruksha ahara (dry food), vata-vardhak diet, irregular food timings. Samprapti: Nidana (dry food, irregular meals, less water, stress) → Vata aggravation → Colon dryness → Vibandha.',
    'Hard stools, straining, bloating, abdominal discomfort.',
    'Ayurvedic Treatment: Shodhana - Virechana, Basti. Shamana - Triphala, Haritaki, Castor oil. Lifestyle - Drink warm water, eat fiber-rich food, practice yoga (Pawanmuktasana). FAQ: With basti, herbal remedies, and lifestyle correction, chronic constipation can be cured. Papaya, figs, prunes are best fruits. Triphala is the best Ayurvedic laxative.',
    '/images/diseases/constipation.jpg'
);

-- Hemorrhoids (Arsha)
INSERT INTO diseases (name, category_id, description, causes, symptoms, treatment, image_url)
VALUES (
    'Hemorrhoids',
    (SELECT id FROM categories WHERE name = 'Digestive'),
    'Hemorrhoids are swollen veins in the anal region, causing bleeding, pain, and discomfort. Ayurvedic correlation: Arsha, caused by Vata, Pitta, or Kapha imbalance. Dosha: Vata, Pitta, Kapha (depending on type). Dhatu: Rakta, Mamsa. Srotas: Purishavaha. Lakshana: Bleeding, pain, swelling, prolapse.',
    'Modern: Chronic constipation, pregnancy, obesity, sedentary lifestyle. Ayurvedic: Vata aggravation, straining, spicy food, lack of exercise. Samprapti: Nidana (constipation, spicy food, sedentary lifestyle) → Vata aggravation + Rakta dushti → Venous engorgement → Arsha.',
    'Bleeding per rectum, pain, swelling, prolapse, itching.',
    'Ayurvedic Treatment: Shodhana - Virechana, Basti, Raktamokshana. Shamana - Arshoghni vati, Triphala, Haritaki. External - Kshara sutra, local application of herbal oils. Lifestyle - Avoid constipation, eat high-fiber diet, drink water. FAQ: Early stages can be cured without surgery with kshara karma and herbal medicines. Kshara Sutra is the best minimally invasive Ayurvedic treatment. Avoid spicy, oily, and constipating foods.',
    '/images/diseases/hemorrhoids.jpeg'
);