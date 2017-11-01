package sk.dnd.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("sk.dnd")
@EnableJpaRepositories("sk.dnd")
@ComponentScan("sk.dnd")
public class DndTestBase {

	public static void main(String[] args) {
		SpringApplication.run(DndTestBase.class, args);
	}
}
