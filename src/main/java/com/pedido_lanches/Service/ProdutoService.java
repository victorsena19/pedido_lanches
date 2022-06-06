package com.pedido_lanches.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getAll(){
		List<Produto> list = produtoRepository.findAll();
		return list;
	}
	
	public List<Produto> getId(Long id){
		List<Produto> list = produtoRepository.getId(id);
		return list;
	}
		
		public List<Produto> getNome(String nome) {
			List<Produto> list = produtoRepository.getNome(nome.toLowerCase());
			return list;
	}
		
		public List<Produto> getDescricao(String descricao){
			List<Produto> list = produtoRepository.getDescricao(descricao.toLowerCase());
			return list;
	}
		
		public List<Produto> getPreco(Double preco){
			List<Produto> list = produtoRepository.getPreco(preco);
			return list;
	}
		
		public List<Produto> getFoto(String foto){
			List<Produto> list = produtoRepository.getDescricao(foto.toLowerCase());
			return list;
	}
}
