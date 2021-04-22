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

import com.odsaproject.sanarservices.entidades.Tipoproducto;
import com.odsaproject.sanarservices.servicios.TipoproductoSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/tipoProducto", produces = "application/json")
public class TipoproductoCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private TipoproductoSrv tipoproductoSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Tipoproducto tp) {
		
		return ResponseEntity.ok(tipoproductoSrv.crear(tp));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Tipoproducto tp) {
		
		return ResponseEntity.ok(tipoproductoSrv.crear(tp));
	}

	@RequestMapping
	public List<Tipoproducto> listarTodo() {
		List<Tipoproducto> result = tipoproductoSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/categoria/{id}")
	public List<Tipoproducto> devolverPorCategoria(@PathVariable("id") Long id) {
		List<Tipoproducto> result = tipoproductoSrv.devolverPorCategoria(id);
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Tipoproducto devolverPorId(@PathVariable("id") Long id) {
		Optional<Tipoproducto> result = tipoproductoSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Tipoproducto devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Tipoproducto> result = tipoproductoSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el tipo de producto: " + nombre);
			
		return result.orElse(null);
	}

}
