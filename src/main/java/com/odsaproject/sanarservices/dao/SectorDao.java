/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Sector;

/**
 * @author Osvaldo
 *
 */
public interface SectorDao extends JpaRepository<Sector, Long> {


	@Query("SELECT s FROM Sector s WHERE s.estado = 1")
	List<Sector> findByEstadoTrue();
	
	@Query("SELECT s FROM Sector s WHERE s.id = :id AND s.estado = 1")
	public Optional<Sector> findSecById(@Param("id") long id);
	
	@Query("SELECT s FROM Sector s WHERE s.ciudad.id = :id AND s.estado = 1")
	public List<Sector> findByCiudad(@Param("id") long id);
	
	@Query("SELECT s FROM Sector s WHERE s.nombre = :nombre AND s.estado = 1")
	public Optional<Sector> findSecByNombre(String nombre);
}
