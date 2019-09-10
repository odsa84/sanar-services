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

import com.odsaproject.sanarservices.entidades.Categoria;
import com.odsaproject.sanarservices.servicios.CategoriaSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
//@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8101", "http://localhost:8081"})
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/categoria", produces = "application/json")
public class CategoriaCtrl {

	public static final Logger LOGGER = LoggerFactory.getLogger(CategoriaCtrl.class);
	
	@Autowired
	private CategoriaSrv categoriaSrv;
	
	@RequestMapping
	public List<Categoria> listarTodo() {
		List<Categoria> result = categoriaSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Categoria categoria) {
		
		return ResponseEntity.ok(categoriaSrv.crear(categoria));
	}
	
	@GetMapping("/id/{id}")
	public Categoria devolverPorId(@PathVariable("id") Long id) {
		Optional<Categoria> result = categoriaSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
}
