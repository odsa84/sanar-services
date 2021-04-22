/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.ProductoDao;
import com.odsaproject.sanarservices.entidades.Acompanante;
import com.odsaproject.sanarservices.entidades.Producto;

/**
 * @author Osvaldo
 *
 */
@Service
public class ProductoSrv {
	
	@Autowired
	private ProductoDao productoDao;
	
	public List<Producto> devolverTodo() {
		List<Producto> result = new ArrayList<>();
		result = (List<Producto>) productoDao.findAll();

		return result;
	}

	public Producto crear(Producto producto) {
		Producto result = null;
		result = productoDao.save(producto);

		return result;
	}

	public Optional<Producto> devolverPorId(Long id) {
		Optional<Producto> result = productoDao.findProdById(id);

		return result;

	}
	
	public Optional<Producto> devolverPorNombre(String nombre) {
		Optional<Producto> result = productoDao.findProdByNombre(nombre);

		return result;

	}
	
	public List<Producto> devolverPorServicio(Long idServicio) {
		List<Producto> result = new ArrayList<>();
		result = productoDao.findByServicio(idServicio);
		
		return result;
	}
	
	public List<Producto> devolverPorTipoProducto(Long idTipoProducto) {
		List<Producto> result = new ArrayList<>();
		result = productoDao.findByTipoProducto(idTipoProducto);
		
		return result;
	}
	
	public List<Producto> devolverPorStockTrue() {
		List<Producto> result = new ArrayList<>();
		result = productoDao.findByStockTrue();
		
		return result;
	}
	
	public List<Producto> devolverPorStockFalse() {
		List<Producto> result = new ArrayList<>();
		result = productoDao.findByStockFalse();
		
		return result;
	}
	
	public List<Producto> devolverPorServTipoProducto(Long idServ, Long idTipoProducto) {
		List<Producto> result = new ArrayList<>();
		result = productoDao.findByServicioTipoProducto(idServ, idTipoProducto);
		
		return result;
	}
	
	public List<Producto> devolverAcompanantes(Acompanante acomp) {
		List<Producto> result = new ArrayList<>();
		result = productoDao.findAllByAcompanantes(acomp);
		
		return result;
	}

}
