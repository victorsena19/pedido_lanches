package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Optional<Pedido> getId(Long id) {
		Optional<Pedido> list = pedidoRepository.getId(id);
		return list;
	}

	public Optional<Pedido> getNumero(Integer numero) {
		Optional<Pedido> list = pedidoRepository.getNumPedido(numero);
		return list;
	}
	
	public Optional<Pedido> getAllPedido(Long pedido){
		Optional<Pedido> getAllPedido = pedidoRepository.findAllByPedido(pedido);
		return getAllPedido;
	}
	
	public Optional<Pedido> getMesa(Long mesa){
		Optional<Pedido> mesaId = pedidoRepository.findAllByMesa(mesa);
		return mesaId;
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
