/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Osvaldo
 *
 */
@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	private String nombre;
	private String descripcion;
	private float precio;
	private int cantidad;
	private String unidadMedida;
	private int stock;
	private String imagen;
	private int estado;
	
	@ManyToOne
	@JoinColumn(name = "id_tipoproducto")
	private Tipoproducto tipoProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_servicio")
	private Servicio servicio;
	
	@ManyToMany(mappedBy="productos")
	@JsonIgnore //Evitar un ciclo infinito con pedidos
	private List<Pedido> pedidos;
	
	@ManyToMany(fetch = FetchType.LAZY)	
	@JoinTable(name = "producto_acompanante", joinColumns = {
	        @JoinColumn(name = "idProducto")}, inverseJoinColumns = {@JoinColumn(name = "idAcompanante")})
	private Set<Acompanante> acompanantes;	
	
	@ManyToMany(mappedBy="productos")
	@JsonIgnore //Evitar un ciclo infinito con pedidos
	private List<Combo> combos;
	
	public Producto() {
		
	}

	public Producto(String nombre, String descripcion, float precio, int cantidad, String unidadMedida,
			int stock, String imagen, int estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.stock = stock;
		this.imagen = imagen;
		this.estado = estado;
	}	
	
	public Producto(String nombre, String descripcion, float precio, int cantidad, String unidadMedida, int stock,
			String imagen, int estado, Tipoproducto tipoProducto, Servicio servicio, List<Pedido> pedidos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.stock = stock;
		this.imagen = imagen;
		this.estado = estado;
		this.tipoProducto = tipoProducto;
		this.servicio = servicio;
		this.pedidos = pedidos;
	}
	
	public Producto(String nombre, String descripcion, float precio, int cantidad, String unidadMedida, int stock,
			String imagen, int estado, Tipoproducto tipoProducto, Servicio servicio, Set<Acompanante> acompanantes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.stock = stock;
		this.imagen = imagen;
		this.estado = estado;
		this.tipoProducto = tipoProducto;
		this.servicio = servicio;
		this.acompanantes = acompanantes;
	}
	
	public Producto(String nombre, String descripcion, float precio, int cantidad, String unidadMedida, int stock,
			String imagen, int estado, Tipoproducto tipoProducto, Servicio servicio, List<Pedido> pedidos, 
			Set<Acompanante> acompanantes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.stock = stock;
		this.imagen = imagen;
		this.estado = estado;
		this.tipoProducto = tipoProducto;
		this.servicio = servicio;
		this.pedidos = pedidos;
		this.acompanantes = acompanantes;
	}
	
	public Producto(String nombre, String descripcion, float precio, int cantidad, String unidadMedida, int stock,
			String imagen, int estado, Tipoproducto tipoProducto, Servicio servicio, List<Pedido> pedidos, 
			Set<Acompanante> acompanantes, List<Combo> combos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.unidadMedida = unidadMedida;
		this.stock = stock;
		this.imagen = imagen;
		this.estado = estado;
		this.tipoProducto = tipoProducto;
		this.servicio = servicio;
		this.pedidos = pedidos;
		this.acompanantes = acompanantes;
		this.combos = combos;
	}
	
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

	@Column(name = "descripcion", nullable = true, length = 100)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "precio", nullable = false)
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Column(name = "cantidad", nullable = true)
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "unidad_medida", nullable = true, length = 10)
	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@Column(name = "stock", nullable = false)
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name = "imagen", nullable = true, length = 150)
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Column(name = "estado")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Tipoproducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Tipoproducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
		
	public Set<Acompanante> getAcompanantes() {
		return acompanantes;
	}

	public void setAcompanantes(Set<Acompanante> acompanantes) {
		this.acompanantes = acompanantes;
	}
	
	public List<Combo> getCombos() {
		return combos;
	}

	public void setCombos(List<Combo> combos) {
		this.combos = combos;
	}	
	
}
