/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Osvaldo
 *
 */
@Entity
public class Estado {

	private Long id;
	private String nombre;
	private String descripcion;
	private int estadoField;

	public Estado() {

	}

	public Estado(String nombre, String descripcion, int estadoField) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estadoField = estadoField;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcio", nullable = false, length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estado")
	public int getEstadoField() {
		return estadoField;
	}

	public void setEstadoField(int estadoField) {
		this.estadoField = estadoField;
	}
		
}
