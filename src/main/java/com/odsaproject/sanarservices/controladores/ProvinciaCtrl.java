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

import com.odsaproject.sanarservices.entidades.Provincia;
import com.odsaproject.sanarservices.servicios.ProvinciaSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
//@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8101"})
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/provincia", produces = "application/json")
public class ProvinciaCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ProvinciaCtrl.class);
	
	@Autowired
	private ProvinciaSrv provinciaSrv;
	
	@RequestMapping
	public List<Provincia> listarTodo() {
		List<Provincia> result = provinciaSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Provincia provincia) {
		
		return ResponseEntity.ok(provinciaSrv.crear(provincia));
	}
	
	@GetMapping("/id/{id}")
	public Provincia devolverPorId(@PathVariable("id") Long id) {
		Optional<Provincia> result = provinciaSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Provincia devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Provincia> result = provinciaSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el nombre: " + nombre);
		
		return result.orElse(null);
	}
}
