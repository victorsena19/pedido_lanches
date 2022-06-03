package com.pedido_lanches.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	@Query("FROM Pedido p WHERE p.id = :id")
	List<Pedido> getId(@Param("id")Long id);
	
	@Query("FROM Pedido p WHERE p.numPedido = :numPedido")
	List<Pedido> getNumPedido(@Param("numPedido")Integer numero);
	
}
