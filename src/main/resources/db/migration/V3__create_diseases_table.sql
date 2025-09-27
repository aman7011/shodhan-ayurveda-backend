CREATE TABLE diseases (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Unique ID for each disease
    name VARCHAR(255) NOT NULL,  -- Name of the disease (e.g., Acidity)
    category VARCHAR(255),  -- Category of the disease (e.g., Digestive, Respiratory, etc.)
    description TEXT,  -- Detailed description of the disease
    causes TEXT,  -- Causes of the disease
    symptoms TEXT,  -- Symptoms associated with the disease
    treatment TEXT,  -- Treatments for the disease
    home_remedies TEXT,  -- Home remedies for the disease
    lifestyle_recommendations TEXT,  -- Lifestyle recommendations or dietary suggestions
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Timestamp of when the record is created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- Timestamp of when the record is updated
);