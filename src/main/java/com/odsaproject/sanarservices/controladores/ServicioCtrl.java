/**
 * 
 */
package com.odsaproject.sanarservices.controladores;

import java.time.LocalDateTime;
import java.util.Date;
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
import com.odsaproject.sanarservices.entidades.Servicio;
import com.odsaproject.sanarservices.servicios.CategoriaSrv;
import com.odsaproject.sanarservices.servicios.ServicioSrv;


/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/servicio", produces = "application/json")
public class ServicioCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private ServicioSrv servicioSrv;
	@Autowired
	private CategoriaSrv categoriaSrv;
	
	@RequestMapping
	public List<Servicio> listarTodo() {
		List<Servicio> result = servicioSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Servicio servicio) {
		servicio.setFechaRegistro(LocalDateTime.now());
		if(servicio.getImagen() == null || servicio.getImagen().isEmpty()) {
			servicio.setImagen(servicio.getCategoria().getImagen());
		}
		return ResponseEntity.ok(servicioSrv.crear(servicio));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Servicio servicio) {
		Optional<Servicio> result = servicioSrv.devolverPorId(servicio.getId());
		if(result.isPresent())
			servicio.setFechaRegistro(result.get().getFechaRegistro());
		else
			servicio.setFechaRegistro(LocalDateTime.now());
		
		servicio.setFechaModificacion(LocalDateTime.now());
		
		if(servicio.getImagen() == null || servicio.getImagen().isEmpty()) {
			Optional<Categoria> cat = categoriaSrv.devolverPorId(servicio.getCategoria().getId());
			if(cat.isPresent())
				servicio.setImagen(cat.get().getImagen());
		}
		
		return ResponseEntity.ok(servicioSrv.crear(servicio));
	}
	
	@GetMapping("/id/{id}")
	public Servicio devolverPorId(@PathVariable("id") Long id) {
		Optional<Servicio> result = servicioSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/persona/{per}")
	public List<Servicio> devolverPorPersona(@PathVariable("per") Long idPersona) {
		List<Servicio> result = servicioSrv.devolverPorPersona(idPersona);
		
		return result;
	}
	
	@GetMapping("/categoria/{cat}")
	public List<Servicio> devolverPorCategoria(@PathVariable("cat") Long idCategoria) {
		List<Servicio> result = servicioSrv.devolverPorCategoria(idCategoria);
		
		return result;
	}
	
	@GetMapping("/sector/{sec}")
	public List<Servicio> devolverPorSector(@PathVariable("sec") Long idSector) {
		List<Servicio> result = servicioSrv.devolverPorSector(idSector);
		
		return result;
	}
}
