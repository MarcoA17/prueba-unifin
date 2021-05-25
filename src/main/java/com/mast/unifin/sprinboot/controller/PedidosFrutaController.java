package com.mast.unifin.sprinboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mast.unifin.sprinboot.model.PedidosFruta;
import com.mast.unifin.sprinboot.service.PedidosFrutaService;

@RestController
@RequestMapping("/api/pedidosfruta")
public class PedidosFrutaController {

	@Autowired
	private PedidosFrutaService pedidosFrutaService;
	
	

	public PedidosFrutaController(PedidosFrutaService pedidosFrutaService) {
		super();
		this.pedidosFrutaService = pedidosFrutaService;
	}

	@GetMapping
	public ResponseEntity<?> listarPediosFruta() {
		return ResponseEntity.ok().body(pedidosFrutaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(Long id) {
		PedidosFruta pedidosFruta = pedidosFrutaService.findById(id);
		if (pedidosFruta == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(pedidosFruta);
	}
	
	@PostMapping
	public ResponseEntity<?> crearPedido(@RequestBody PedidosFruta pedidosFruta){
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidosFrutaService.save(pedidosFruta));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> actualizar(@RequestBody PedidosFruta pedidosFruta, @PathVariable Long id) {
		PedidosFruta pedidoActual = this.pedidosFrutaService.findById(id);
		if (pedidoActual == null) {
			return ResponseEntity.noContent().build();
		}
		pedidoActual.setNombre(pedidoActual.getNombre());
		pedidoActual.setTotal(pedidosFruta.getTotal());
		pedidoActual.setFechaModificacion(pedidosFruta.getFechaModificacion());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidosFrutaService.save(pedidoActual));
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pedidosFrutaService.deleteById(id);
		return ResponseEntity.ok().body("Pedido con id " + id + " fue eliminado");
	}


}
