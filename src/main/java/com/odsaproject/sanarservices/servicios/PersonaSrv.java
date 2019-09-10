/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.PersonaDao;
import com.odsaproject.sanarservices.entidades.Persona;

/**
 * @author Osvaldo
 *
 */
@Service
public class PersonaSrv {
	
	@Autowired
	private PersonaDao personaDao;
	
	public List<Persona> devolverTodo() {
		List<Persona> result = null;
		result = (List<Persona>) personaDao.findByEstadoTrue();

		return result;
	}

	public Persona crear(Persona Persona) {
		Persona result = null;
		result = personaDao.save(Persona);

		return result;
	}

	public Optional<Persona> devolverPorId(Long id) {
		Optional<Persona> result = personaDao.findPerById(id);

		return result;
	}
	
	public Optional<Persona> devolverPorCedula(String cedula) {
		Optional<Persona> result = personaDao.findByCedula(cedula);
		
		return result;
	}
	
	public Optional<Persona> devolverPorEmail(String email) {
		Optional<Persona> result = personaDao.findByEmail(email);
		
		return result;
	}
	
	public Optional<Persona> login(String pass, String mail) {
		Optional<Persona> result = personaDao.login(pass, mail);
		
		return result;
	}

}
