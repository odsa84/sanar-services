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

import com.odsaproject.sanarservices.entidades.Combo;
import com.odsaproject.sanarservices.entidades.Producto;
import com.odsaproject.sanarservices.servicios.ComboSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/combo", produces = "application/json")
public class ComboCtrl {

	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private ComboSrv comboSrv;
	
	@GetMapping("/firma")
	public Combo devolverFirma() {
		List<Producto> lstProducto = new ArrayList<Producto>();
		lstProducto.add(new Producto());
		Combo combo = new Combo();
		combo.setProductos(lstProducto);
		
		return combo;
	}
	
	@RequestMapping
	public List<Combo> listarTodo() {
		List<Combo> result = comboSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Combo c) {
		
		return ResponseEntity.ok(comboSrv.crear(c));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Combo c) {
		
		return ResponseEntity.ok(comboSrv.crear(c));
	}
	
	@GetMapping("/id/{id}")
	public Combo devolverPorId(@PathVariable("id") Long id) {
		Optional<Combo> result = comboSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/producto/{prod}")
	public List<Combo> devolverPorProducto(@PathVariable("prod") Producto prod) {
		List<Combo> result = comboSrv.devolverPorProducto(prod);
		
		return result;
	}
	
	@GetMapping("/nombrProducto/{nombre}")
	public List<Combo> devolverPorNombreProducto(@PathVariable("nombre") String nombre) {
		List<Combo> result = comboSrv.devolverPorNombreProducto(nombre);
		
		return result;
	}
	
	@GetMapping("/precio/{precio}")
	public List<Combo> devolverPorFecha(@PathVariable("precio") float precio) {
		List<Combo> result = comboSrv.devolverPorPrecio(precio);
		
		return result;
	}

}
