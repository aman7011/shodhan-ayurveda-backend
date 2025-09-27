-- Add category_id column to diseases table and create foreign key relationship
ALTER TABLE diseases ADD COLUMN category_id BIGINT;

-- Update existing diseases to reference categories (assuming we have some existing data)
-- Update existing diseases with category names to reference category IDs
UPDATE diseases SET category_id = (SELECT id FROM categories WHERE name = 'Skin') WHERE category = 'Skin';
UPDATE diseases SET category_id = (SELECT id FROM categories WHERE name = 'Joint') WHERE category = 'Joint';
UPDATE diseases SET category_id = (SELECT id FROM categories WHERE name = 'Lifestyle') WHERE category = 'Lifestyle';
UPDATE diseases SET category_id = (SELECT id FROM categories WHERE name = 'Digestive') WHERE category = 'Digestive';

-- For any diseases that don't match existing categories, set them to 'Skin' as default
UPDATE diseases SET category_id = (SELECT id FROM categories WHERE name = 'Skin') WHERE category_id IS NULL;

-- Add foreign key constraint
ALTER TABLE diseases ADD CONSTRAINT FK_diseases_category FOREIGN KEY (category_id) REFERENCES categories(id);

-- Make category_id NOT NULL after we've populated it
ALTER TABLE diseases ALTER COLUMN category_id SET NOT NULL;