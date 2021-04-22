/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.MarcaDao;
import com.odsaproject.sanarservices.entidades.Marca;

/**
 * @author Osvaldo
 *
 */
@Service
public class MarcaSrv {

	@Autowired
	private MarcaDao marcaDao;

	public Marca crear(Marca marca) {
		Marca result = null;
		result = marcaDao.save(marca);

		return result;
	}
	
	public List<Marca> devolverTodo() {
		List<Marca> result = new ArrayList<>();
		result = (List<Marca>) marcaDao.findAllByEstadoTrue();

		return result;
	}
	
	public Optional<Marca> devolverPorId(Long idMarca) {
		Optional<Marca> result = marcaDao.findById(idMarca);

		return result;
	}
	
	public Optional<Marca> devolverPorNombre(String nombre) {
		Optional<Marca> result = marcaDao.findByNombre(nombre);

		return result;
	}

}
