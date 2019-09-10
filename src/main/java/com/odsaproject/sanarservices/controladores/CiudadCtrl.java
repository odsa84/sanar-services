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

import com.odsaproject.sanarservices.entidades.Ciudad;
import com.odsaproject.sanarservices.servicios.CiudadSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
//@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8101"})
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/ciudad", produces = "application/json")
public class CiudadCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CiudadCtrl.class);
	
	@Autowired
	private CiudadSrv ciudadSrv;
	
	@RequestMapping
	public List<Ciudad> listarTodo() {
		List<Ciudad> result = ciudadSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Ciudad ciudad) {
		
		return ResponseEntity.ok(ciudadSrv.crear(ciudad));
	}
	
	@GetMapping("/id/{id}")
	public Ciudad devolverPorId(@PathVariable("id") Long id) {
		Optional<Ciudad> result = ciudadSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Ciudad devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Ciudad> result = ciudadSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite la ciudad: " + nombre);
		
		return result.orElse(null);
	}
	
	@GetMapping("/provincia/{provincia}")
	public List<Ciudad> devolverPorProvincia(@PathVariable("provincia") Long idProvincia) {
		List<Ciudad> result = ciudadSrv.devolverPorIdProvincia(idProvincia);
		
		return result;
	}
}
