package com.pedido_lanches.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido_lanches.Entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
