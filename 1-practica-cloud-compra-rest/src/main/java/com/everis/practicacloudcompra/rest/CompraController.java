package com.everis.practicacloudcompra.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicacloudcompra.response.CompraResponse;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Value("${config.reorden}")
	private double reorden;
	
	
	
	
	
	@GetMapping ("/consultarInventario/producto/{id}/cantidad/{cantidad}")
	public CompraResponse consultarInventario(@PathVariable long id, 
			@PathVariable int cantidad) {
		
		
		
		
		String url = "http://localhost:8000/consultarInventario/producto/{id}";
		
		Map<String,Long> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		
		CompraResponse response = new CompraResponse();
		
		try {
			
			
			ResponseEntity<CompraResponse>  respuesta =   new RestTemplate().getForEntity(url,
					CompraResponse.class, uriVariables);
			
			double stock= respuesta.getBody().getValue().getStock();
			double stockminimo = reorden/100*stock;
			
		 if ((stock - stockminimo) >= cantidad) {
		
			    response = respuesta.getBody();
				response.setSuccessful(true);
				response.setMessage("Se puede comparar");	
				
				
		 }else {
			 response.setSuccessful(false);
			 response.setMessage("No se puede comprar");
		 }
			
			
		}catch (Exception e) {
			response.setSuccessful(false);
			response.setMessage(e.getMessage());
		}
		
		return response;
		
	}

}
