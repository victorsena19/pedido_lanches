package com.pedido_lanches.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Categoria;
import com.pedido_lanches.Repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> getAll() {
		List<Categoria> list = categoriaRepository.findAll();
		return list;
	}

	public List<Categoria> getId(Long id) {
		List<Categoria> list = categoriaRepository.getId(id);
		return list;
	}

	public List<Categoria> getNome(String nome){
		List<Categoria> list = categoriaRepository.getNome(nome);
		return list;
	}
}	
