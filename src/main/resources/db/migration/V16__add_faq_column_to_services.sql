-- Alter services table to support larger text content and add FAQ column
ALTER TABLE services ALTER COLUMN description SET DATA TYPE TEXT;
-- Modify services table to support larger text content and add FAQ column
ALTER TABLE services ALTER COLUMN description TEXT;
ALTER TABLE services ADD COLUMN faq TEXT;