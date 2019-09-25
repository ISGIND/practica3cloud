package com.everis.practicacloudcompra.response;



public class CompraResponse {
	
	private boolean successful;
	private String message;
	private InventarioResponse value;
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
	public InventarioResponse getValue() {
		return value;
	}
	public void setValue(InventarioResponse value) {
		this.value = value;
	}
	
	
	

}
