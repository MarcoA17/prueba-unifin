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

import com.mast.unifin.sprinboot.model.PedidosDetalleFruta;
import com.mast.unifin.sprinboot.service.PedidosDetalleFrutaService;

@RestController
@RequestMapping("/api/detallefruta")
public class PedidosDetalleFrutaController {

	@Autowired
	private PedidosDetalleFrutaService pedidosDetalleFrutaService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(pedidosDetalleFrutaService.findAll());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody PedidosDetalleFruta pedidosDetalleFruta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidosDetalleFrutaService.save(pedidosDetalleFruta));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody PedidosDetalleFruta pedidosDetalleFruta, @PathVariable Long id) {
		PedidosDetalleFruta detalleActual = this.pedidosDetalleFrutaService.findById(id);
		if (detalleActual == null) {
			return ResponseEntity.noContent().build();
		}
		detalleActual.setClave(pedidosDetalleFruta.getClave());
		detalleActual.setCantidad(pedidosDetalleFruta.getCantidad());
		detalleActual.setPrecio(pedidosDetalleFruta.getPrecio());
		detalleActual.setPedidosFruta(pedidosDetalleFruta.getPedidosFruta());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidosDetalleFrutaService.save(detalleActual));
	}
	
	@DeleteMapping(value="/deleteDetalles/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pedidosDetalleFrutaService.deleteById(id);
		return ResponseEntity.ok().body("El detatlle con id " + id + " fue eliminado");
	}

}
