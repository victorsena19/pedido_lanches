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

	public List<Categoria> getNome(String nome){
		List<Categoria> list = categoriaRepository.getNome(nome.toLowerCase());
		return list;
	}
	
	public Categoria insert(Categoria obj) {
		return categoriaRepository.save(obj); 
	}
	
	public Categoria update(Long id, Categoria cat){
		Categoria categ = categoriaRepository.getReferenceById(id);
		updateData(categ, cat);
		return categoriaRepository.save(categ);
	}
	
	private void updateData(Categoria categ, Categoria cat) {
		categ.setNome(cat.getNome());
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
