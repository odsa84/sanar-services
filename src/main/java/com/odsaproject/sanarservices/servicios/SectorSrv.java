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
import com.odsaproject.sanarservices.entidades.Sector;

/**
 * @author Osvaldo
 *
 */
@Service
public class SectorSrv {
	
	@Autowired
	private SectorDao sectorDao;
	
	public List<Sector> devolverTodo() {
		List<Sector> result = new ArrayList<>();
		result = (List<Sector>) sectorDao.findByEstadoTrue();

		return result;
	}
	
	public Sector crear(Sector sector) {
		Sector result = null;
		result = sectorDao.save(sector);

		return result;
	}
	
	public Optional<Sector> devolverPorId(Long id) {
		 return sectorDao.findSecById(id);

	}
	
	public List<Sector> devolverPorIdCiudad(Long idCiudad) {
		List<Sector> result = new ArrayList<>();
		result = (List<Sector>) sectorDao.findByCiudad(idCiudad);

		return result;
	}
	
	public Optional<Sector> devolverPorNombre(String nombre) {
		Optional<Sector> result = sectorDao.findSecByNombre(nombre);
		
		return result;		
	}

}
