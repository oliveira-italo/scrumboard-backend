package br.fatec.scrumboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("br.fatec.scrumboard.model")
@SpringBootApplication
public class ScrumboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrumboardApplication.class, args);
	}

}
