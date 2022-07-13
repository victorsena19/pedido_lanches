package com.pedido_lanches.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("FROM Categoria c WHERE c.id = :id")
	Optional<Categoria> getId(@Param("id") Long id);
	
	@Query("FROM Categoria c WHERE LOWER(c.nome) LIKE %:nome%")
	List<Categoria> getNome(@Param("nome") String nome);
}
