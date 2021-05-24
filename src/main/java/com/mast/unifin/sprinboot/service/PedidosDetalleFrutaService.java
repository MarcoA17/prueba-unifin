package com.mast.unifin.sprinboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mast.unifin.sprinboot.model.PedidosDetalleFruta;
import com.mast.unifin.sprinboot.repository.IPedidosDetalleFrutaRepository;

@Service
public class PedidosDetalleFrutaService implements IPedidosDetalleFrutaService {

	@Autowired
	private IPedidosDetalleFrutaRepository pedidosDetalleRepo;

	@Override
	public List<PedidosDetalleFruta> findAll() {
		// TODO Auto-generated method stub
		return (List<PedidosDetalleFruta>) pedidosDetalleRepo.findAll();
	}
	
	@Override
	public PedidosDetalleFruta findById(Long id) {
		return pedidosDetalleRepo.findById(id).orElse(null);
	}

	@Override
	public PedidosDetalleFruta save(PedidosDetalleFruta pedidosDetalleFruta) {
		// TODO Auto-generated method stub
		return pedidosDetalleRepo.save(pedidosDetalleFruta);
	}
	
	@Override
	public void deleteById(Long id) {
		pedidosDetalleRepo.deleteById(id);
	}

}
