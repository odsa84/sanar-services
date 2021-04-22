/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odsaproject.sanarservices.entidades.Repartidor;

/**
 * @author Osvaldo
 *
 */
public interface RepartidorDao extends JpaRepository<Repartidor, Long> {
	
	@Query("SELECT r FROM Repartidor r WHERE r.vehiculo.id = :id AND r.estado = 1")
	List<Repartidor> findByVehiculo(@Param("id") long id);
	
	@Query("SELECT r FROM Repartidor r WHERE r.cedula = :cedula AND r.estado = 1")
	Optional<Repartidor> findByCedula(@Param("cedula") String cedula);
	
	@Query("SELECT r FROM Repartidor r WHERE r.email = :mail AND r.estado = 1")
	Optional<Repartidor> findByMail(@Param("mail") String mail);
	
	@Query("SELECT r FROM Repartidor r WHERE r.telefono = :telefono AND r.estado = 1")
	Optional<Repartidor> findByTelefono(@Param("telef") String telef);
	
	@Query("SELECT r FROM Repartidor r WHERE r.nombres = :nombres AND r.estado = 1")
	List<Repartidor> findByNombre(@Param("nombres") String nombres);
	
	@Query("SELECT r FROM Repartidor r WHERE r.apellidos = :apellidos AND r.estado = 1")
	List<Repartidor> findByApellido(@Param("apellidos") String apellidos);
	
	@Query("SELECT r FROM Repartidor r WHERE r.nombres = :nombres AND r.apellidos = :apellidos AND r.estado = 1")
	List<Repartidor> findByNombreYApellido(@Param("nombres") String nombres, @Param("apellidos") String apellidos);
	
	@Query("SELECT r FROM Repartidor r WHERE r.id = :id AND r.estado = 1")
	Optional<Repartidor> findById(@Param("id") long id);
	
	@Query("SELECT r FROM Repartidor r WHERE r.estado = 1")
	List<Repartidor> findAllByEstadoTrue();
	
	@Query("SELECT r FROM Repartidor r WHERE r.enLinea = 1")
	List<Repartidor> findOnLine();
	
	@Query("SELECT r FROM Repartidor r WHERE r.enLinea = 0")
	List<Repartidor> findOffLine();
	
	@Query("SELECT r FROM Repartidor r WHERE r.password = :pass AND r.email = :mail AND r.estado = 1")
	Optional<Repartidor> login(@Param("pass") String pass, @Param("mail") String mail);

}
