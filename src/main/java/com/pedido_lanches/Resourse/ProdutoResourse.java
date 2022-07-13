package com.pedido_lanches.Resourse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Exception.ObjectNotFoundException;
import com.pedido_lanches.Repository.ProdutoRepository;
import com.pedido_lanches.Service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResourse {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository repository;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Produto>> getId(@PathVariable Long id){
		Optional<Produto> list = produtoService.getId(id);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> getAll(Long id,
			@RequestParam(value = "nome", required = false)String nome)
			{
		if(nome != null) {
			List<Produto> lista = Arrays.asList();
			Optional<Produto> list = produtoService.getNome(nome);
			if(list.isPresent()) {
				lista.add(list.get());
			}
			return ResponseEntity.ok().body(lista);		
		}else {
			List<Produto> list = produtoService.getAll();
			return ResponseEntity.ok().body(list);
		}
	}
	
	@PostMapping
	public ResponseEntity<Optional<Produto>> insert(@RequestBody Produto produto){
		Optional<Produto> list = produtoService.getNome(produto.getNome());
		if(list.isEmpty()) {
			produtoService.insert(produto);
			list = produtoService.getNome(produto.getNome());
			return ResponseEntity.created(null).body(list);
		}else {
			throw new ObjectNotFoundException("RRODUTO");
		}
	}
	@PutMapping
	public ResponseEntity<Optional<Produto>> update(@RequestBody Produto produto){
		Optional<Produto> list = produtoService.getNome(produto.getNome());
		if(list.isEmpty()) {
			produtoService.update(produto);
			list = produtoService.getNome(produto.getNome());
			return ResponseEntity.created(null).body(list);
		}else {
			throw new ObjectNotFoundException("RRODUTO");
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public Messege delete(@PathVariable Long id) {
		Optional<Produto> list = produtoService.getId(id);
		 if(!list.isEmpty()) {
			 repository.deleteById(id);
			 return new Messege("OK", "PRODUTO APAGADO COM SUCESSO");
			 }else {
			 return new Messege("ERRO AO APAGAR", "ESSE PRODUTO NÃO EXISTE");
		 }
	}
}
