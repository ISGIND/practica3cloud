package com.everis.practicacloudcompra.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.practicacloudcompra.response.CompraResponse;

@FeignClient(name="inventario-service")
@RibbonClient(name = "inventario-service")
public interface CompraServiceProxy {
	
	@GetMapping("/consultarInventario/producto/{id}")
	public CompraResponse retrieveInventario(@PathVariable long id);

}
