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
public class Tipoacompanante {

	private Long id;
	private String nombre;
	private String descripcion;
	private int estado;
	private Marca marca;
	private Servicio servicio;

	public Tipoacompanante() {

	}

	public Tipoacompanante(String nombre, String descripcion, int estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public Tipoacompanante(String nombre, String descripcion, int estado, Marca marca, Servicio servicio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.marca = marca;
		this.servicio = servicio;
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

	@Column(name = "descripcio", nullable = false, length = 100)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estado")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@ManyToOne
	@JoinColumn(name = "id_marca")
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@ManyToOne
	@JoinColumn(name = "id_servicio")
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}		
}
