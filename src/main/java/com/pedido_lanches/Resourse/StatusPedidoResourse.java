package com.pedido_lanches.Resourse;

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
	public ResponseEntity<Optional<StatusPedido>> getId(@PathVariable Long id){
		Optional<StatusPedido> list = statusPedidoService.getId(id);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusPedido>> getNumero(
			@RequestParam(value = "descricao", required = false) String descricao) {
		if (descricao != null) {
			List<StatusPedido> list = statusPedidoService.getDescricao(descricao);
			return ResponseEntity.ok().body(list);
		} else {
			List<StatusPedido> list = statusPedidoService.getAll();
			return ResponseEntity.ok().body(list);
		}
	}
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<List<StatusPedido>> insert(
				@RequestBody StatusPedido statusPedido) {
			List<StatusPedido> list = statusPedidoService.getDescricao(statusPedido.getDescricao());
			if(list.isEmpty()) {
				statusPedidoService.insert(statusPedido);
				list = statusPedidoService.getDescricao(statusPedido.getDescricao());
				return ResponseEntity.created(null).body(list);
			}else {
				throw new ObjectNotFoundException("StatusPedido");
			}
	}
		
		@PutMapping()
		public Messege update(
				@RequestBody StatusPedido statusPedido) {
		if(statusPedidoService.getDescricao(statusPedido.getDescricao()).isEmpty()) {
			statusPedidoService.insert(statusPedido);
			return new Messege("OK","ATUALIZADO COM SUCESSO");
		}else {
			return new Messege("ERRO","ESSA DESCRIÇÃO JÁ EXISTE");
		}
	}
		
		@DeleteMapping(path = "/{id}")
		public Messege delete(@PathVariable Long id,
				@RequestBody StatusPedido statusPedido) {
			if(statusPedidoService.getId(statusPedido.getId()).isEmpty()) {
				repository.deleteById(id);
				return new Messege("OK", "DESCRIÇÃO DELETADA COM SUCESSO");
			}else {
				return new Messege("ERRO", "DESCRIÇÃO NÃO EXISTE");
			}
		}
}
