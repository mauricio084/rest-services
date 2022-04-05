package com.javeriana.desarrolloweb.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.desarrolloweb.exceptions.SaludoException;

@CrossOrigin
@RestController
@RequestMapping("api")
class MyController {
	
	@GetMapping(path = "persona", produces = MediaType.APPLICATION_XML_VALUE)
	public Persona getPersona() {
		Persona persona = new Persona();
		persona.setNombre("Ricardo Carrasco");
		persona.setTipo("CC");
		persona.setNumero("8740267");
		persona.addPelicula(new Pelicula("La era de hielo",  2002, "Animación"));
		persona.addPelicula(new Pelicula("Shrek", 2001, "Animación"));
		
		return persona;
	}
	
//	@ExceptionHandler({SaludoException.class })
//	String handleException(SaludoException e) {
//		return e.getMessage();
//	}
	
	@GetMapping(path = "saludar", produces = MediaType.APPLICATION_XML_VALUE)
	Saludo sayHelloRequestParams(@RequestParam(name="nombre") String nombres, @RequestParam(name="apellido") String apellidos) {
		StringBuilder value = new StringBuilder();
		value.append("Hola mundo ");
		value.append(nombres);
		value.append(" ");
		value.append(apellidos);
		
		if (nombres.startsWith("Mauricio")) {
			throw new SaludoException("1001");
		}
		
		return new Saludo(value.toString());
	}
	
	@GetMapping(path = "saludar/{nombres}/{apellidos}")
	Saludo sayHelloURITemplate(@PathVariable(name="nombres") String nombres, @PathVariable(name="apellidos") String apellidos) {
		StringBuilder value = new StringBuilder();
		value.append("Hola mundo ");
		value.append(nombres);
		value.append(" ");
		value.append(apellidos);
		
		return new Saludo(value.toString());
	}
	
	@GetMapping(path = "saludarWithBody")
	Saludo sayHelloBody(@RequestBody String nombres) {
		StringBuilder value = new StringBuilder();
		value.append("Hola mundo ");
		value.append(nombres);
		
		return new Saludo(value.toString());
	}
 
}
