package dk.klintsoe.brondbyChessWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BrondbyChessWebsiteApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BrondbyChessWebsiteApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BrondbyChessWebsiteApplication.class);
	}

}
