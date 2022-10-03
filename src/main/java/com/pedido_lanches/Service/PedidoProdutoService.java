package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.PedidoProduto;
import com.pedido_lanches.Repository.PedidoProdutoRepository;

@Service
public class PedidoProdutoService {
	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	
	public List<PedidoProduto> getAll(){
		List<PedidoProduto> list = pedidoProdutoRepository.getAll();
		return list;
	}
	
	public Optional<PedidoProduto> getProduto(Long id){
		Optional<PedidoProduto> getProduto = pedidoProdutoRepository.findAllByProduto(id);
		return getProduto;
	}

	public List<PedidoProduto> getPedido(Long id){
		List<PedidoProduto> getPedido = pedidoProdutoRepository.findAllByPedido(id);
		return getPedido;
	}
	
	public PedidoProduto saveDados(PedidoProduto pedidoProduto) {
		PedidoProduto saveDados = pedidoProdutoRepository.save(pedidoProduto);
		return saveDados;
	}
}
