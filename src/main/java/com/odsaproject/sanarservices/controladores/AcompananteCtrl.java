/**
 * 
 */
package com.odsaproject.sanarservices.controladores;

import java.util.ArrayList;
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

import com.odsaproject.sanarservices.entidades.Acompanante;
import com.odsaproject.sanarservices.entidades.Producto;
import com.odsaproject.sanarservices.servicios.AcompananteSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/acompanante", produces = "application/json")
public class AcompananteCtrl {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private AcompananteSrv acompananteSrv;
	
	@GetMapping("/firma")
	public Acompanante devolverFirma() {
		List<Producto> lstProducto = new ArrayList<Producto>();
		lstProducto.add(new Producto());
		Acompanante acomp = new Acompanante();
		acomp.setProductos(lstProducto);
		
		return acomp;
	}
	
	@RequestMapping
	public List<Acompanante> listarTodo() {
		List<Acompanante> result = acompananteSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Acompanante acomp) {
		
		return ResponseEntity.ok(acompananteSrv.crear(acomp));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Acompanante acomp) {
		
		return ResponseEntity.ok(acompananteSrv.crear(acomp));
	}
	
	@GetMapping("/id/{id}")
	public Acompanante devolverPorId(@PathVariable("id") Long id) {
		Optional<Acompanante> result = acompananteSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Acompanante devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Acompanante> result = acompananteSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el acompañante: " + nombre);
			
		return result.orElse(null);
	}
	
	/*@GetMapping("/tipoAcompanante/{ta}")
	public List<Acompanante> devolverPorTipoAcomp(@PathVariable("ta") Long ta) {
		List<Acompanante> result = acompananteSrv.devolverPorTipoAcompanante(ta);
		
		return result;
	}*/

}
