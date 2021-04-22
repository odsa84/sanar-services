/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.PedidoDao;
import com.odsaproject.sanarservices.entidades.Pedido;
import com.odsaproject.sanarservices.entidades.Producto;

/**
 * @author Osvaldo
 *
 */
@Service
public class PedidoSrv {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	public List<Pedido> devolverTodo() {
		List<Pedido> result = new ArrayList<>();
		result = (List<Pedido>) pedidoDao.findAll();

		return result;
	}

	public Pedido crear(Pedido pedido) {
		Pedido result = null;
		result = pedidoDao.save(pedido);

		return result;
	}

	public Optional<Pedido> devolverPorId(Long id) {
		Optional<Pedido> result = pedidoDao.findById(id);

		return result;
	}
	
	public List<Pedido> devolverPorUsuario(Long idUser) {
		List<Pedido> result = pedidoDao.findByPersona(idUser);

		return result;
	}
	
	public List<Pedido> devolverPorEstado(Long idEstado) {
		List<Pedido> result = pedidoDao.findByEstado(idEstado);

		return result;
	}
	
	public List<Pedido> devolverPorModoPago(Long idMP) {
		List<Pedido> result = pedidoDao.findByModoPago(idMP);
		
		return result;
	}
	
	public List<Pedido> devolverPorFecha(Date fecha) {
		List<Pedido> result = pedidoDao.findByDate(fecha);
		
		return result;
	}
	
	public List<Pedido> devolverPorProducto(Producto prod) {
		List<Pedido> result = pedidoDao.findAllByProductos(prod);
		
		return result;

	}
	
	public List<Pedido> devolverPorNombreProducto(String nombreProd) {
		List<Pedido> result = pedidoDao.findByProductos_Nombre(nombreProd);
		//List<Pedido> result = pedidoDao.findAllByNombreProducto(nombreProd);
		
		return result;

	}

}
