/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.TipoproductoDao;
import com.odsaproject.sanarservices.entidades.Tipoproducto;

/**
 * @author Osvaldo
 *
 */
@Service
public class TipoproductoSrv {

	@Autowired
	private TipoproductoDao tipoProductoDao;

	public Tipoproducto crear(Tipoproducto tipoProducto) {
		Tipoproducto result = null;
		result = tipoProductoDao.save(tipoProducto);

		return result;
	}
	
	public List<Tipoproducto> devolverTodo() {
		List<Tipoproducto> result = new ArrayList<>();
		result = (List<Tipoproducto>) tipoProductoDao.findByEstadoTrue();

		return result;
	}
	
	public List<Tipoproducto> devolverPorCategoria(Long id) {
		List<Tipoproducto> result = tipoProductoDao.findByCategoria(id);

		return result;

	}
	
	public Optional<Tipoproducto> devolverPorNombre(String nombre) {
		Optional<Tipoproducto> result = tipoProductoDao.findByNombre(nombre);

		return result;
	}
	
	public Optional<Tipoproducto> devolverPorId(Long id) {
		Optional<Tipoproducto> result = tipoProductoDao.findTipoProdById(id);

		return result;

	}

}
