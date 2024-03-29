package com.pedido_lanches.Resourse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Categoria;
import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Exception.ObjectNotFoundException;
import com.pedido_lanches.Service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResourse {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Optional<Categoria>> getId(@PathVariable Long id) {
		Optional<Categoria> list = categoriaService.getId(id);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getNome(@RequestParam(value = "nome", required = false) String nome) {
		if (nome != null) {
			List<Categoria> addLista = Arrays.asList();
			Optional<Categoria> categoria = categoriaService.getNome(nome);
			if (categoria.isPresent()) {
				addLista.add(categoria.get());
			}
			return ResponseEntity.ok().body(addLista);
		} else {
			List<Categoria> categoria = categoriaService.getAll();
			return ResponseEntity.ok().body(categoria);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Categoria> insert(Categoria cat, @RequestParam(value = "nome") String nome) {
		Optional<Categoria> list = categoriaService.getNome(cat.getNome());
		if (list.isEmpty()) {
			Categoria categ = categoriaService.save(cat);
			return ResponseEntity.ok().body(categ);
		} else {
			throw new ObjectNotFoundException(cat.getNome());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Optional<Categoria>> update(@PathVariable Long id,
			@RequestParam(value = "nome") String categ) {
		Optional<Categoria> categoria = categoriaService.getId(id);
		Optional<Categoria> categNome = categoriaService.getNome(categ);
		if (categoria.isPresent()) {
			if (categNome.isEmpty()) {
				categoria.get().setNome(categ);
				categoriaService.save(categoria.get());
			}else {
				throw new ObjectNotFoundException("Categoria");
			}
			return ResponseEntity.ok().body(categoria);
		} else {
			throw new ObjectNotFoundException("ESSA CATEGORIA NÃO EXISTE");
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Messege> delete(@PathVariable Long id) {

		Messege cat = categoriaService.delete(id);

		return ResponseEntity.ok().body(cat);
	}

}
