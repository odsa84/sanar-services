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
public class Categoria {

	private Long id;
	private String tipoNegocio;
	private String descripcion;
	private String imagen;
	private String estado;
	
	public Categoria() {
		
	}

	public Categoria(String tipoNegocio, String descripcion, String imagen, String estado) {
		this.tipoNegocio = tipoNegocio;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.estado = estado;
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

	@Column(name = "tipo_negocio", nullable = false, length = 50)
	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	@Column(name = "descripcion", nullable = true, length = 100)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
