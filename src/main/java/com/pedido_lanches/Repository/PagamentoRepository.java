package com.pedido_lanches.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedido_lanches.Entity.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	@Query("FROM Pagamento p WHERE p.id = :id")
	List<Pagamento> getId(@Param("id") Long id);
	
	@Query("FROM Pagamento p WHERE p.momento = :momento")
	List<Pagamento> getMomento(@Param("momento") Instant momento);
}
