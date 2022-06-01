package com.pedido_lanches.Service;

import java.util.List;

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
}
