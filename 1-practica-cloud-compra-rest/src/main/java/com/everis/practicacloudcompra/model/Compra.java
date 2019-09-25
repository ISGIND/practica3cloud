package com.everis.practicacloudcompra.model;
// default package
// Generated 25/09/2019 01:16:21 PM by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Compra generated by hbm2java
 */
@Entity
@Table(name = "compra", catalog = "practica3")
public class Compra implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Inventario inventario;
	private Date fechahora;
	private Integer cantidad;

	public Compra() {
	}

	public Compra(int id, Inventario inventario) {
		this.id = id;
		this.inventario = inventario;
	}

	public Compra(int id, Inventario inventario, Date fechahora, Integer cantidad) {
		this.id = id;
		this.inventario = inventario;
		this.fechahora = fechahora;
		this.cantidad = cantidad;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventario_id", nullable = false)
	public Inventario getInventario() {
		return this.inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechahora",length = 19)
	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	@Column(name = "cantidad")
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
