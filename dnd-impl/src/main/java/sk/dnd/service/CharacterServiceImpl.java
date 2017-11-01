package sk.dnd.service;

import org.springframework.stereotype.Component;

//@Component
public class CharacterServiceImpl implements CharacterService {

	private String message;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
