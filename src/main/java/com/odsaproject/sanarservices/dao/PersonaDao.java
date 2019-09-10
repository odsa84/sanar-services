/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Persona;

/**
 * @author Osvaldo
 *
 */
public interface PersonaDao extends JpaRepository<Persona, Long> {
//	JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
//	CrudRepository mainly provides CRUD functions.
//	PagingAndSortingRepository provides methods to do pagination and sorting records.
//	JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
	
	@Query("SELECT p FROM Persona p WHERE p.estado = 1")
	List<Persona> findByEstadoTrue();
	
	@Query("SELECT p FROM Persona p WHERE p.cedula = :cedula AND p.estado = 1")
	public Optional<Persona> findByCedula(String cedula);
	
	@Query("SELECT p FROM Persona p WHERE p.email = :email AND p.estado = 1")
	public Optional<Persona> findByEmail(String email);
	
	@Query("SELECT p FROM Persona p WHERE p.password = :pass AND p.email = :mail AND p.estado = 1")
	public Optional<Persona> login(@Param("pass") String pass, @Param("mail") String mail);
	
	@Query("SELECT p FROM Persona p WHERE p.id = :id AND p.estado = 1")
	public Optional<Persona> findPerById(@Param("id") long id);
}
