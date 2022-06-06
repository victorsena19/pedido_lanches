package com.pedido_lanches.Resourse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.StatusPedido;
import com.pedido_lanches.Service.StatusPedidoService;

@RestController
@RequestMapping(value = "/statuspedidos")
public class StatusPedidoResourse {

	private StatusPedidoService statusPedidoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusPedido>> getNumeroId(
			@RequestParam(value = "descricao", required = false) String descricao,
			@RequestParam(value = "id", required = false) Long id) {
		if (descricao != null) {
			List<StatusPedido> mesa = statusPedidoService.getDescricao(descricao);
			return ResponseEntity.ok().body(mesa);
		} else if (id != null) {
			List<StatusPedido> mesa = statusPedidoService.getId(id);
			return ResponseEntity.ok().body(mesa);
		} else {
			List<StatusPedido> mesa = statusPedidoService.getAll();
			return ResponseEntity.ok().body(mesa);
		}

	}
}
