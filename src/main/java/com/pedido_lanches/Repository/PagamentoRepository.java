package com.pedido_lanches.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido_lanches.Entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
