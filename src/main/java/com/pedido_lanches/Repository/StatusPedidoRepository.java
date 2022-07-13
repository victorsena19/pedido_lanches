package com.pedido_lanches.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.StatusPedido;

@Repository
public interface StatusPedidoRepository extends JpaRepository<StatusPedido, Long>{
	
	@Query("FROM StatusPedido st WHERE st.id = :id")
	Optional<StatusPedido> getId(@Param("id")Long id);
	
	@Query("FROM StatusPedido st WHERE LOWER(st.descricao) like %:descricao%")
	List<StatusPedido> getDescricao(@Param("descricao")String descricao);
}
