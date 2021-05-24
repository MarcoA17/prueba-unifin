package com.mast.unifin.sprinboot.service;

import java.util.List;

import com.mast.unifin.sprinboot.model.PedidosFruta;

public interface IPedidosFrutaService {
	
	List<PedidosFruta> findAll();

	PedidosFruta findById(Long id);

	PedidosFruta save(PedidosFruta pedidosFruta);

	void deleteById(Long id);

}
