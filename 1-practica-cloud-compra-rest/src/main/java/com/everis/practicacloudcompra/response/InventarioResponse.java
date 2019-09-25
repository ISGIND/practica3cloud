package com.everis.practicacloudcompra.response;

import com.everis.practicacloudcompra.model.Inventario;

public class InventarioResponse {

	private Inventario value;
	private int port;
	public Inventario getValue() {
		return value;
	}
	public void setValue(Inventario value) {
		this.value = value;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
