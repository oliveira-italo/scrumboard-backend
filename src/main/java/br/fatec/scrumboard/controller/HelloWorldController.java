package br.fatec.scrumboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.scrumboard.controller.dto.HelloWorldDTO;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<HelloWorldDTO> helloWorld() {
		return ResponseEntity.ok(new HelloWorldDTO());
	}
	
}
