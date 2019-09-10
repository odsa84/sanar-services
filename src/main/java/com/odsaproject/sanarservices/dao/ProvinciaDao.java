/**
 * 
 */
package com.odsaproject.sanarservices.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odsaproject.sanarservices.entidades.Provincia;

/**
 * @author Osvaldo
 *
 */
public interface ProvinciaDao extends JpaRepository<Provincia, Long> {

	public Optional<Provincia> findByNombre(String nombre);
}
