package com.pedido_lanches.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido_lanches.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
