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

import com.odsaproject.sanarservices.entidades.Tipovehiculo;
import com.odsaproject.sanarservices.servicios.TipovehiculoSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/tipoVehiculo", produces = "application/json")
public class TipovehiculoCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private TipovehiculoSrv tipovehiculoSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Tipovehiculo tv) {
		
		return ResponseEntity.ok(tipovehiculoSrv.crear(tv));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Tipovehiculo tv) {
		
		return ResponseEntity.ok(tipovehiculoSrv.crear(tv));
	}

	@RequestMapping
	public List<Tipovehiculo> listarTodo() {
		List<Tipovehiculo> result = tipovehiculoSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Tipovehiculo devolverPorId(@PathVariable("id") Long id) {
		Optional<Tipovehiculo> result = tipovehiculoSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Tipovehiculo devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Tipovehiculo> result = tipovehiculoSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el tipo de producto: " + nombre);
			
		return result.orElse(null);
	}

}
