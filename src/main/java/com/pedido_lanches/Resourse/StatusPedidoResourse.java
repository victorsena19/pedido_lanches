package com.pedido_lanches.Resourse;

import java.util.ArrayList;
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

import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.StatusPedido;
import com.pedido_lanches.Exception.ObjectNotFoundException;
import com.pedido_lanches.Repository.StatusPedidoRepository;
import com.pedido_lanches.Service.StatusPedidoService;

@RestController
@RequestMapping(value = "/statuspedidos")
public class StatusPedidoResourse {

	@Autowired
	private StatusPedidoService statusPedidoService;

	@Autowired
	StatusPedidoRepository repository;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<StatusPedido>> getId(@PathVariable Long id) {
		Optional<StatusPedido> list = statusPedidoService.getId(id);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusPedido>> getNumero(
			@RequestParam(value = "descricao", required = false) String descricao) {
		if (descricao != null) {
			Optional<StatusPedido> list = statusPedidoService.getDescricao(descricao);
			List<StatusPedido> lista = Arrays.asList();
			lista.add(list.get());
			return ResponseEntity.ok().body(lista);
		} else {
			List<StatusPedido> list = statusPedidoService.getAll();
			return ResponseEntity.ok().body(list);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Optional<StatusPedido>> insert(@RequestParam(value = "descricao") String descricao) {
		Optional<StatusPedido> statusPed = statusPedidoService.getDescricao(descricao);
		if (statusPed.isEmpty()) {
			StatusPedido statusPedido = new StatusPedido();
			statusPedido.setDescricao(descricao);
			statusPedidoService.save(statusPedido);
			statusPed = statusPedidoService.getDescricao(descricao);
			return ResponseEntity.created(null).body(statusPed);
		} else {
			throw new ObjectNotFoundException("StatusPedido");
		}
	}

	@PutMapping(path = "/{id}")
	public Messege update(
			@PathVariable Long id, 
			@RequestParam(value = "descricao") String descricao) {
		Optional<StatusPedido> statusPedido = statusPedidoService.getId(id);
		
		if (statusPedido.isPresent()) {
			Optional<StatusPedido> statusPed = statusPedidoService.getDescricao(descricao);
			if (!statusPed.isPresent()) {
				statusPedido.get().setDescricao(descricao);
				statusPedidoService.save(statusPedido.get());
				return new Messege("OK", "ATUALIZADO COM SUCESSO");
			} 
			else {
				return new Messege("ERRO", "ESSE STATUS DE PEDIDO JÁ EXISTE");
			}
		} 
		else {
			return new Messege("ERRO", "ESSE STATUS DE PEDIDO NÃO EXISTE");
		}
	}

	@DeleteMapping(path = "/{id}")
	public Messege delete(
			@PathVariable Long id) {
		Optional<StatusPedido> statusPedId = statusPedidoService.getId(id);
		if (statusPedId.isPresent()) {
			repository.deleteById(id);
			return new Messege("OK", "STATUS DELETADO COM SUCESSO");
		} else {
			return new Messege("ERRO", "DESCRIÇÃO NÃO EXISTE");
		}
	}
}
