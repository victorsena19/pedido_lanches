package com.pedido_lanches.Resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResourse {

	@Autowired
	private ProdutoService produtoService;
}
