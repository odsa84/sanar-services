/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Categoria;

/**
 * @author Osvaldo
 *
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long>{
//	JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
//	CrudRepository mainly provides CRUD functions.
//	PagingAndSortingRepository provides methods to do pagination and sorting records.
//	JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
	
	@Query("SELECT c FROM Categoria c WHERE c.estado = 1")
	List<Categoria> findByEstadoTrue();
	
	@Query("SELECT c FROM Categoria c WHERE c.id = :id")
	Optional<Categoria> findCatById(@Param("id") long id);
	
}
