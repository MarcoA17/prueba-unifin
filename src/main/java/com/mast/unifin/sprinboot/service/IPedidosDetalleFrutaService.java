package com.mast.unifin.sprinboot.service;

import java.util.List;

import com.mast.unifin.sprinboot.model.PedidosDetalleFruta;

public interface IPedidosDetalleFrutaService {

	List<PedidosDetalleFruta> findAll();

	PedidosDetalleFruta findById(Long id);

	PedidosDetalleFruta save(PedidosDetalleFruta pedidosW);

	void deleteById(Long id);

}
