package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Mesa;
import com.pedido_lanches.Repository.MesaRepository;

@Service
public class MesaService {
	@Autowired
	private MesaRepository mesaRepository;
	
	public List<Mesa> getAll(){
		List<Mesa> list = mesaRepository.findAll();
		return list;
	}
	
	public Optional<Mesa> getId(Long id){
		Optional<Mesa> temp_mesa = mesaRepository.getId(id);
		
		if (!temp_mesa.isEmpty()) {
			return temp_mesa;
		}
		return null;	
	}
	
	public Optional<Mesa> getNumero(Integer numero){
		Optional<Mesa> list = mesaRepository.getNumero(numero);
		return list;
	}
	
	public Mesa insert(Mesa mesa) {
		Mesa list = mesaRepository.save(mesa);
		return   list;
	}
}
