package com.pedido_lanches.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Repository.PedidoRepository;

@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> getId(Long id){
		List<Pedido> list = pedidoRepository.getId(id);
		return list;
	}
	
	public List<Pedido> getNumero(Integer numero){
		List<Pedido> list = pedidoRepository.getNumPedido(numero);
		return list;
	}
	public List<Pedido> getAll(){
		List<Pedido> list = pedidoRepository.findAll();
		return list;
	}
}
