/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.EstadoDao;
import com.odsaproject.sanarservices.entidades.Estado;

/**
 * @author Osvaldo
 *
 */
@Service
public class EstadoSrv {

	@Autowired
	private EstadoDao estadoDao;

	public Estado crear(Estado estado) {
		Estado result = null;
		result = estadoDao.save(estado);

		return result;
	}
	
	public List<Estado> devolverTodo() {
		List<Estado> result = new ArrayList<>();
		result = (List<Estado>) estadoDao.findAllByEstadoTrue();

		return result;
	}
	
	public Optional<Estado> devolverPorId(Long idEstado) {
		Optional<Estado> result = estadoDao.findById(idEstado);

		return result;
	}
	
	public Optional<Estado> devolverPorNombre(String nombre) {
		Optional<Estado> result = estadoDao.findByNombre(nombre);

		return result;
	}

}
