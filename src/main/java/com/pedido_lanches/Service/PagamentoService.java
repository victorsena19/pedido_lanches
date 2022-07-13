package com.pedido_lanches.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Pagamento;
import com.pedido_lanches.Repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public List<Pagamento> getAll(){
		List<Pagamento> list = pagamentoRepository.findAll();
		return list;
	}
	
	public Optional<Pagamento> getId(Long id){
		Optional<Pagamento> list = pagamentoRepository.getId(id);
		return list;
	}
	
	public List<Pagamento> getMomento(Instant momento){
		List<Pagamento> list = pagamentoRepository.getMomento(momento);
		return list;
	}
}
