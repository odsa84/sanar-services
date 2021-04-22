/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Modopago;

/**
 * @author Osvaldo
 *
 */
public interface ModopagoDao extends JpaRepository<Modopago, Long> {
	
	@Query("SELECT mp FROM Modopago mp WHERE mp.nombre = :nombre AND mp.estado = 1")
	Optional<Modopago> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT mp FROM Modopago mp WHERE mp.id = :id AND mp.estado = 1")
	Optional<Modopago> findById(@Param("id") long id);
	
	@Query("SELECT mp FROM Modopago mp WHERE mp.estado = 1")
	List<Modopago> findAllByEstadoTrue();

}
