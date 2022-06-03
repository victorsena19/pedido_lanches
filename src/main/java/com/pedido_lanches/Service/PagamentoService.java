package com.pedido_lanches.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Pagamento;

@Service
public class PagamentoService {

	private PagamentoService pagamentoService;
	
	public List<Pagamento> getAll(){
		List<Pagamento> list = pagamentoService.getAll();
		return list;
	}
	
	public List<Pagamento> getId(Long id){
		List<Pagamento> list = pagamentoService.getId(id);
		return list;
	}
	
	public List<Pagamento> getMomento(Instant momento){
		List<Pagamento> list = pagamentoService.getMomento(momento);
		return list;
	}
}
