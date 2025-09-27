# Shodhan Ayurveda Backend

A Spring Boot application for Shodhan Ayurveda center providing APIs for clinic management, disease information, services, appointments, and blog management.

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL (for production) or H2 (for development)

### Development Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd shodhanayurveda
   ```

2. **Set up environment variables**
   ```bash
   cp .env.example .env
   # Edit .env with your actual values
   ```

3. **Run in development mode**
   ```bash
   # This will use H2 in-memory database
   mvn spring-boot:run -Dspring.profiles.active=dev
   ```

4. **Access H2 Console (development only)**
   - URL: http://localhost:8080/h2-console
   - JDBC URL: `jdbc:h2:mem:devdb`
   - Username: `sa`
   - Password: (leave empty)

### Production Deployment

1. **Set environment variables**
   ```bash
   export DATABASE_URL=jdbc:postgresql://localhost:5432/shodhanayurveda
   export DATABASE_USERNAME=your_db_user
   export DATABASE_PASSWORD=your_db_password
   export MAIL_USERNAME=your-email@gmail.com
   export MAIL_PASSWORD=your-app-password
   export SPRING_PROFILES_ACTIVE=prod
   ```

2. **Build and run**
   ```bash
   mvn clean package
   java -jar target/shodhanayurveda-0.0.1-SNAPSHOT.jar
   ```

## 🔧 Configuration

### Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_PROFILES_ACTIVE` | Active Spring profile (dev/prod) | `dev` |
| `DATABASE_URL` | Database connection URL | H2 in-memory |
| `DATABASE_USERNAME` | Database username | `sa` |
| `DATABASE_PASSWORD` | Database password | (empty) |
| `MAIL_USERNAME` | Email username for notifications | (required) |
| `MAIL_PASSWORD` | Email password/app-password | (required) |

### Profiles

- **dev**: Uses H2 in-memory database, enables H2 console, verbose logging
- **prod**: Uses PostgreSQL, production-optimized settings, minimal logging

## 📊 Database

The application uses Flyway for database migrations. Migration files are located in `src/main/resources/db/migration/`.

### Tables
- `clinics` - Clinic information
- `diseases` - Disease catalog with treatments
- `services` - Available services
- `appointments` - Appointment bookings
- `categories` - Disease categories
- `blogs` - Blog posts
- `admin_users` - Admin user management

## 🔐 Security

### Default Admin User
- Username: `admin`
- Password: `admin123`
- **⚠️ Change this password in production!**

### API Security
- Most endpoints are publicly accessible
- Admin endpoints require authentication
- CORS is configured for web client access

## 📚 API Documentation

See `BLOG_API_DOCUMENTATION.md` and `BLOG_API_TESTING.md` for detailed API information.

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run with specific profile
mvn test -Dspring.profiles.active=dev
```

## 🚨 Security Checklist for Production

- [ ] Change default admin password
- [ ] Set up proper database credentials
- [ ] Configure mail settings with app passwords
- [ ] Use HTTPS in production
- [ ] Review CORS settings
- [ ] Set up proper logging and monitoring
- [ ] Configure firewall rules
- [ ] Use environment variables for all secrets

## 📝 License

[Add your license information here]
