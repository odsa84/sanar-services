/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.TipoacompananteDao;
import com.odsaproject.sanarservices.entidades.Tipoacompanante;

/**
 * @author Osvaldo
 *
 */
@Service
public class TipoacompananteSrv {

	@Autowired
	private TipoacompananteDao tipoAcompananteDao;

	public Tipoacompanante crear(Tipoacompanante tipoAcompanante) {
		Tipoacompanante result = null;
		result = tipoAcompananteDao.save(tipoAcompanante);

		return result;
	}
	
	public List<Tipoacompanante> devolverTodo() {
		List<Tipoacompanante> result = new ArrayList<>();
		result = (List<Tipoacompanante>) tipoAcompananteDao.findAllByEstadoTrue();

		return result;
	}
	
	public Optional<Tipoacompanante> devolverPorId(Long id) {
		Optional<Tipoacompanante> result = tipoAcompananteDao.findById(id);

		return result;
	}
	
	public Optional<Tipoacompanante> devolverPorNombre(String nombre) {
		Optional<Tipoacompanante> result = tipoAcompananteDao.findByNombre(nombre);

		return result;
	}
	
	public List<Tipoacompanante> devolverPorServicio(Long idServicio) {
		List<Tipoacompanante> result = new ArrayList<>();
		result = (List<Tipoacompanante>) tipoAcompananteDao.findByServicio(idServicio);

		return result;
	}
	
	public List<Tipoacompanante> devolverPorMarca(Long idMarca) {
		List<Tipoacompanante> result = new ArrayList<>();
		result = (List<Tipoacompanante>) tipoAcompananteDao.findByMarca(idMarca);

		return result;
	}

}
