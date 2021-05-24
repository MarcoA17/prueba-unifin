package com.mast.unifin.sprinboot.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedidos_fruta_detalle")
public class PedidosDetalleFruta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clave;
	
	private BigDecimal cantidad;

	private BigDecimal precio;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	private PedidosFruta pedidosFruta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public PedidosFruta getPedidosFruta() {
		return pedidosFruta;
	}

	public void setPedidosFruta(PedidosFruta pedidosFruta) {
		this.pedidosFruta = pedidosFruta;
	}

	@Override
	public String toString() {
		return "PedidosDetalleFruta [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", pedidosFruta=" + pedidosFruta + "]";
	}

}
