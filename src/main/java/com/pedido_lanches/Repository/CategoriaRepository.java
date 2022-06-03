package com.pedido_lanches.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pedido_lanches.Entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	@Query("FROM Categoria c WHERE c.id = :id")
	List<Categoria> getId(@Param("id") Long id);
	
	@Query("FROM Categoria c WHERE c.nome = :nome")
	List<Categoria> getNome(@Param("nome") String nome);
}
