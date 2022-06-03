package com.pedido_lanches.Resourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Categoria;
import com.pedido_lanches.Service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResourse {
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getNomeId(
			@RequestParam(value = "nome", required = false)String nome,
			@RequestParam(value = "id", required = false)Long id)
	{
		if(nome !=null) {
			List<Categoria> categoria = categoriaService.getNome(nome);
			return ResponseEntity.ok().body(categoria);
		}else if(id != null) {
			List<Categoria> categoria = categoriaService.getId(id);
			return ResponseEntity.ok().body(categoria);
		}
		else {
			List<Categoria> categoria = categoriaService.getAll();
			return ResponseEntity.ok().body(categoria);
		}
		
	}
}
