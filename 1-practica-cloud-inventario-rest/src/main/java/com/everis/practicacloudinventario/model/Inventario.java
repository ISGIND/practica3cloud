package com.everis.practicacloudinventario.model;

import static javax.persistence.GenerationType.IDENTITY;

// default package
// Generated 25/09/2019 01:16:21 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Inventario generated by hbm2java
 */
@Entity
@Table(name = "inventario", catalog = "practica3")
public class Inventario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private Integer stock;

	//private Set<Compra> compras = new HashSet<Compra>(0);

	public Inventario() {
	}

	public Inventario(Integer id) {
		this.id = id;
	}

//	public Inventario(int id, String nombre, Integer stock, Set<Compra> compras) {
//		this.id = id;
//		this.nombre = nombre;
//		this.stock = stock;
//		this.compras = compras;
//	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "stock")
	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
