package com.pedido_lanches.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pedido_lanches.Entity.PedidoProduto;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long>{
	
	@Query("FROM PedidoProduto p WHERE p.produto.id = :produtoId")
	Optional<PedidoProduto> findAllByProduto(@Param("produtoId")Long produto);
}
