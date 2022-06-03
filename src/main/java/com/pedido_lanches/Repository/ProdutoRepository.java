package com.pedido_lanches.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pedido_lanches.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	@Query("FROM Produto p WHERE p.id = :id")
	List<Produto> getId(@Param("id") Long id);
	
	@Query("FROM Produto p WHERE p.nome = :nome")
	List<Produto> getNome(@Param("nome") String nome);
	
	@Query("FROM Produto p WHERE p.descricao= :descricao")
	List<Produto> getDescricao(@Param("descricao") String descricao);
	
	@Query("FROM Produto p WHERE p.preco = :preco")
	List<Produto> getPreco(@Param("preco") Double preco);
	
	@Query("FROM Produto p WHERE p.foto = :foto")
	List<Produto> getFoto(@Param("foto") String foto);
}
