/**
 * 
 */
package com.odsaproject.sanarservices.controladores;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odsaproject.sanarservices.entidades.Persona;
import com.odsaproject.sanarservices.pojos.Login;
import com.odsaproject.sanarservices.servicios.PersonaSrv;
import com.odsaproject.sanarservices.util.Encriptar;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/persona", produces = "application/json")
public class PersonaCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PersonaCtrl.class);
	
	@Autowired
	private PersonaSrv personaSrv;
	
	@RequestMapping
	public List<Persona> listarTodo() {
		List<Persona> result = personaSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Persona persona) {
		String passEncp = Encriptar.EncriptarMD5(persona.getPassword());
		persona.setPassword(passEncp);
		persona.setEstado(1);
		
		return ResponseEntity.ok(personaSrv.crear(persona));
	}
	
	@GetMapping("/id/{id}")
	public Persona devolverPorId(@PathVariable("id") Long id) {
		Optional<Persona> result = personaSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/cedula/{cedula}")
	public Persona devolverPorCedula(@PathVariable("cedula") String cedula) {
		Optional<Persona> result = personaSrv.devolverPorCedula(cedula);
		if(!result.isPresent())
			LOGGER.error("No exsite la cedula: " + cedula);
		
		return result.orElse(null);
	}
	
	@GetMapping("/email/{email}")
	public Persona devolverPorEmail(@PathVariable("email") String email) {
		Optional<Persona> result = personaSrv.devolverPorEmail(email);
		if(!result.isPresent())
			LOGGER.error("No exsite el email: " + email);
		
		return result.orElse(null);
	}
	
	@PostMapping("/login")
	public Persona login(@RequestBody Login login) {
		String passEncp = Encriptar.EncriptarMD5(login.getPassword());
		Optional<Persona> result = personaSrv.login(passEncp, login.getMail());
		if(!result.isPresent())
			LOGGER.error("Login incorrecto");
		
		return result.orElse(null);
	}

}
