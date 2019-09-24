package com.everis.practicacloudinventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventario {

	@Id
	private long id;
	
	@Column
	private String nombre;
	
	@Column
	private int stock;
}
