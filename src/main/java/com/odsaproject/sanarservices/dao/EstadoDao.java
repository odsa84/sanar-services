/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Estado;

/**
 * @author Osvaldo
 *
 */
public interface EstadoDao extends JpaRepository<Estado, Long> {
	
	@Query("SELECT e FROM Estado e WHERE e.nombre = :nombre AND e.estadoField = 1")
	Optional<Estado> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT e FROM Estado e WHERE e.id = :id AND e.estadoField = 1")
	Optional<Estado> findById(@Param("id") long id);
	
	@Query("SELECT e FROM Estado e WHERE e.estadoField = 1")
	List<Estado> findAllByEstadoTrue();

}
