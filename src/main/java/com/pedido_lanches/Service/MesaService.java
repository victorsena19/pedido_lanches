package com.pedido_lanches.Service;

import java.util.List;

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
	
	public List<Mesa> getId(Long id){
		List<Mesa> list = mesaRepository.getId(id);
		return list;
	}
	
	public List<Mesa> getNumero(Integer numero){
		List<Mesa> list = mesaRepository.getNumero(numero);
		return list;
	}
}
