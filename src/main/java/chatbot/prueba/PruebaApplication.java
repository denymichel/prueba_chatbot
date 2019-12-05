package chatbot.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(PruebaApplication.class, args);


	}


}
