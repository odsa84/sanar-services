/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Ciudad;

/**
 * @author Osvaldo
 *
 */
public interface CiudadDao extends JpaRepository<Ciudad, Long> {

	@Query("SELECT c FROM Ciudad c WHERE c.estado = 1")
	List<Ciudad> findByEstadoTrue();
	
	@Query("SELECT c FROM Ciudad c WHERE c.id = :id AND c.estado = 1")
	public Optional<Ciudad> findCiuById(@Param("id") long id);
	
	@Query("SELECT c FROM Ciudad c WHERE c.provincia.id = :id AND c.estado = 1")
	public List<Ciudad> findByProvincia(@Param("id") long id);
	
	@Query("SELECT c FROM Ciudad c WHERE c.nombre = :nombre AND c.estado = 1")
	public Optional<Ciudad> findCiuByNombre(@Param("nombre") String nombre);
}
