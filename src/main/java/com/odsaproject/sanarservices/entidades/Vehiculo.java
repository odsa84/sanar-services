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
public class Vehiculo {

	private Long id;
	private String placa;
	private int estado;
	private Tipovehiculo tipoVehiculo;
	
	public Vehiculo() {

	}

	public Vehiculo(String placa, int estado, Tipovehiculo tipoVehiculo) {
		this.placa = placa;
		this.estado = estado;
		this.tipoVehiculo = tipoVehiculo;
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

	@Column(name = "placa", nullable = true, length = 10)
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@ManyToOne
	@JoinColumn(name = "id_tipovehiculo")
	public Tipovehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Tipovehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
}
