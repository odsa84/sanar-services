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

import com.odsaproject.sanarservices.entidades.Sector;
import com.odsaproject.sanarservices.servicios.SectorSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
//@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8101"})
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/sector", produces = "application/json")
public class SectorCtrl {

	public static final Logger LOGGER = LoggerFactory.getLogger(SectorCtrl.class);
	
	@Autowired
	private SectorSrv sectorSrv;
	
	@RequestMapping
	public List<Sector> listarTodo() {
		List<Sector> result = sectorSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Sector ciudad) {
		
		return ResponseEntity.ok(sectorSrv.crear(ciudad));
	}
	
	@GetMapping("/id/{id}")
	public Sector devolverPorId(@PathVariable("id") Long id) {
		Optional<Sector> result = sectorSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Sector devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Sector> result = sectorSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el sector: " + nombre);
		
		return result.orElse(null);
	}
	
	@GetMapping("/ciudad/{ciudad}")
	public List<Sector> devolverPorCiudad(@PathVariable("ciudad") Long idCiudad) {
		List<Sector> result = sectorSrv.devolverPorIdCiudad(idCiudad);
		
		return result;
	}
}
