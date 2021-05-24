package com.mast.unifin.sprinboot.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mast.unifin.sprinboot.helper.CSVHelper;
import com.mast.unifin.sprinboot.model.PedidosFruta;
import com.mast.unifin.sprinboot.repository.PedidosFrutaRepository;

@Service
public class CSVService implements ICSVServices {
  @Autowired
  PedidosFrutaRepository repository;

  public void save(MultipartFile file) {
	    try {
	      List<PedidosFruta> frutas = CSVHelper.csvToFrutas(file.getInputStream());
	      repository.saveAll(frutas);
	    } catch (IOException | ParseException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
}

