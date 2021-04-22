/**
 * 
 */
package com.odsaproject.sanarservices.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odsaproject.sanarservices.dao.ComboDao;
import com.odsaproject.sanarservices.entidades.Combo;
import com.odsaproject.sanarservices.entidades.Producto;

/**
 * @author Osvaldo
 *
 */
@Service
public class ComboSrv {
	
	@Autowired
	private ComboDao comboDao;
	
	public List<Combo> devolverTodo() {
		List<Combo> result = new ArrayList<>();
		result = (List<Combo>) comboDao.findAllByEstadoTrue();

		return result;
	}

	public Combo crear(Combo combo) {
		Combo result = null;
		result = comboDao.save(combo);

		return result;
	}

	public Optional<Combo> devolverPorId(Long id) {
		Optional<Combo> result = comboDao.findById(id);

		return result;
	}
	
	public List<Combo> devolverPorPrecio(float precio) {
		List<Combo> result = comboDao.findByPrice(precio);

		return result;
	}
	
	public List<Combo> devolverPorProducto(Producto prod) {
		List<Combo> result = comboDao.findAllByProductos(prod);
		
		return result;
	}
	
	public List<Combo> devolverPorNombreProducto(String nombreProd) {
		List<Combo> result = comboDao.findByProductos_Nombre(nombreProd);
		//List<Combo> result = comboDao.findAllByNombreProducto(nombreProd);
		
		return result;
	}

}
