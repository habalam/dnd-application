package sk.dnd.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class ServiceConfiguration {

	@Bean
	public CharacterServiceImpl characterService(ServiceProperties properties) {
		CharacterServiceImpl characterService = new CharacterServiceImpl();
		characterService.setMessage(properties.getMessage());
		return characterService;
	}
}
