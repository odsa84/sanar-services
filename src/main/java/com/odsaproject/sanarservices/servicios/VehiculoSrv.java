/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.VehiculoDao;
import com.odsaproject.sanarservices.entidades.Vehiculo;

/**
 * @author Osvaldo
 *
 */
@Service
public class VehiculoSrv {

	@Autowired
	private VehiculoDao vehiculoDao;

	public Vehiculo crear(Vehiculo vehiculo) {
		Vehiculo result = null;
		result = vehiculoDao.save(vehiculo);

		return result;
	}
	
	public List<Vehiculo> devolverTodo() {
		List<Vehiculo> result = new ArrayList<>();
		result = (List<Vehiculo>) vehiculoDao.findAllByEstadoTrue();

		return result;
	}
	
	public Optional<Vehiculo> devolverPorId(Long idVehiculo) {
		Optional<Vehiculo> result = vehiculoDao.findById(idVehiculo);

		return result;
	}
	
	public List<Vehiculo> devolverPorTipoVehiculo(Long idTVehiculo) {
		List<Vehiculo> result = vehiculoDao.findByTipoVehiculo(idTVehiculo);

		return result;
	}

}
