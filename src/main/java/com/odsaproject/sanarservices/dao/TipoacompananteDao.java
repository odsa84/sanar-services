/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Tipoacompanante;

/**
 * @author Osvaldo
 *
 */
public interface TipoacompananteDao extends JpaRepository<Tipoacompanante, Long> {
	
	@Query("SELECT ta FROM Tipoacompanante ta WHERE ta.servicio.id = :id AND ta.estado = 1")
	List<Tipoacompanante> findByServicio(@Param("id") long id);
	
	@Query("SELECT ta FROM Tipoacompanante ta WHERE ta.marca.id = :id AND ta.estado = 1")
	List<Tipoacompanante> findByMarca(@Param("id") long id);
	
	@Query("SELECT ta FROM Tipoacompanante ta WHERE ta.nombre = :nombre AND ta.estado = 1")
	Optional<Tipoacompanante> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT ta FROM Tipoacompanante ta WHERE ta.id = :id AND ta.estado = 1")
	Optional<Tipoacompanante> findById(@Param("id") long id);
	
	@Query("SELECT ta FROM Tipoacompanante ta WHERE ta.estado = 1")
	List<Tipoacompanante> findAllByEstadoTrue();

}
