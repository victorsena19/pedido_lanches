package com.pedido_lanches.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.PedidoProduto;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long>{
	
	@Query(value = "select pp.id, pp.pedido_id, pp.produto_id, pp.quantidade_produto,"
			+ " (select pr.preco from produto pr where pr.id = pp.produto_id) as valor_unitario"
			+ " from pedido_produto pp", nativeQuery = true)
	List<PedidoProduto> getAll();
	
	@Query("FROM PedidoProduto pp WHERE pp.pedido.id = :pedido")
	List<PedidoProduto> findAllByPedido(@Param("pedido")Long pedido);

	@Query("FROM PedidoProduto pp WHERE pp.produto.id = :produto")
	Optional<PedidoProduto> findAllByProduto(@Param("produto")Long produto);
	
	
	@Query(value = "insert into PedidoProduto (valorUnitario) (select pr.preco from Produto pr where pr.id = :produto)", nativeQuery = true)
	Optional<PedidoProduto> getPrecoProduto(@Param("produto")Long produto);
}
