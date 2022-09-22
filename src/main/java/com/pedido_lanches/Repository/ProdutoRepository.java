package com.pedido_lanches.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("FROM Produto p WHERE p.id = :id")
	Optional<Produto> getId(@Param("id") Long id);
	
	@Query("FROM Produto p WHERE LOWER(p.nome) like %:nome%")
	Optional<Produto> getNome(@Param("nome") String nome);
	
	@Query(value = "select pr.id, pr.nome, pr.descricao, pr.categoria_id, pr.foto,"
			+ " (select pp.pedido_id from pedido_produto pp where pp.produto_id = pr.id) as pedido,"
			+ " (select pp.quantidade_produto from pedido_produto pp where pp.produto_id = pr.id) as quantidade,"
			+ " (select pp.valor_unitario from pedido_produto pp where pp.produto_id = pr.id) as preco"
			+ " from produto pr where pr.id = :produto", nativeQuery = true)
	Optional<Produto> findAllByProduto(@Param("produto")Long produto);
	
}
