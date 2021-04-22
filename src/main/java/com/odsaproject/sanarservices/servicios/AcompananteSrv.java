/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.AcompananteDao;
import com.odsaproject.sanarservices.entidades.Acompanante;

/**
 * @author Osvaldo
 *
 */
@Service
public class AcompananteSrv {

	@Autowired
	private AcompananteDao acompananteDao;

	public Acompanante crear(Acompanante acompanante) {
		Acompanante result = null;
		result = acompananteDao.save(acompanante);

		return result;
	}
	
	public List<Acompanante> devolverTodo() {
		List<Acompanante> result = new ArrayList<>();
		result = (List<Acompanante>) acompananteDao.findAllByEstadoTrue();

		return result;
	}
	
	public Optional<Acompanante> devolverPorId(Long id) {
		Optional<Acompanante> result = acompananteDao.findById(id);

		return result;
	}
	
	public Optional<Acompanante> devolverPorNombre(String nombre) {
		Optional<Acompanante> result = acompananteDao.findByNombre(nombre);

		return result;
	}
	
	/*public List<Acompanante> devolverPorTipoAcompanante(Long idTA) {
		List<Acompanante> result = new ArrayList<>();
		result = (List<Acompanante>) acompananteDao.findByTipoAcompanante(idTA);

		return result;
	}*/

}
