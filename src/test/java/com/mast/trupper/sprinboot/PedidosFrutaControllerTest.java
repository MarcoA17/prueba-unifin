package com.mast.trupper.sprinboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.mast.unifin.sprinboot.controller.PedidosFrutaController;
import com.mast.unifin.sprinboot.model.PedidosFruta;
import com.mast.unifin.sprinboot.service.PedidosFrutaService;

@SpringBootTest
public class PedidosFrutaControllerTest {
	@Autowired
	private PedidosFrutaService pedidosFrutaService = Mockito.mock(PedidosFrutaService.class);
	
	@Autowired
	private PedidosFrutaController frutasController = new PedidosFrutaController(pedidosFrutaService);
	
	@BeforeEach
	void sepUp() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse("2021-05-24");
		PedidosFruta fruta = new PedidosFruta();
		fruta.setId((long) 1);
		fruta.setNombre("Manzana");
		fruta.setFechaModificacion(date);
		fruta.setTotal(20);
		fruta.isEstatus();;
		System.out.println(fruta);
		
		Mockito.when(pedidosFrutaService.findById((long)1)).thenReturn(fruta);
		
	}
	
	@Test
	void listarPediosFruta() {
		ResponseEntity<PedidosFruta> respuestaServicio;
		respuestaServicio = (ResponseEntity<PedidosFruta>) frutasController.buscarPorId((long)1);
		Assertions.assertThat((long)1);
		
	}
	
	@AfterEach
	void tearDown() {
		
	}

}
