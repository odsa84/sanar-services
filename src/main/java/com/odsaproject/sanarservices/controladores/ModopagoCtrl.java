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

import com.odsaproject.sanarservices.entidades.Modopago;
import com.odsaproject.sanarservices.servicios.ModopagoSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/modoPago", produces = "application/json")
public class ModopagoCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private ModopagoSrv modoPagoSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Modopago mp) {
		
		return ResponseEntity.ok(modoPagoSrv.crear(mp));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Modopago mp) {
		
		return ResponseEntity.ok(modoPagoSrv.crear(mp));
	}

	@RequestMapping
	public List<Modopago> listarTodo() {
		List<Modopago> result = modoPagoSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Modopago devolverPorId(@PathVariable("id") Long id) {
		Optional<Modopago> result = modoPagoSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Modopago devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Modopago> result = modoPagoSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el tipo de producto: " + nombre);
			
		return result.orElse(null);
	}

}
