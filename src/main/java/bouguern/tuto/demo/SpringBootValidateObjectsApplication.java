package bouguern.tuto.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootValidateObjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootValidateObjectsApplication.class, args);
	}

}
