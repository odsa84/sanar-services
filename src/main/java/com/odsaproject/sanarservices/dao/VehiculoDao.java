/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Vehiculo;

/**
 * @author Osvaldo
 *
 */
public interface VehiculoDao extends JpaRepository<Vehiculo, Long> {
	
	@Query("SELECT v FROM Vehiculo v WHERE v.tipoVehiculo.id = :id AND v.estado = 1")
	List<Vehiculo> findByTipoVehiculo(@Param("id") long id);
	
	@Query("SELECT v FROM Vehiculo v WHERE v.id = :id AND v.estado = 1")
	Optional<Vehiculo> findById(@Param("id") long id);
	
	@Query("SELECT v FROM Vehiculo v WHERE v.estado = 1")
	List<Vehiculo> findAllByEstadoTrue();

}
