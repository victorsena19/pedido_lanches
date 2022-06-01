package com.pedido_lanches.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Pagamento;

@Service
public class PagamentoService {

	private PagamentoService pagamentoService;
	
	public List<Pagamento> getAll(){
		return pagamentoService.getAll();
	}
}
