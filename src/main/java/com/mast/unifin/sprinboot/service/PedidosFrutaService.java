package com.mast.unifin.sprinboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mast.unifin.sprinboot.model.PedidosFruta;
import com.mast.unifin.sprinboot.repository.IPedidosFrutaRepository;

@Service
public class PedidosFrutaService implements IPedidosFrutaService {

	@Autowired
	private IPedidosFrutaRepository pedidosRepository;

	@Override
	public List<PedidosFruta> findAll() {

		return (List<PedidosFruta>) pedidosRepository.findAll();
	}

	@Override
	public PedidosFruta findById(Long id) {
		return pedidosRepository.findById(id).orElse(null);
	}

	@Override
	public PedidosFruta save(PedidosFruta pedidosw) {
		return pedidosRepository.save(pedidosw);
	}
	
	@Override
	public void deleteById(Long id) {
		pedidosRepository.deleteById(id);
	}

}
