package com.everis.practicacloudcompra.response;

import com.everis.practicacloudcompra.model.Inventario2;

public class InventarioResponse {

	private boolean successful;
	private String message;
	private Inventario2 value;
	private int port;
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Inventario2 getValue() {
		return value;
	}
	public void setValue(Inventario2 value) {
		this.value = value;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
