/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.SectorDao;
import com.odsaproject.sanarservices.entidades.Ciudad;
import com.odsaproject.sanarservices.entidades.Sector;

/**
 * @author Osvaldo
 *
 */
@Service
public class SectorSrv {
	
	@Autowired
	private SectorDao sectorDao;
	@Autowired
	private CiudadSrv ciudadSrv;
	
	public List<Sector> devolverTodo() {
		List<Sector> result = new ArrayList<>();
		result = (List<Sector>) sectorDao.findAll();

		return result;
	}
	
	public Sector crear(Sector sector) {
		Sector result = null;
		result = sectorDao.save(sector);

		return result;
	}
	
	public Optional<Sector> devolverPorId(Long id) {
		 return sectorDao.findById(id);

	}
	
	public List<Sector> devolverPorIdCiudad(Long idCiudad) {
		List<Sector> result = new ArrayList<>();
		Optional<Ciudad> ciudad = ciudadSrv.devolverPorId(idCiudad);
		if(ciudad.isPresent())
			result = (List<Sector>) sectorDao.findByCiudad(ciudad.get());

		return result;
	}
	
	public Optional<Sector> devolverPorNombre(String nombre) {
		Optional<Sector> result = sectorDao.findByNombre(nombre);
		
		return result;		
	}

}
