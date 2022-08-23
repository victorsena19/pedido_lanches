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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Categoria;
import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Exception.ObjectNotFoundException;
import com.pedido_lanches.Service.CategoriaService;
import com.pedido_lanches.Service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResourse {
	
	CategoriaService categoriaService;

	@Autowired
	private ProdutoService produtoService;
	
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
	public ResponseEntity<Optional<Produto>> insert(Produto produto,
			@RequestParam(value = "nome")String nome,
			@RequestParam(value = "descricao", required = false)String descricao,
			@RequestParam(value = "preco")Double preco,
			@RequestParam(value = "foto", required = false)String foto){
		Optional<Produto> list = produtoService.getNome(produto.getNome());
		if(list.isEmpty()) {
			produtoService.insert(produto);
			list = produtoService.getNome(produto.getNome());
			return ResponseEntity.created(null).body(list);
		}else {
			throw new ObjectNotFoundException("RRODUTO NÃO EXISTE");
		}
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<Optional<Produto>> update(@PathVariable Long id,
			@RequestParam(value = "nome", required = false)String nome,
			@RequestParam(value = "descricao", required = false)String descricao,
			@RequestParam(value = "preco", required = false)Double preco,
			@RequestParam(value = "categoria", required = false)Long categoria
			){
		Optional<Produto> produtoId = produtoService.getId(id);
		if(produtoId.isPresent()) {
			if(nome != null) {
				produtoId.get().setNome(nome);
			}
			if(descricao != null) {
				produtoId.get().setDescricao(descricao);
			}
			if(preco != null) {
				produtoId.get().setPreco(preco);
			}
			if(categoria != null) {
				Optional<Categoria> cat = categoriaService.getId(id);
				produtoId.get().setCategoria(cat.get());
			}
			produtoService.update(produtoId.get());
			produtoId = produtoService.getId(id);
			return ResponseEntity.ok().body(produtoId);
		}
		else {
			throw new ObjectNotFoundException("RRODUTO NÃO EXISTE");
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Messege> delete(@PathVariable Long id) {
		Messege produto = produtoService.delete(id);
		return ResponseEntity.ok().body(produto);
	}
}
