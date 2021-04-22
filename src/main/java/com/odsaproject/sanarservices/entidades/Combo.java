/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Osvaldo
 *
 */
@Entity
public class Combo {

	private Long id;
	private String nombre;
	private String descripcion;
	private float precio;
	private int estado;
	private Collection<Producto> productos;

	public Combo() {

	}

	public Combo(String nombre, String descripcion, float precio, int estado, Collection<Producto> productos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
		this.productos = productos;
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

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "precio")
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Column(name = "estado")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinTable(name = "combo_producto", joinColumns = {
	        @JoinColumn(name = "idCombo")}, inverseJoinColumns = {@JoinColumn(name = "idProducto")})
	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	
}
