/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.ServicioDao;
import com.odsaproject.sanarservices.entidades.Servicio;

/**
 * @author Osvaldo
 *
 */
@Service
public class ServicioSrv {

	@Autowired
	private ServicioDao servicioDao;

	public List<Servicio> devolverTodo() {
		List<Servicio> result = new ArrayList<>();
		result = (List<Servicio>) servicioDao.findByEstadoTrue();

		return result;
	}

	public Servicio crear(Servicio servicio) {
		Servicio result = null;
		result = servicioDao.save(servicio);

		return result;
	}

	public Optional<Servicio> devolverPorId(Long id) {
		Optional<Servicio> result = servicioDao.findServById(id);

		return result;

	}
	
	public List<Servicio> devolverPorPersona(Long idPersona) {
		List<Servicio> result = new ArrayList<>();
		result = servicioDao.findByPersona(idPersona);
		
		return result;
	}
	
	public List<Servicio> devolverPorCategoria(Long idCategoria) {
		List<Servicio> result = new ArrayList<>();
		//Optional<Categoria> categoria = categoriaSrv.devolverPorId(idCategoria);
		//if(categoria.isPresent())
		result = servicioDao.findByCategoria(idCategoria);
		
		return result;
	}
	
	public List<Servicio> devolverPorSector(Long idSector) {
		List<Servicio> result = new ArrayList<>();
		//Optional<Sector> sector = sectorSrv.devolverPorId(idSector);
		//if(sector.isPresent())
			result = servicioDao.findBySector(idSector);
		
		return result;
	}
}
