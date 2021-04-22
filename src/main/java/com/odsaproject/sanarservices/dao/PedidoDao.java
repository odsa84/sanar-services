/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Pedido;
import com.odsaproject.sanarservices.entidades.Producto;

/**
 * @author Osvaldo
 *
 */
public interface PedidoDao extends JpaRepository<Pedido, Long> {
	
	@Query("SELECT p FROM Pedido p WHERE p.estado = 1")
	List<Pedido> findAll();
	
	@Query("SELECT p FROM Pedido p WHERE p.persona.id = :id")
	List<Pedido> findByPersona(@Param("id") long id);
	
	@Query("SELECT p FROM Pedido p WHERE p.repartidor.id = :id")
	List<Pedido> findByRepartidor(@Param("id") long id);
	
	@Query("SELECT p FROM Pedido p WHERE p.estado.id = :id")
	List<Pedido> findByEstado(@Param("id") long id);
	
	@Query("SELECT p FROM Pedido p WHERE p.modoPago.id = :id")
	List<Pedido> findByModoPago(@Param("id") long id);
	
	@Query("SELECT p FROM Pedido p WHERE p.id = :id")
	Optional<Pedido> findById(@Param("id") long id);
	
	@Query("SELECT p FROM Pedido p WHERE p.horaFecha = :fecha")
	List<Pedido> findByDate(@Param("fecha") Date fecha);
	
	List<Pedido> findAllByProductos(Producto prod);
	
	// Los dos queries siguientes hacen lo mismo
	List<Pedido> findByProductos_Nombre(String nombre);
	
	@Query("SELECT p FROM Pedido p JOIN Producto pr WHERE pr.nombre = :nombre")
	List<Pedido> findAllByNombreProducto(@Param("nombre") String nombre);
}
