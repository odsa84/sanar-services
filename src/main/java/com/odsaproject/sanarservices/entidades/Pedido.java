/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import java.util.Date;
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

/**
 * @author Osvaldo
 *
 */
@Entity
public class Pedido {

	private Long id;
	private String comentario;
	private Date horaFecha;
	private Persona persona;
	private Repartidor repartidor;
	private Modopago modoPago;
	private Estado estado;
	private Set<Producto> productos;
	private Set<Acompanante> acompanantes;
	
	public Pedido() {

	}

	public Pedido(String comentario, Date horaFecha, Persona persona, Repartidor repartidor, Modopago modoPago,
			Estado estado) {
		this.comentario = comentario;
		this.horaFecha = horaFecha;
		this.persona = persona;
		this.repartidor = repartidor;
		this.modoPago = modoPago;
		this.estado = estado;
	}	

	public Pedido(String comentario, Date horaFecha, Persona persona, Repartidor repartidor, Modopago modoPago,
			Estado estado, Set<Producto> productos) {
		this.comentario = comentario;
		this.horaFecha = horaFecha;
		this.persona = persona;
		this.repartidor = repartidor;
		this.modoPago = modoPago;
		this.estado = estado;
		this.productos = productos;
	}
	
	public Pedido(String comentario, Date horaFecha, Persona persona, Repartidor repartidor, Modopago modoPago,
			Estado estado, Set<Producto> productos, Set<Acompanante> acompanantes) {
		this.comentario = comentario;
		this.horaFecha = horaFecha;
		this.persona = persona;
		this.repartidor = repartidor;
		this.modoPago = modoPago;
		this.estado = estado;
		this.productos = productos;
		this.acompanantes = acompanantes;
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

	@Column(name = "comentario", nullable = true, length = 250)
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Column(name = "hora_fecha", nullable = false)
	public Date getHoraFecha() {
		return horaFecha;
	}

	public void setHoraFecha(Date horaFecha) {
		this.horaFecha = horaFecha;
	}

	@ManyToOne
	@JoinColumn(name = "id_persona")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne
	@JoinColumn(name = "id_repartidor")
	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	@ManyToOne
	@JoinColumn(name = "id_modopago")
	public Modopago getModoPago() {
		return modoPago;
	}

	public void setModoPago(Modopago modoPago) {
		this.modoPago = modoPago;
	}

	@ManyToOne
	@JoinColumn(name = "id_estado")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinTable(name = "pedido_producto", joinColumns = {
	        @JoinColumn(name = "idPedido")}, inverseJoinColumns = {@JoinColumn(name = "idProducto")})
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinTable(name = "pedido_acompanante", joinColumns = {
	        @JoinColumn(name = "idPedido")}, inverseJoinColumns = {@JoinColumn(name = "idAcompanante")})
	public Set<Acompanante> getAcompanantes() {
		return acompanantes;
	}

	public void setAcompanantes(Set<Acompanante> acompanantes) {
		this.acompanantes = acompanantes;
	}

}
