-- Update diseases with dedicated FAQ content
-- SKIN DISEASES FAQS
UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure psoriasis completely? A: Ayurveda provides remission and long-term relief; cure depends on chronicity. Q2: Which foods are to be avoided? A: Fish with milk, sour curd, fermented foods, alcohol. Q3: How long does Ayurvedic treatment take? A: Weeks to months depending on chronicity. Q4: Is psoriasis hereditary? A: Yes, but lifestyle and diet can minimize flare-ups.' WHERE name = 'Psoriasis';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda help children with eczema? A: Yes, with safe herbal remedies and diet correction. Q2: Is eczema food-related? A: Yes, some foods can trigger flare-ups. Q3: Does climate affect eczema? A: Yes, dryness in winter worsens symptoms.' WHERE name = 'Eczema';

UPDATE diseases SET faqs = 'Q1: Can urticaria be permanently cured with Ayurveda? A: Recurrence can be minimized with shodhana and lifestyle correction. Q2: Which foods worsen hives? A: Fermented, sour, salty foods; seafood; alcohol. Q3: Is stress a trigger? A: Yes, stress can worsen hives.' WHERE name = 'Urticaria';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda help in acne scars? A: Yes, herbs like Kumkumadi taila, Aloe vera, and Triphala help. Q2: Do hormones cause acne? A: Yes, imbalance of androgens is a major factor. Q3: Is acne only for teenagers? A: No, it can occur in adults too.' WHERE name = 'Acne';

UPDATE diseases SET faqs = 'Q1: Are fungal infections contagious? A: Yes, they can spread through contact. Q2: Can Ayurveda fully cure fungal infections? A: Yes, with proper internal and external treatment. Q3: Which foods worsen fungal infections? A: Excess sugar, oily and fermented foods.' WHERE name = 'Fungal Infections';

-- JOINT DISEASES FAQS
UPDATE diseases SET faqs = 'Q1: Can Ayurveda reverse osteoarthritis? A: Degeneration cannot be reversed fully but pain and mobility can improve significantly. Q2: Is Panchakarma useful? A: Yes, basti therapy is highly beneficial. Q3: Which foods to avoid? A: Dry, cold, stale, and vata-aggravating foods.' WHERE name = 'Osteoarthritis';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda stop joint deformities in RA? A: Early treatment prevents deformities and improves mobility. Q2: Is Amavata curable? A: Symptoms can be well-managed, chronicity determines outcome. Q3: Which Panchakarma therapy is most useful? A: Basti is most beneficial in Amavata.' WHERE name = 'Rheumatoid Arthritis';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda lower uric acid levels? A: Yes, herbs like Guduchi, Triphala, Manjistha purify blood and lower uric acid. Q2: Which diet is best? A: Light vegetarian diet, avoid alcohol and red meat. Q3: Is gout curable? A: Symptoms can be managed and recurrence prevented.' WHERE name = 'Gout';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure ankylosing spondylitis? A: It can slow progression, relieve pain, and improve flexibility. Q2: Is yoga beneficial? A: Yes, stretching and pranayama help improve mobility. Q3: Which panchakarma is recommended? A: Basti is the main therapy.' WHERE name = 'Ankylosing Spondylitis';

-- LIFESTYLE DISEASES FAQS
UPDATE diseases SET faqs = 'Q1: Can Ayurveda completely cure diabetes? A: Type 2 can be managed effectively; Type 1 requires lifelong care. Q2: Which herbs reduce blood sugar? A: Gudmar, Jamun, Bitter gourd, Shilajit. Q3: Is Panchakarma beneficial? A: Yes, Vamana and Virechana help regulate metabolism.' WHERE name = 'Diabetes';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda reduce belly fat? A: Yes, with herbal remedies, Panchakarma, and lifestyle correction. Q2: Which herbs are best? A: Guggulu, Triphala, Trikatu. Q3: Is obesity hereditary? A: Genetics play a role but lifestyle is the main cause.' WHERE name = 'Obesity';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda reverse fatty liver? A: Yes, early stages can be reversed with proper treatment. Q2: Which herbs are best? A: Bhumiamalaki, Katuki, Triphala. Q3: Is alcohol the only cause? A: No, obesity and unhealthy diet also cause fatty liver.' WHERE name = 'Fatty Liver';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure PCOS? A: Yes, with Panchakarma, diet, and lifestyle regulation, symptoms improve. Q2: Which herbs are best for PCOS? A: Shatavari, Ashoka, Triphala. Q3: Can PCOS patients conceive naturally? A: Yes, fertility improves with Ayurvedic treatment and lifestyle correction.' WHERE name = 'PCOS/PCOD';

-- DIGESTIVE DISEASES FAQS
UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure GERD permanently? A: Yes, with diet correction and medicines, long-term relief is possible. Q2: Which herbs reduce acidity? A: Yashtimadhu, Amalaki, Shatavari. Q3: Is stress a cause? A: Yes, stress aggravates Pitta and worsens GERD.' WHERE name = 'GERD';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda treat H. pylori gastritis? A: Yes, with herbs that reduce inflammation and balance Pitta. Q2: Is fasting good for gastritis? A: Short fasting with light diet may help, but prolonged fasting worsens it. Q3: Which foods to avoid? A: Spicy, oily, fermented, and sour foods.' WHERE name = 'Gastritis';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure chronic acidity? A: Yes, with proper pitta-shamaka treatment and diet correction. Q2: Which herbs are best? A: Shatavari, Yashtimadhu, Amalaki. Q3: Is milk good for acidity? A: Yes, in moderation, it soothes burning sensation.' WHERE name = 'Acidity';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure chronic constipation? A: Yes, with basti, herbal remedies, and lifestyle correction. Q2: Which fruits are best? A: Papaya, figs, prunes. Q3: Is Triphala good for constipation? A: Yes, it is the best Ayurvedic laxative.' WHERE name = 'Constipation';

UPDATE diseases SET faqs = 'Q1: Can Ayurveda cure piles without surgery? A: Yes, in early stages with kshara karma and herbal medicines. Q2: Is Kshara Sutra effective? A: Yes, it is the best minimally invasive Ayurvedic treatment. Q3: Which foods to avoid? A: Spicy, oily, and constipating foods.' WHERE name = 'Hemorrhoids';