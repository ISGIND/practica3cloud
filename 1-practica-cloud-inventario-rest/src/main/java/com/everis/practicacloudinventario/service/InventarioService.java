package com.everis.practicacloudinventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudinventario.model.Inventario;
import com.everis.practicacloudinventario.repository.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository inventarioRepository;
	
	public Inventario findByNombre(String nombre) {
		return inventarioRepository.findByNombre(nombre);
	}
}
