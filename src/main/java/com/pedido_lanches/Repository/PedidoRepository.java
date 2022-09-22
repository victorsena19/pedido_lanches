package com.pedido_lanches.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Entity.PedidoProduto;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Query("FROM Pedido p WHERE p.id = :id")
	Optional<Pedido> getId(@Param("id")Long id);

	@Query("FROM Pedido p WHERE p.numPedido = :numPedido")
	Optional<Pedido> getNumPedido(@Param("numPedido")Integer numPedido);
	
	@Query("FROM Pedido p WHERE p.mesa.id = :mesaId")
	Optional<Pedido> findAllByMesa(@Param("mesaId")Long mesa);
	
	@Query(value = "SELECT pe.id, pe.num_pedido, pe.momento_pedido, pe.numero_mesa, pe.status_pedido_id, pe.pagamento_id,"
			+"(SELECT SUM(quantidade_produto * valor_unitario)"
			+"FROM pedido_produto pp WHERE pp.pedido_id = pe.id) as total_pedido,"
			+"(SELECT SUM(quantidade_produto) FROM pedido_produto pp WHERE pp.pedido_id = pe.id)"
			+"as quantidade FROM pedido pe where pe.id = :pedido", nativeQuery = true)
	Optional<Pedido> findAllByPedido(@Param("pedido")Long pedido);
}
