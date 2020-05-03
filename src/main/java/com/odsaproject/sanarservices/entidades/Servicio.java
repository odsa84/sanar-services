/**
 * 
 */
package com.odsaproject.sanarservices.entidades;

import java.time.LocalDateTime;
import java.util.Date;

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
public class Servicio {

	private Long id;
	private String nombre;
	private String descripcion;
	private String sitioWeb;
	private String callePrincipal;
	private String numeracion;
	private String calleSecundaria;
	private String detalleAdicional;
	private Date fechaCreadoNegocio;
	private LocalDateTime fechaRegistro;
	private LocalDateTime fechaModificacion;
	private Persona persona;
	private Categoria categoria;
	private Sector sector;
	private String imagen;
	private int estado;

	public Servicio() {

	}

	public Servicio(String nombre, String descripcion, String sitioWeb, String callePrincipal, String numeracion, String calleSecundaria,
			String detalleAdicional, Date fechaCreadoNegocio, LocalDateTime fechaRegistro, LocalDateTime fechaModificacion, String imagen, int estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
		this.callePrincipal = callePrincipal;
		this.numeracion = numeracion;
		this.calleSecundaria = calleSecundaria;
		this.detalleAdicional = detalleAdicional;
		this.fechaCreadoNegocio = fechaCreadoNegocio;
		this.fechaRegistro = fechaRegistro;
		this.fechaModificacion = fechaModificacion;
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

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	@Column(name = "calle_principal", nullable = false, length = 50)
	public String getCallePrincipal() {
		return callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	@Column(name = "numeracion", nullable = false, length = 10)
	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	@Column(name = "calle_secundaria", nullable = false, length = 50)
	public String getCalleSecundaria() {
		return calleSecundaria;
	}

	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}

	@Column(name = "detalle_adicional", nullable = true, length = 100)
	public String getDetalleAdicional() {
		return detalleAdicional;
	}

	public void setDetalleAdicional(String detalleAdicional) {
		this.detalleAdicional = detalleAdicional;
	}

	@Column(name = "fecha_creado_negocio", nullable = true)
	public Date getFechaCreadoNegocio() {
		return fechaCreadoNegocio;
	}

	public void setFechaCreadoNegocio(Date fechaCreadoNegocio) {
		this.fechaCreadoNegocio = fechaCreadoNegocio;
	}

	@Column(name = "fecha_registro", nullable = true)
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	@JoinColumn(name = "id_categoria")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne
	@JoinColumn(name = "id_sector")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Column(name = "imagen")
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

	@Column(name = "fecha_modificacion")
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}