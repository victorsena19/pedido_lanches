package com.pedido_lanches.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pedido_lanches.Entity.StatusPedido;

public interface StatusPedidoRepository extends JpaRepository<StatusPedido, Long>{
	@Query("FROM StatusPedido st WHERE st.id = :id")
	List<StatusPedido> getId(@Param("id")Long id);
	
	@Query("FROM StatusPedido st WHERE st.descricao = :descricao")
	List<StatusPedido> getDescricao(@Param("descricao")String descricao);
}
