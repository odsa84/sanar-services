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

import com.odsaproject.sanarservices.entidades.Vehiculo;
import com.odsaproject.sanarservices.servicios.VehiculoSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/vehiculo", produces = "application/json")
public class VehiculoCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private VehiculoSrv vehiculoSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Vehiculo v) {
		
		return ResponseEntity.ok(vehiculoSrv.crear(v));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Vehiculo v) {
		
		return ResponseEntity.ok(vehiculoSrv.crear(v));
	}

	@RequestMapping
	public List<Vehiculo> listarTodo() {
		List<Vehiculo> result = vehiculoSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Vehiculo devolverPorId(@PathVariable("id") Long id) {
		Optional<Vehiculo> result = vehiculoSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/tipoVehiculo/{tipoVehiculo}")
	public List<Vehiculo> devolverPorTipoVehiculo(@PathVariable("tipoVehiculo") Long tipoVehiculo) {
		List<Vehiculo> result = vehiculoSrv.devolverPorTipoVehiculo(tipoVehiculo);
			
		return result;
	}

}
