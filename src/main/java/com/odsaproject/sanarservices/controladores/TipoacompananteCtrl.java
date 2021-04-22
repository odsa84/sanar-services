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

import com.odsaproject.sanarservices.entidades.Tipoacompanante;
import com.odsaproject.sanarservices.servicios.TipoacompananteSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/tipoAcompanante", produces = "application/json")
public class TipoacompananteCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private TipoacompananteSrv tipoAcompSrv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Tipoacompanante ta) {
		
		return ResponseEntity.ok(tipoAcompSrv.crear(ta));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Tipoacompanante ta) {
		
		return ResponseEntity.ok(tipoAcompSrv.crear(ta));
	}

	@RequestMapping
	public List<Tipoacompanante> listarTodo() {
		List<Tipoacompanante> result = tipoAcompSrv.devolverTodo();
		
		return result;
	}
	
	@GetMapping("/id/{id}")
	public Tipoacompanante devolverPorId(@PathVariable("id") Long id) {
		Optional<Tipoacompanante> result = tipoAcompSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Tipoacompanante devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Tipoacompanante> result = tipoAcompSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el tipo de producto: " + nombre);
			
		return result.orElse(null);
	}
	
	@GetMapping("/servicio/{servicio}")
	public List<Tipoacompanante> devolverPorServicio(@PathVariable("marca") Long servicio) {
		List<Tipoacompanante> result = tipoAcompSrv.devolverPorServicio(servicio);
		
		return result;
	}
	
	@GetMapping("/marca/{marca}")
	public List<Tipoacompanante> devolverPorMarca(@PathVariable("marca") Long marca) {
		List<Tipoacompanante> result = tipoAcompSrv.devolverPorMarca(marca);
		
		return result;
	}

}
