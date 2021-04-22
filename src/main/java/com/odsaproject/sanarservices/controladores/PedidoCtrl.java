/**
 * 
 */
package com.odsaproject.sanarservices.controladores;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.odsaproject.sanarservices.entidades.Pedido;
import com.odsaproject.sanarservices.entidades.Producto;
import com.odsaproject.sanarservices.servicios.PedidoSrv;

/**
 * @author Osvaldo
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/api/v1/pedido", produces = "application/json")
public class PedidoCtrl {

	public static final Logger LOGGER = LoggerFactory.getLogger(ServicioCtrl.class);
	
	@Autowired
	private PedidoSrv pedidoSrv;
	
	@GetMapping("/firma")
	public Pedido devolverFirma() {
		Set<Producto> lstProducto = new HashSet<Producto>();
		lstProducto.add(new Producto());
		Pedido pedido = new Pedido();
		pedido.setProductos(lstProducto);
		
		return pedido;
	}
	
	@RequestMapping
	public List<Pedido> listarTodo() {
		List<Pedido> result = pedidoSrv.devolverTodo();
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Pedido p) {
		
		return ResponseEntity.ok(pedidoSrv.crear(p));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/modificar")
	public ResponseEntity modificar(@RequestBody Pedido p) {
		
		return ResponseEntity.ok(pedidoSrv.crear(p));
	}
	
	@GetMapping("/id/{id}")
	public Pedido devolverPorId(@PathVariable("id") Long id) {
		Optional<Pedido> result = pedidoSrv.devolverPorId(id);
		if(!result.isPresent())
			LOGGER.error("No exsite id: " + id);
			
		return result.orElse(null);
	}
	
	@GetMapping("/usuario/{user}")
	public List<Pedido> devolverPorUsuario(@PathVariable("user") Long idUser) {
		List<Pedido> result = pedidoSrv.devolverPorUsuario(idUser);
		
		return result;
	}
	
	@GetMapping("/estado/{est}")
	public List<Pedido> devolverPorEstado(@PathVariable("est") Long est) {
		List<Pedido> result = pedidoSrv.devolverPorEstado(est);
		
		return result;
	}
	
	@GetMapping("/modoPago/{mp}")
	public List<Pedido> devolverPorModoPago(@PathVariable("mp") Long mp) {
		List<Pedido> result = pedidoSrv.devolverPorModoPago(mp);
		
		return result;
	}
	
	@GetMapping("/fecha/{fecha}")
	public List<Pedido> devolverPorFecha(@PathVariable("fecha") Date fecha) {
		List<Pedido> result = pedidoSrv.devolverPorFecha(fecha);
		
		return result;
	}
	
	@GetMapping("/producto/{prod}")
	public List<Pedido> devolverPorProducto(@PathVariable("prod") Producto prod) {
		List<Pedido> result = pedidoSrv.devolverPorProducto(prod);
		
		return result;
	}
	
	@GetMapping("/nombrProducto/{nombre}")
	public List<Pedido> devolverPorNombreProducto(@PathVariable("nombre") String nombre) {
		List<Pedido> result = pedidoSrv.devolverPorNombreProducto(nombre);
		
		return result;
	}

}
