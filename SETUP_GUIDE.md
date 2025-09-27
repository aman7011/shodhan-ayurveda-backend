# Quick Setup Guide for Shodhan Ayurveda Backend

## 🚀 Quick Start (5 minutes)

### Prerequisites
- Java 17+ installed
- Git installed
- Internet connection

### Setup Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/aman7011/shodhan-ayurveda-backend.git
   cd shodhan-ayurveda-backend
   ```

2. **Set up environment variables** (Optional for development)
   ```bash
   # Copy template
   cp .env.example .env
   
   # Edit .env with your values (or skip for H2 database):
   MAIL_USERNAME=your-email@gmail.com
   MAIL_PASSWORD=your-app-password
   SPRING_PROFILES_ACTIVE=dev
   ```

3. **Run the application**
   ```bash
   # Option 1: Using Maven wrapper (recommended)
   ./mvnw spring-boot:run
   
   # Option 2: Using system Maven
   mvn spring-boot:run
   
   # Option 3: Using IDE
   # Import project and run ShodhanayurvedaApplication.java
   ```

4. **Access the application**
   - **API Base URL**: http://localhost:8080
   - **H2 Database Console**: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:devdb`
     - Username: `sa`
     - Password: (leave empty)

## 📊 Available APIs

### Public APIs (No authentication required)
- **GET** `/api/clinics` - Get all clinics
- **GET** `/api/diseases` - Get all diseases
- **GET** `/api/diseases/{id}` - Get disease by ID
- **GET** `/api/services` - Get all services
- **GET** `/api/categories` - Get all categories
- **GET** `/api/blogs` - Get published blogs
- **POST** `/api/appointments` - Create appointment

### Admin APIs (Authentication required)
- **POST** `/api/admin/login` - Admin login
- **GET** `/api/admin/blogs` - Get all blogs (admin)
- **POST** `/api/admin/blogs` - Create blog
- **PUT** `/api/admin/blogs/{id}` - Update blog
- **DELETE** `/api/admin/blogs/{id}` - Delete blog

### Default Admin Credentials
- **Username**: `admin`
- **Password**: `admin123`
- **⚠️ Change this in production!**

## 🛠️ Development Setup

### Database Options

**Option 1: H2 In-Memory (Default for dev)**
- No setup required
- Data resets on restart
- Perfect for development/testing

**Option 2: PostgreSQL (Production)**
```bash
# Install PostgreSQL and create database
createdb shodhanayurveda

# Update .env file:
DATABASE_URL=jdbc:postgresql://localhost:5432/shodhanayurveda
DATABASE_USERNAME=your_db_user
DATABASE_PASSWORD=your_db_password
SPRING_PROFILES_ACTIVE=prod
```

### Email Configuration (Optional)
```bash
# For appointment notifications
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-gmail-app-password
```

## 🧪 Testing the APIs

### Using curl:
```bash
# Get all clinics
curl http://localhost:8080/api/clinics

# Get all diseases
curl http://localhost:8080/api/diseases

# Create appointment
curl -X POST http://localhost:8080/api/appointments \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "phone": "1234567890",
    "serviceName": "Consultation",
    "description": "General consultation",
    "date": "2024-12-01"
  }'
```

### Using browser:
- http://localhost:8080/api/clinics
- http://localhost:8080/api/diseases
- http://localhost:8080/api/services

## 🔧 Configuration Profiles

### Development Profile (default)
- H2 in-memory database
- Detailed logging
- H2 console enabled
- CORS allows localhost:3000 (for React frontend)

### Production Profile
- PostgreSQL database
- Optimized logging
- Enhanced security settings
- Environment-based configuration

## 📝 Project Structure
```
src/main/java/com/ayurveda/shodhanayurveda/
├── controller/     # REST API endpoints
├── entity/         # Database entities
├── repository/     # Data access layer
├── services/       # Business logic
├── config/         # Security & CORS configuration
├── dto/           # Data transfer objects
└── exception/     # Error handling

src/main/resources/
├── application.properties          # Main configuration
├── application-dev.properties      # Development settings
├── application-prod.properties     # Production settings
└── db/migration/                   # Database migrations (Flyway)
```

## 🚨 Troubleshooting

### Common Issues:

1. **Port 8080 already in use**
   ```bash
   # Add to .env file:
   SERVER_PORT=8081
   ```

2. **Java version issues**
   ```bash
   java -version  # Should be 17+
   ```

3. **Database connection issues**
   - Check if PostgreSQL is running
   - Verify credentials in .env file
   - Use H2 for quick testing (no setup required)

4. **Build issues**
   ```bash
   ./mvnw clean install  # Clean and rebuild
   ```

## ⚡ Quick Test Commands

```bash
# Health check
curl http://localhost:8080/actuator/health

# Get sample data
curl http://localhost:8080/api/clinics
curl http://localhost:8080/api/diseases?category=1
curl http://localhost:8080/api/services

# Admin login
curl -X POST http://localhost:8080/api/admin/login \
  -H "Content-Type: application/json" \
  -d '{"username": "admin", "password": "admin123"}'
```

## 🔒 Security Notes

- Default admin password: `admin123` (change in production)
- CORS configured for `localhost:3000` (React frontend)
- Environment variables protect sensitive data
- No hardcoded credentials in source code

## 📚 Additional Resources

- **API Documentation**: See `BLOG_API_DOCUMENTATION.md`
- **API Testing Guide**: See `BLOG_API_TESTING.md`
- **Database Schema**: Check `src/main/resources/db/migration/` files

---

**Need help?** Check the main README.md or create an issue on GitHub.