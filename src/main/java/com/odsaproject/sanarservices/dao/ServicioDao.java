/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Servicio;

/**
 * @author Osvaldo
 *
 */
public interface ServicioDao extends JpaRepository<Servicio, Long> {
//	JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
//	CrudRepository mainly provides CRUD functions.
//	PagingAndSortingRepository provides methods to do pagination and sorting records.
//	JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
	@Query("SELECT s FROM Servicio s WHERE s.persona.id = :id AND s.estado = 1")
	List<Servicio> findByPersona(@Param("id") long id);
	
	@Query("SELECT s FROM Servicio s WHERE s.categoria.id = :id AND s.estado = 1")
	List<Servicio> findByCategoria(@Param("id") long id);
	
	@Query("SELECT s FROM Servicio s WHERE s.sector.id = :id AND s.estado = 1")
	List<Servicio> findBySector(@Param("id") long id);
	
	@Query("SELECT s FROM Servicio s WHERE s.estado = 1")
	List<Servicio> findByEstadoTrue();
	
	@Query("SELECT s FROM Servicio s WHERE s.id = :id AND s.estado = 1")
	Optional<Servicio> findServById(@Param("id") long id);
}
