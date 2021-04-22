/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.TipovehiculoDao;
import com.odsaproject.sanarservices.entidades.Tipovehiculo;

/**
 * @author Osvaldo
 *
 */
@Service
public class TipovehiculoSrv {

	@Autowired
	private TipovehiculoDao tipoVehiculoDao;

	public Tipovehiculo crear(Tipovehiculo tipoVehiculo) {
		Tipovehiculo result = null;
		result = tipoVehiculoDao.save(tipoVehiculo);

		return result;
	}
	
	public List<Tipovehiculo> devolverTodo() {
		List<Tipovehiculo> result = new ArrayList<>();
		result = (List<Tipovehiculo>) tipoVehiculoDao.findAllByEstadoTrue();

		return result;
	}
	
	public Optional<Tipovehiculo> devolverPorId(Long idTVehiculo) {
		Optional<Tipovehiculo> result = tipoVehiculoDao.findById(idTVehiculo);

		return result;
	}
	
	public Optional<Tipovehiculo> devolverPorNombre(String nombre) {
		Optional<Tipovehiculo> result = tipoVehiculoDao.findByNombre(nombre);

		return result;
	}

}
