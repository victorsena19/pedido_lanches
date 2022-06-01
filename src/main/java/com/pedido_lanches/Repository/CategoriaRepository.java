package com.pedido_lanches.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido_lanches.Entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
