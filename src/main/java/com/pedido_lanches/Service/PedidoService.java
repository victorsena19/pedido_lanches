package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Repository.PedidoRepository;
import com.pedido_lanches.Repository.ProdutoRepository;
import com.pedido_lanches.Resourse.MesaResourse;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	private static final Logger logger = LogManager.getLogger(MesaResourse.class);
	
	
	public Optional<Pedido> getId(Long id) {
		Optional<Pedido> list = pedidoRepository.getId(id);
		return list;
	}

	public Optional<Pedido> getNumero(Integer numPedido) {
		Optional<Pedido> list = pedidoRepository.getNumPedido(numPedido);
		return list;
	}

	public List<Pedido> getAll() {
		List<Pedido> list = pedidoRepository.findAll();
		return list;
	}

	public Pedido insert(Pedido pedido) {
		Pedido insert = pedidoRepository.save(pedido);
		return insert;
	}

	public Pedido update(Pedido pedido) {
		Pedido update = pedidoRepository.save(pedido);
		return update;
	}

	public Pedido insertPro(Long produto, Long pedido) {
		
		Optional<Pedido> PedId = pedidoRepository.getId(pedido);
		Optional<Produto> ProId = produtoRepository.getId(produto);
	
		if (PedId.isPresent() && ProId.isPresent()) {
			PedId.get().getProdutos().add(ProId.get());
			pedidoRepository.save(PedId.get());
			return PedId.get();
		} else {
			throw new ObjectNotFoundException("ERRO", "PEDIDO OU PRODUTO NÃO EXISTE");
		}
	}

	public Pedido deleteProd(Long produto, Long pedido) {
		
		Optional<Produto> proId = produtoRepository.getId(produto);
		Optional<Pedido> pedId = pedidoRepository.getId(pedido);
		
		if(proId.isPresent() && pedId.isPresent()) {
			pedId.get().getProdutos().remove(proId.get());
			pedidoRepository.save(pedId.get());
			return pedId.get();
		}else {
			throw new ObjectNotFoundException("ERRO", "PEDIDO OU PRODUTO NÃO EXISTE");
		}
	}
	
	public Messege delete(Long id) {
		Optional<Pedido> pedidoId = pedidoRepository.findById(id);
		if(pedidoId.isPresent()) {
			pedidoRepository.deleteById(id);
			return new Messege("OK", "PEEDIDO DELETADO COM SUCESSO");
		}
		else {
			return new Messege("ERRO", "PEEDIDO NÃO EXISTE");
		}
	}
}
