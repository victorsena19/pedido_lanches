package com.pedido_lanches.Resourse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Service.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResourse {
	
	private PagamentoService pagamentoService;
}
