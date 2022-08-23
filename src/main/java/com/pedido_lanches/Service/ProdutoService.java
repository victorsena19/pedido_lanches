package com.pedido_lanches.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> getAll() {
		List<Produto> list = produtoRepository.findAll();
		return list;
	}

	public Optional<Produto> getId(Long id) {
		Optional<Produto> list = produtoRepository.getId(id);
		return list;
	}

	public Optional<Produto> getNome(String nome) {
		Optional<Produto> list = produtoRepository.getNome(nome.toLowerCase());
		return list;
	}

	public Produto insert(Produto produto) {
		Produto save = produtoRepository.save(produto);
		return save;
	}

	public Produto update(Produto produto) {
		Produto save = produtoRepository.save(produto);
		return save;
	}
	
	public Messege delete(Long produto) {
		Optional<Produto> produtoId = produtoRepository.getId(produto);
		if(produtoId.isPresent()) {
			produtoRepository.deleteById(produto);
			return new Messege("OK", "PRODUTO DELETADO");
		}
		else {
			return new Messege("ERRO", "ESSE PRODUTO NÃO EXISTE");
		}
		
	}
}
