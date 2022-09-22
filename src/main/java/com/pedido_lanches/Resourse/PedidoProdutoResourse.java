package com.pedido_lanches.Resourse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Entity.PedidoProduto;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Service.PedidoProdutoService;
import com.pedido_lanches.Service.PedidoService;
import com.pedido_lanches.Service.ProdutoService;

@RestController
@RequestMapping(value = "/pedidoproduto")
public class PedidoProdutoResourse {

	private static final Logger logger = LogManager.getLogger(MesaResourse.class);
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoProdutoService pedidoProdutoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PedidoProduto>> getAll() {
			List<PedidoProduto> pedidoProduto = pedidoProdutoService.getAll();
			logger.info("getAll==PedidoProduto" + pedidoProduto.toArray());
			return ResponseEntity.ok().body(pedidoProduto);
		}
	/*
	@PostMapping
	public ResponseEntity<PedidoProduto> insert(
			@RequestParam(value = "pedido") Long pedidoId,
			@RequestParam(value = "produto") Long produtoId){
		Optional<Pedido> pedido = pedidoService.getId(pedidoId);
		PedidoProduto pedidoProduto = new PedidoProduto();
		if(pedido.isPresent()) {
			pedidoProduto.setPedido(pedido.get());
		}
		
		Optional<Produto> produto = produtoService.getId(produtoId);
		if(produto.isPresent()) {
			pedidoProduto.setProduto(produto.get());
		}
		PedidoProduto getProdutoPedido = pedidoProdutoService.save(pedidoProduto);
		return ResponseEntity.created(null).body(getProdutoPedido);
	}
	*/
}
