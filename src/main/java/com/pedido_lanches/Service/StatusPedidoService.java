package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.StatusPedido;
import com.pedido_lanches.Repository.StatusPedidoRepository;

@Service
public class StatusPedidoService {
	
	@Autowired
	private StatusPedidoRepository statusPedidoRepository;
	
	public List<StatusPedido> getAll(){
		return statusPedidoRepository.findAll();
	}
	
	public Optional<StatusPedido> getId(Long id){
		Optional<StatusPedido> list = statusPedidoRepository.getId(id);
		return list;
	}
	public List<StatusPedido> getDescricao(String descricao){
		List<StatusPedido> list = statusPedidoRepository.getDescricao(descricao.toLowerCase());
		return list;
	}
	
	public StatusPedido insert(StatusPedido statusPedido) {
		StatusPedido save = statusPedidoRepository.save(statusPedido);
		return save;
	}
}
