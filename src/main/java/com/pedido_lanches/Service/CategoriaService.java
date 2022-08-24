package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Categoria;
import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> getAll() {
		List<Categoria> list = categoriaRepository.findAll();
		return list;
	}

	public Optional<Categoria> getId(Long id) {
		Optional<Categoria> list = categoriaRepository.getId(id);
		return list;
	}

	public Optional<Categoria> getNome(String nome){
		Optional<Categoria> list = categoriaRepository.getNome(nome.toLowerCase());
		return list;
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria); 
	}
	
	public Messege delete( Long id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		
		if (cat.isPresent()) {
			categoriaRepository.deleteById(id);
			return new Messege("OK", "Item Deletado com Sucesso!");
		}else {
			return new Messege("Erro", "Não existe essa Categoria");
		}
	}
}	
