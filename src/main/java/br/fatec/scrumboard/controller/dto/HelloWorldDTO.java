package br.fatec.scrumboard.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorldDTO {

	private String message;

	public HelloWorldDTO() {
		this.message = "Hello world!!!";
	}

}
