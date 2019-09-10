/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @author Osvaldo
 *
 */
@Entity
public class Ciudad {

	private Long id;
	private String nombre;
	private Provincia provincia;
	
	public Ciudad() {
	}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
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

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne
	@JoinColumn(name = "id_provincia")
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}
