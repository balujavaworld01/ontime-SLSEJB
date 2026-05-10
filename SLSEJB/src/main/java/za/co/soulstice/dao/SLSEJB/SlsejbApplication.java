package za.co.soulstice.dao.SLSEJB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("za.co.soulstice")
public class SlsejbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlsejbApplication.class, args);
	}
}
