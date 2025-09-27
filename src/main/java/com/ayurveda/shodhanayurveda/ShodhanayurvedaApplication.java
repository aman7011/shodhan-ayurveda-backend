package com.ayurveda.shodhanayurveda;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShodhanayurvedaApplication {

	public static void main(String[] args) {
		// Load environment variables from .env file
		loadEnvironmentVariables();
		
		SpringApplication.run(ShodhanayurvedaApplication.class, args);
	}
	
	private static void loadEnvironmentVariables() {
		try {
			Dotenv dotenv = Dotenv.configure()
					.directory("./")  // Look for .env in project root
					.ignoreIfMalformed()
					.ignoreIfMissing()
					.load();
			
			// Set system properties from .env file so Spring can access them
			dotenv.entries().forEach(entry -> {
				System.setProperty(entry.getKey(), entry.getValue());
			});
			
			System.out.println("✅ Environment variables loaded from .env file");
			
		} catch (Exception e) {
			System.out.println("⚠️ Could not load .env file: " + e.getMessage());
		}
	}
}
