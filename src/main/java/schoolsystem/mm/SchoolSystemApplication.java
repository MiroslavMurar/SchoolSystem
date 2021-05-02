package schoolsystem.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SchoolSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
	}
}
