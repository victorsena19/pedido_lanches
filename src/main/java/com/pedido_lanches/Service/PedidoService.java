package com.pedido_lanches.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Repository.PedidoRepository;

@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> getAll(){
		return pedidoRepository.findAll();
	}
}
