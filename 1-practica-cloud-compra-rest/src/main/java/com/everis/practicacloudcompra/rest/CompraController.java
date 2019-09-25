package com.everis.practicacloudcompra.rest;



import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudcompra.model.Compra;
import com.everis.practicacloudcompra.proxy.CompraServiceProxy;
import com.everis.practicacloudcompra.repository.CompraRepository;
import com.everis.practicacloudcompra.response.CompraResponse;
import com.everis.practicacloudcompra.response.InventarioResponse;
import com.everis.practicacloudcompra.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Value("${config.reorden}")
	private double reorden;
	
	@Autowired //inyecta dependencia de service proxy
	private CompraServiceProxy compraServiceProxy;
	
	@Autowired
	private CompraService compraservice;

	@GetMapping ("/consultarInventario/producto/{id}/cantidad/{cantidad}")
	public CompraResponse consultarInventario(@PathVariable long id, 
			@PathVariable int cantidad) {
			
		CompraResponse response = new CompraResponse();
		
		Compra compra = new Compra();
		try {
			response = compraServiceProxy.retrieveInventario(id);
						
			double stock= response.getValue().getStock();
			double stockminimo = reorden/100*stock;
			
		 if ((stock - stockminimo) >= cantidad) {
				response.setSuccessful(true);
				response.setMessage("Se puede comparar");
				compra.setFechahora(new Date());
				compra.setInventario(response.getValue());
			    compra.setCantidad(cantidad);
				compraservice.insertar(compra);
				
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
