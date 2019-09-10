/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.ProvinciaDao;
import com.odsaproject.sanarservices.entidades.Provincia;

/**
 * @author Osvaldo
 *
 */
@Service
public class ProvinciaSrv {
	
	@Autowired
	private ProvinciaDao provinciaDao;
	
	public List<Provincia> devolverTodo() {
		List<Provincia> result = new ArrayList<>();
		result = (List<Provincia>) provinciaDao.findByEstadoTrue();

		return result;
	}
	
	public Provincia crear(Provincia provincia) {
		Provincia result = null;
		result = provinciaDao.save(provincia);

		return result;
	}
	
	public Optional<Provincia> devolverPorId(Long id) {
		return provinciaDao.findProvById(id);

	}
	
	public Optional<Provincia> devolverPorNombre(String nombre) {
		Optional<Provincia> result = provinciaDao.findProvByNombre(nombre);
		
		return result;
	}
}
