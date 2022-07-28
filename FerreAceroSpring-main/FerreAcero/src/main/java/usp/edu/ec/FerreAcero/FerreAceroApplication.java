package usp.edu.ec.FerreAcero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@CrossOrigin(origins = "*",  maxAge=3600, methods= {RequestMethod.GET,RequestMethod.POST})
public class FerreAceroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerreAceroApplication.class, args);
	}

}


