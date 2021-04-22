/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Combo;
import com.odsaproject.sanarservices.entidades.Producto;

/**
 * @author Osvaldo
 *
 */
public interface ComboDao extends JpaRepository<Combo, Long> {
	
	@Query("SELECT c FROM Combo c WHERE c.nombre = :nombre AND c.estado = 1")
	Optional<Combo> findByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT c FROM Combo c WHERE c.id = :id AND c.estado = 1")
	Optional<Combo> findById(@Param("id") long id);
	
	@Query("SELECT c FROM Combo c WHERE c.estado = 1")
	List<Combo> findAllByEstadoTrue();
	
	@Query("SELECT c FROM Combo c WHERE c.precio = :price AND c.estado = 1")
	List<Combo> findByPrice(@Param("price") float prece);
	
	List<Combo> findAllByProductos(Producto prod);
	
	// Los dos queries siguientes hacen lo mismo
	List<Combo> findByProductos_Nombre(String nombre);
	
	@Query("SELECT c FROM Combo c JOIN Producto p WHERE p.nombre = :nombre")
	List<Combo> findAllByNombreProducto(@Param("nombre") String nombre);

}
