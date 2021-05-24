package com.mast.unifin.sprinboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "pedidos_fruta")
public class PedidosFruta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private double total;

	@Column(name = "fecha_modificacion")
	@Temporal(TemporalType.DATE)
	private Date fechaModificacion;

	private boolean estatus;

	
	
	public PedidosFruta() {
		super();
	}

	public PedidosFruta(Long id, String nombre, double total,
			boolean estatus ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.total = total;
		this.estatus = estatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "PedidosFruta [id=" + id + ", nombre=" + nombre + ", total=" + total + ", estatus=" + estatus + "]";
	}

}
