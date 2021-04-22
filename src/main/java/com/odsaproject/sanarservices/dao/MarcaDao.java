/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Marca;

/**
 * @author Osvaldo
 *
 */
public interface MarcaDao extends JpaRepository<Marca, Long> {
	
	@Query("SELECT m FROM Marca m WHERE m.nombre = :nombre AND m.estado = 1")
	Optional<Marca> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT m FROM Marca m WHERE m.id = :id AND m.estado = 1")
	Optional<Marca> findById(@Param("id") long id);
	
	@Query("SELECT m FROM Marca m WHERE m.estado = 1")
	List<Marca> findAllByEstadoTrue();

}
