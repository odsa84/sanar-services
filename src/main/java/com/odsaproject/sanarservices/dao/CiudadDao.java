/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odsaproject.sanarservices.entidades.Ciudad;
import com.odsaproject.sanarservices.entidades.Provincia;

/**
 * @author Osvaldo
 *
 */
public interface CiudadDao extends JpaRepository<Ciudad, Long> {

//	@Query("FROM Ciudad WHERE Provincia.id = :idProvincia")
//	public List<Ciudad> findByIdProvincia(@Param("idProvincia") Long idProvincia);
	
	public List<Ciudad> findByProvincia(Provincia provincia);
	
	public Optional<Ciudad> findByNombre(String nombre);
}
