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
public class Repartidor {

	private Long id;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String cedula;
	private String email;
	private String password;
	private int enLinea;
	private int estado;
	private Vehiculo vehiculo;
	
	public Repartidor() {
		
	}

	public Repartidor(String nombres, String apellidos, String telefono, String cedula, String email, String password,
			int enLinea, int estado, Vehiculo vehiculo) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.cedula = cedula;
		this.email = email;
		this.password = password;
		this.enLinea = enLinea;
		this.estado = estado;
		this.vehiculo = vehiculo;
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

	@Column(name = "nombres", nullable = false, length = 50)
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "apellidos", nullable = false, length = 100)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "telefono", nullable = false, length = 15)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "cedula", nullable = true, length = 11)
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = true, length = 1024)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "en_linea", nullable = false)
	public int getEnLinea() {
		return enLinea;
	}

	public void setEnLinea(int enLinea) {
		this.enLinea = enLinea;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
