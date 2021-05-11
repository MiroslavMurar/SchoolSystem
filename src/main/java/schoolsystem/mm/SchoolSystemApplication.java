package schoolsystem.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SchoolSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
//		SpringApplication.run(Main.class, args);
	}
}
