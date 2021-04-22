/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.RepartidorDao;
import com.odsaproject.sanarservices.entidades.Repartidor;

/**
 * @author Osvaldo
 *
 */
@Service
public class RepartidorSrv {
	
	@Autowired
	private RepartidorDao repartidorDao;
	
	public List<Repartidor> devolverTodo() {
		List<Repartidor> result = new ArrayList<>();
		result = (List<Repartidor>) repartidorDao.findAllByEstadoTrue();

		return result;
	}

	public Repartidor crear(Repartidor repartidor) {
		Repartidor result = null;
		result = repartidorDao.save(repartidor);

		return result;
	}

	public Optional<Repartidor> devolverPorId(Long id) {
		Optional<Repartidor> result = null;
		result = repartidorDao.findById(id);

		return result;

	}
	
	public List<Repartidor> devolverPorNombre(String nombre) {
		List<Repartidor> result = repartidorDao.findByNombre(nombre);

		return result;

	}
	
	public List<Repartidor> devolverPorApellido(String apellido) {
		List<Repartidor> result = new ArrayList<>();
		result = repartidorDao.findByApellido(apellido);
		
		return result;
	}
	
	public List<Repartidor> devolverPorNombreApellido(String nombre, String apellido) {
		List<Repartidor> result = new ArrayList<>();
		result = repartidorDao.findByNombreYApellido(nombre, apellido);
		
		return result;
	}
	
	public Optional<Repartidor> devolverPorCedula(String cedula) {
		Optional<Repartidor> result = null;
		result = repartidorDao.findByCedula(cedula);

		return result;
	}
	
	public Optional<Repartidor> devolverPorEmail(String mail) {
		Optional<Repartidor> result = null;
		result = repartidorDao.findByMail(mail);

		return result;
	}
	
	public Optional<Repartidor> devolverPorTelefono(String telefono) {
		Optional<Repartidor> result = null;
		result = repartidorDao.findByTelefono(telefono);

		return result;
	}
	
	public List<Repartidor> devolverPorVehiculo(Long idVehiculo) {
		List<Repartidor> result = new ArrayList<>();
		result = repartidorDao.findByVehiculo(idVehiculo);
		
		return result;
	}
	
	public List<Repartidor> devolverOnLine() {
		List<Repartidor> result = new ArrayList<>();
		result = repartidorDao.findOnLine();
		
		return result;
	}
	
	public List<Repartidor> devolverOffLine() {
		List<Repartidor> result = new ArrayList<>();
		result = repartidorDao.findOffLine();
		
		return result;
	}
	
	public Optional<Repartidor> login(String pass, String mail) {
		Optional<Repartidor> result = null;
		result = repartidorDao.login(pass, mail);
		
		return result;
	}

}
