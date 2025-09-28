-- Update existing clinic with multiple image URLs in JSON format
UPDATE clinics 
SET image_urls = '[
    "/images/clinics/clinic.jpg",
    "/images/clinics/doctor.jpg",
    "/images/clinics/clinic-board.jpg"
]'
WHERE name = 'Shodhan Ayurved Center';