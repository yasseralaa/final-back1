package com.orange.artifact;


import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.repository.PredefinedNotesRepository;
import com.orange.artifact.repository.RoleRepository;
import com.orange.artifact.repository.UserRepository;
import com.orange.artifact.repository.WeatherNoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan({"com"})
public class ArtifactApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(ArtifactApplication.class);

	public static void main(String[] args) {
		logger.info("main Function is called");
		SpringApplication.run(ArtifactApplication.class, args);
	}

    // Provider Done
	// Flyway Done
	// Jetty Done
	// FactoryMethod Done
	// Nginx Done
	// FactoryMethod Updated
	// Predefined notes
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Bean
	public CommandLineRunner runner(final UserRepository userRepository,
									final PredefinedNotesRepository predefinedNotesRepository,
									final RoleRepository roleRepository,
									final WeatherNoteRepository weatherNoteRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.err.println(userRepository.findAll());
				System.err.println(predefinedNotesRepository.findAll());
				System.err.println(roleRepository.findAll());
				System.err.println(weatherNoteRepository.findAll());
			}

		};
	}

}

