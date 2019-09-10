/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.CategoriaDao;
import com.odsaproject.sanarservices.entidades.Categoria;


/**
 * @author Osvaldo
 *
 */
@Service
public class CategoriaSrv {

	@Autowired
	private CategoriaDao categoriaDao;
	
	public List<Categoria> devolverTodo() {
		List<Categoria> result = null;
		result = (List<Categoria>) categoriaDao.findByEstadoTrue();

		return result;
	}

	public Categoria crear(Categoria Persona) {
		Categoria result = null;
		result = categoriaDao.save(Persona);

		return result;
	}

	public Optional<Categoria> devolverPorId(Long id) {
		return categoriaDao.findCatById(id);

	}
}
