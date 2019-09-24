package com.everis.practicacloudinventario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudinventario.model.Inventario;
import com.everis.practicacloudinventario.reponses.InventarioResponse;
import com.everis.practicacloudinventario.service.InventarioService;

@RestController
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/consultarInventario/producto/{nombre}")
	public InventarioResponse consultarInventario(@PathVariable String nombre) {
		InventarioResponse response = new InventarioResponse();
		
		try {
			Inventario valor = inventarioService.findByNombre(nombre);
			if(valor == null) {
				response.setSuccessful(false);
				response.setMessage("Intente más tarde");
				return response;
			}
			
			response.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			response.setMessage("Inventario recuperado");
			response.setSuccessful(true);
			response.setValue(valor);			
		} catch (Exception e) {
			// TODO: handle exception
			response.setSuccessful(false);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	
}
