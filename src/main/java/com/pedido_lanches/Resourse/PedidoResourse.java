package com.pedido_lanches.Resourse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResourse {
	
	private PedidoService pedidoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> getNumeroId(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "numero", required = false) Integer numero){
		if(id != null) {
			List<Pedido> list = pedidoService.getId(id);
			return ResponseEntity.ok().body(list);
		}else if(numero != null) {
			List<Pedido> list = pedidoService.getNumero(numero);
			return ResponseEntity.ok().body(list);
		}else {
			List<Pedido> list = pedidoService.getAll();
			 return ResponseEntity.ok().body(list);
		}
		
	}

}
