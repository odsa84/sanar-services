/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Provincia;

/**
 * @author Osvaldo
 *
 */
public interface ProvinciaDao extends JpaRepository<Provincia, Long> {

	@Query("SELECT p FROM Provincia p WHERE p.estado = 1")
	List<Provincia> findByEstadoTrue();
	
	@Query("SELECT p FROM Provincia p WHERE p.id = :id AND p.estado = 1")
	public Optional<Provincia> findProvById(@Param("id") long id);
	
	@Query("SELECT p FROM Provincia p WHERE p.nombre = :nombre AND p.estado = 1")
	public Optional<Provincia> findProvByNombre(@Param("nombre") String nombre);
}
