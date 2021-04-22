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

import com.odsaproject.sanarservices.entidades.Acompanante;
import com.odsaproject.sanarservices.entidades.Producto;
import com.odsaproject.sanarservices.servicios.AcompananteSrv;
import com.odsaproject.sanarservices.servicios.ProductoSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/producto", produces = "application/json")
public class ProductoCtrl {

	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private ProductoSrv productoSrv;
	
	@Autowired
	private AcompananteSrv acompananteSrv;
	
	@RequestMapping
	public List<Producto> listarTodo() {
		List<Producto> result = productoSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Producto producto) {
		
		return ResponseEntity.ok(productoSrv.crear(producto));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Producto producto) {
		
		return ResponseEntity.ok(productoSrv.crear(producto));
	}
	
	@GetMapping("/id/{id}")
	public Producto devolverPorId(@PathVariable("id") Long id) {
		Optional<Producto> result = productoSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Producto devolverPorNombre(@PathVariable("nombre") String nombre) {
		Optional<Producto> result = productoSrv.devolverPorNombre(nombre);
		if(!result.isPresent())
			LOGGER.error("No exsite el producto: " + nombre);
			
		return result.orElse(null);
	}
	
	@GetMapping("/servicio/{serv}")
	public List<Producto> devolverPorServicio(@PathVariable("serv") Long idServicio) {
		List<Producto> result = productoSrv.devolverPorServicio(idServicio);
		
		return result;
	}
	
	@GetMapping("/tipoProducto/{tp}")
	public List<Producto> devolverPorTipoProducto(@PathVariable("tp") Long idTipoProducto) {
		List<Producto> result = productoSrv.devolverPorTipoProducto(idTipoProducto);
		
		return result;
	}
	
	@GetMapping("/stockTrue")
	public List<Producto> devolverPorStockTrue() {
		List<Producto> result = productoSrv.devolverPorStockTrue();
		
		return result;
	}
	
	@GetMapping("/stockFalse")
	public List<Producto> devolverPorStockFalse() {
		List<Producto> result = productoSrv.devolverPorStockFalse();
		
		return result;
	}
	
	@GetMapping("/servicio/tipoProducto/{serv}/{tp}")
	public List<Producto> devolverPorServTipoProducto(@PathVariable("serv") Long idServ, @PathVariable("tp") Long idTipoProducto) {
		List<Producto> result = productoSrv.devolverPorServTipoProducto(idServ, idTipoProducto);
		
		return result;
	}
	
	@GetMapping("/acompanantes/{idAcomp}")
	public List<Producto> devolverAcompanantes(@PathVariable("idAcomp") Long idAcomp) {
		Optional<Acompanante> prdAux = acompananteSrv.devolverPorId(idAcomp);
		List<Producto> result = null;
		if(prdAux.isPresent())
			result = productoSrv.devolverAcompanantes(prdAux.get());
		
		return result;
	}

}
