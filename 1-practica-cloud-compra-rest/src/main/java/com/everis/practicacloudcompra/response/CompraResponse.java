package com.everis.practicacloudcompra.response;

import java.math.BigDecimal;

import com.everis.practicacloudcompra.model.Inventario;

public class CompraResponse {
	
	private boolean successful;
	private String message;
	private Inventario value;


	
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
	public Inventario getValue() {
		return value;
	}
	public void setValue(Inventario value) {
		this.value = value;
	}
	


}
