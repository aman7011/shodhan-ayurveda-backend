-- Add image_urls column to clinics table to support multiple images
ALTER TABLE clinics ADD COLUMN image_urls TEXT;