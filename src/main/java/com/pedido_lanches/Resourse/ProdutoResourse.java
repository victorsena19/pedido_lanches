package com.pedido_lanches.Resourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResourse {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> getAll(@RequestParam(value = "id")Long id,
			@RequestParam(value = "nome", required = false)String nome,
			@RequestParam(value = "descricao", required = false)String descricao,
			@RequestParam(value = "preco", required = false)double preco,
			@RequestParam(value = "foto", required = false)String foto){
		if(id != null) {
			List<Produto> list = produtoService.getId(id);
			return ResponseEntity.ok().body(list);
		}else if(nome != null) {
			List<Produto> list = produtoService.getNome(nome);
			return ResponseEntity.ok().body(list);		
		}else if(descricao != null){
			List<Produto> list = produtoService.getDescricao(descricao);
			return ResponseEntity.ok().body(list);
		}else if(preco != 0) {
			List<Produto> list = produtoService.getPreco(preco);
			return ResponseEntity.ok().body(list);
		}else if(foto != null) {
			List<Produto> list = produtoService.getFoto(foto);
			return ResponseEntity.ok().body(list);
		}else {
			List<Produto> list = produtoService.getAll();
			return ResponseEntity.ok().body(list);
		}
	}
}
