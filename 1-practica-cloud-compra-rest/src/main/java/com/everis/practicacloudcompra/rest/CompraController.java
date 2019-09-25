package com.everis.practicacloudcompra.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudcompra.proxy.CompraServiceProxy;
import com.everis.practicacloudcompra.response.CompraResponse;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Value("${config.reorden}")
	private double reorden;
	
	@Autowired //inyecta dependencia de service proxy
	private CompraServiceProxy compraServiceProxy;

	@GetMapping ("/consultarInventario/producto/{id}/cantidad/{cantidad}")
	public CompraResponse consultarInventario(@PathVariable long id, 
			@PathVariable int cantidad) {
			
		CompraResponse response = new CompraResponse();
		
		try {
			response = compraServiceProxy.retrieveInventario(id);
						
			double stock= response.getValue().getStock();
			double stockminimo = reorden/100*stock;
			
		 if ((stock - stockminimo) >= cantidad) {
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
