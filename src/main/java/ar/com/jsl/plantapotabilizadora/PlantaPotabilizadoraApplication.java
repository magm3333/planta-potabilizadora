package ar.com.jsl.plantapotabilizadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PlantaPotabilizadoraApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PlantaPotabilizadoraApplication.class, args);
	}

	@Autowired
	private DefaultData defaultData;

	@Override
	public void run(String... args) throws Exception {
		defaultData.ensureAllRoles();
		defaultData.ensureUserIntegration();
		defaultData.ensureUserGetToken();
	}
}
