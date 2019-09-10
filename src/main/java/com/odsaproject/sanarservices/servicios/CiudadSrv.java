/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.CiudadDao;
import com.odsaproject.sanarservices.entidades.Ciudad;
import com.odsaproject.sanarservices.entidades.Provincia;

/**
 * @author Osvaldo
 *
 */
@Service
public class CiudadSrv {

	@Autowired
	private CiudadDao ciudadDao;
	
	@Autowired
	private ProvinciaSrv provinciaSrv;
	
	public List<Ciudad> devolverTodo() {
		List<Ciudad> result = new ArrayList<>();
		result = (List<Ciudad>) ciudadDao.findAll();

		return result;
	}
	
	public Ciudad crear(Ciudad ciudad) {
		Ciudad result = null;
		result = ciudadDao.save(ciudad);

		return result;
	}
	
	public Optional<Ciudad> devolverPorId(Long id) {
		return ciudadDao.findById(id);

	}
	
	public List<Ciudad> devolverPorIdProvincia(Long idProvincia) {
		List<Ciudad> result = new ArrayList<>();
		Optional<Provincia> provincia = provinciaSrv.devolverPorId(idProvincia);
		if(provincia.isPresent())
			result = (List<Ciudad>) ciudadDao.findByProvincia(provincia.get());

		return result;
	}
	
	public Optional<Ciudad> devolverPorNombre(String nombre) {
		Optional<Ciudad> result = ciudadDao.findByNombre(nombre);
		
		return result;
	}
	
}
