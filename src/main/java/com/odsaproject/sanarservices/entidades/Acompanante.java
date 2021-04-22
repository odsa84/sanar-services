/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Osvaldo
 *
 */
@Entity
public class Acompanante {

	private Long id;
	private String nombre;
	private String descripcion;
	private int estado;
	//private Tipoacompanante tipoAcompanante;	
	private List<Producto> productos;	
	private List<Pedido> pedidos;

	public Acompanante() {

	}

	public Acompanante(String nombre, String descripcion, int estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	/* Acompanante(String nombre, String descripcion, int estado, Tipoacompanante tipoAcompanante) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoAcompanante = tipoAcompanante;
	}*/
	
	public Acompanante(String nombre, String descripcion, int estado, List<Producto> productos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.productos = productos;
	}
	
	public Acompanante(String nombre, String descripcion, int estado, List<Producto> productos, List<Pedido> pedidos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.productos = productos;
		this.pedidos = pedidos;
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

	@Column(name = "descripcion", nullable = false, length = 100)
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

	/*@ManyToOne
	@JoinColumn(name = "id_tipoacompanante")
	public Tipoacompanante getTipoAcompanante() {
		return tipoAcompanante;
	}

	public void setTipoAcompanante(Tipoacompanante tipoAcompanante) {
		this.tipoAcompanante = tipoAcompanante;
	}*/
	
	@ManyToMany(mappedBy="acompanantes")
	@JsonIgnore //Evitar un ciclo infinito con productos
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@ManyToMany(mappedBy="acompanantes")
	@JsonIgnore //Evitar un ciclo infinito con productos
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
		
}
