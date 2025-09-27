-- Add image_url column to diseases
ALTER TABLE diseases ADD COLUMN image_url VARCHAR(255);

-- Optionally seed some image URLs (adjust paths later as needed)
UPDATE diseases SET image_url = '/images/diseases/constipation.jpg' WHERE name = 'Constipation';
UPDATE diseases SET image_url = '/images/diseases/acidity.jpg' WHERE name = 'Acidity';
UPDATE diseases SET image_url = '/images/diseases/psoriasis.jpg' WHERE name = 'Psoriasis';