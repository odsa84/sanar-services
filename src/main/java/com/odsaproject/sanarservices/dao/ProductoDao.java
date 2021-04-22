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
import com.odsaproject.sanarservices.entidades.Producto;

/**
 * @author Osvaldo
 *
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {
	
	@Query("SELECT p FROM Producto p WHERE p.estado = 1")
	List<Producto> findAll();
	
	@Query("SELECT p FROM Producto p WHERE p.servicio.id = :id AND p.estado = 1")
	List<Producto> findByServicio(@Param("id") long id);
	
	@Query("SELECT p FROM Producto p WHERE p.tipoProducto.id = :id AND p.estado = 1")
	List<Producto> findByTipoProducto(@Param("id") long id);
	
	@Query("SELECT p FROM Producto p WHERE p.stock = 1 AND p.estado = 1")
	List<Producto> findByStockTrue();
	
	@Query("SELECT p FROM Producto p WHERE p.stock = 0 AND p.estado = 1")
	List<Producto> findByStockFalse();
	
	@Query("SELECT p FROM Producto p WHERE p.id = :id AND p.estado = 1")
	Optional<Producto> findProdById(@Param("id") long id);
	
	@Query("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre AND p.estado = 1")
	Optional<Producto> findProdByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT p FROM Producto p WHERE p.servicio.id = :idServ AND p.tipoProducto.id = :idTp AND p.estado = 1")
	List<Producto> findByServicioTipoProducto(@Param("idServ") long idServ, @Param("idTp") long idTp);
	
	@Query("SELECT p FROM Producto p WHERE p.precio = :price AND p.estado = 1")
	List<Producto> findByPrice(@Param("price") float price);
	
	List<Producto> findAllByAcompanantes(Acompanante acomp);
	
	// Los dos queries siguientes hacen lo mismo
	List<Producto> findByAcompanantes_Nombre(String nombre);
	
	@Query("SELECT p FROM Producto p JOIN Acompanante a WHERE a.nombre = :nombre")
	List<Producto> findAllByNombreAcompanante(@Param("nombre") String nombre);
}
