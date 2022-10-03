package com.pedido_lanches.Resourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<PedidoProduto>> getAll(@RequestParam(value = "pedido", required = false) Long pedido,
			@RequestParam(value = "produto", required = false) Long produto) {
		if (pedido != null) {
			List<PedidoProduto> getPedido = pedidoProdutoService.getPedido(pedido);
			return ResponseEntity.ok(getPedido);
		} else if (produto != null) {
			List<PedidoProduto> lista = new ArrayList<PedidoProduto>();
			Optional<PedidoProduto> getProduto = pedidoProdutoService.getProduto(produto);
			if (getProduto.isPresent()) {
				lista.add(getProduto.get());
			}
			return ResponseEntity.ok(lista);
		} else {
			List<PedidoProduto> pedidoProduto = pedidoProdutoService.getAll();
			logger.info("getAll==PedidoProduto" + pedidoProduto.toArray());
			return ResponseEntity.ok().body(pedidoProduto);
		}

	}

	@PostMapping
	public ResponseEntity<PedidoProduto> insert(
			@RequestParam(value = "pedido") Long pedidoId,
			@RequestParam(value = "produto") Long produtoId,
			@RequestParam(value = "quantidade") Integer quantidade,
			@RequestParam(value = "valorunitario", required = false) Double valor) {
		Optional<Pedido> pedido = pedidoService.getId(pedidoId);
		PedidoProduto pedidoProduto = new PedidoProduto();
		if (pedido.isPresent()) {
			pedidoProduto.setPedido(pedido.get());
		}
		Optional<Produto> produto = produtoService.getId(produtoId);
		if (produto.isPresent()) {
			pedidoProduto.setProduto(produto.get());
		}
		if(quantidade != null) {
			pedidoProduto.setQuantidadeProduto(quantidade);
		}
		
		PedidoProduto getProdutoPedido = pedidoProdutoService.saveDados(pedidoProduto);
		return ResponseEntity.created(null).body(getProdutoPedido);
		
	}
}
