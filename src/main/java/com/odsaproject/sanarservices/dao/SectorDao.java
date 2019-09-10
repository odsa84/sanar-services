/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odsaproject.sanarservices.entidades.Ciudad;
import com.odsaproject.sanarservices.entidades.Sector;

/**
 * @author Osvaldo
 *
 */
public interface SectorDao extends JpaRepository<Sector, Long> {

//	@Query("FROM Sector WHERE Ciudad.id = :idCiudad")
//	public List<Sector> findByIdCiudad(@Param("idCiudad") Long idCiudad);
	public List<Sector> findByCiudad(Ciudad ciudad);
	
	public Optional<Sector> findByNombre(String nombre);
}
