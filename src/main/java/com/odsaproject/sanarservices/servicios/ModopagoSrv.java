/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.ModopagoDao;
import com.odsaproject.sanarservices.entidades.Modopago;

/**
 * @author Osvaldo
 *
 */
@Service
public class ModopagoSrv {

	@Autowired
	private ModopagoDao modoPagoDao;

	public Modopago crear(Modopago modopago) {
		Modopago result = null;
		result = modoPagoDao.save(modopago);

		return result;
	}
	
	public List<Modopago> devolverTodo() {
		List<Modopago> result = new ArrayList<>();
		result = (List<Modopago>) modoPagoDao.findAllByEstadoTrue();
		return result;
	}
	
	public Optional<Modopago> devolverPorId(Long idModopago) {
		Optional<Modopago> result = modoPagoDao.findById(idModopago);

		return result;
	}
	
	public Optional<Modopago> devolverPorNombre(String nombre) {
		Optional<Modopago> result = modoPagoDao.findByNombre(nombre);

		return result;
	}

}
