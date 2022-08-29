package com.pedido_lanches.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Query("FROM Pedido p WHERE p.id = :id")
	Optional<Pedido> getId(@Param("id")Long id);
	
	@Query("FROM Pedido p WHERE p.numPedido = :numPedido")
	Optional<Pedido> getNumPedido(@Param("numPedido")Integer numPedido);
	
	List<Pedido> findByMesaId(Long mesa);
}
