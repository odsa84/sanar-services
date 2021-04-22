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

import com.odsaproject.sanarservices.entidades.Marca;
import com.odsaproject.sanarservices.servicios.MarcaSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/marca", produces = "application/json")
public class MarcaCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private MarcaSrv marcaSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Marca m) {
		
		return ResponseEntity.ok(marcaSrv.crear(m));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Marca m) {
		
		return ResponseEntity.ok(marcaSrv.crear(m));
	}

	@RequestMapping
	public List<Marca> listarTodo() {
		List<Marca> result = marcaSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Marca devolverPorId(@PathVariable("id") Long id) {
		Optional<Marca> result = marcaSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Marca devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Marca> result = marcaSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el tipo de producto: " + nombre);
			
		return result.orElse(null);
	}

}
