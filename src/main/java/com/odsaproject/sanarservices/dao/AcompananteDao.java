/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Acompanante;

/**
 * @author Osvaldo
 *
 */
public interface AcompananteDao extends JpaRepository<Acompanante, Long> {
	
	/*@Query("SELECT a FROM Acompanante a WHERE a.tipoAcompanante.id = :id AND a.estado = 1")
	List<Acompanante> findByTipoAcompanante(@Param("id") long id);*/
	
	@Query("SELECT a FROM Acompanante a WHERE a.nombre = :nombre AND a.estado = 1")
	Optional<Acompanante> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT a FROM Acompanante a WHERE a.id = :id AND a.estado = 1")
	Optional<Acompanante> findById(@Param("id") long id);
	
	@Query("SELECT a FROM Acompanante a WHERE a.estado = 1")
	List<Acompanante> findAllByEstadoTrue();

}
