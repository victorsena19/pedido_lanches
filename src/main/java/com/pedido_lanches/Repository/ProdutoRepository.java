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
	
	
	
}
