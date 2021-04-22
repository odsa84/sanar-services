/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Tipoproducto;

/**
 * @author Osvaldo
 *
 */
public interface TipoproductoDao extends JpaRepository<Tipoproducto, Long> {
	
	@Query("SELECT tp FROM Tipoproducto tp WHERE tp.categoria.id = :id AND tp.estado = 1")
	List<Tipoproducto> findByCategoria(@Param("id") long id);
	
	@Query("SELECT tp FROM Tipoproducto tp WHERE tp.nombre = :nombre AND tp.estado = 1")
	Optional<Tipoproducto> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT tp FROM Tipoproducto tp WHERE tp.id = :id AND tp.estado = 1")
	Optional<Tipoproducto> findTipoProdById(@Param("id") long id);
	
	@Query("SELECT tp FROM Tipoproducto tp WHERE tp.estado = 1")
	List<Tipoproducto> findByEstadoTrue();

}
