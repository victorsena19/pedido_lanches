package com.pedido_lanches.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{
	@Query("FROM Mesa m WHERE m.id = :id")
	List<Mesa> getId(@Param("id") Long id);
	
	@Query("FROM Mesa m WHERE m.numero = :numero")
	List<Mesa> getNumero(@Param("numero") Integer numero);
}
