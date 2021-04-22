/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Tipovehiculo;

/**
 * @author Osvaldo
 *
 */
public interface TipovehiculoDao extends JpaRepository<Tipovehiculo, Long> {
	
	@Query("SELECT tv FROM Tipovehiculo tv WHERE tv.nombre = :nombre AND tv.estado = 1")
	Optional<Tipovehiculo> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT tv FROM Tipovehiculo tv WHERE tv.id = :id AND tv.estado = 1")
	Optional<Tipovehiculo> findById(@Param("id") long id);
	
	@Query("SELECT tv FROM Tipovehiculo tv WHERE tv.estado = 1")
	List<Tipovehiculo> findAllByEstadoTrue();

}
