package com.mast.unifin.sprinboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mast.unifin.sprinboot.model.PedidosFruta;

@Repository
public interface PedidosFrutaRepository extends JpaRepository<PedidosFruta, Integer>{

}
