package com.pedido_lanches.Resourse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResourse {
	
	@Autowired
	private PedidoService pedidoService;
	
	private static final Logger logger = LogManager.getLogger(MesaResourse.class);
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Pedido>> getId(@PathVariable Long id){
		Optional<Pedido> list = pedidoService.getId(id);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> getAll(
			@RequestParam(value = "numero", required = false) Integer numPedido)
	{
		if(numPedido != null) {
			List<Pedido> lista = Arrays.asList();
			Optional<Pedido> pedidonumero = pedidoService.getNumero(numPedido);
			if (pedidonumero.isPresent()) {
				lista.add(pedidonumero.get());
			}
			return ResponseEntity.ok().body(lista);
		}else {
			List<Pedido> list = pedidoService.getAll();
			 return ResponseEntity.ok().body(list);
		}
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Optional<Pedido>> insert(
			@RequestBody Pedido pedido) {
		Optional<Pedido> list = pedidoService.getNumero(pedido.getNumPedido());
		if(list.isEmpty()) {
			pedidoService.insert(pedido);
			list = pedidoService.getNumero(pedido.getNumPedido());
			return ResponseEntity.created(null).body(list);
		}else {
			throw new ObjectNotFoundException("ERRO", "ESSE ITEM JÁ EXISTE");
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Optional<Pedido>> upadate(@PathVariable Long id, @RequestBody Pedido pedido){
		Optional<Pedido> list = pedidoService.getNumero(pedido.getNumPedido());
		if(list.isEmpty()) {
			pedidoService.update(pedido);
			list = pedidoService.getNumero(pedido.getNumPedido());
			return ResponseEntity.ok().body(list);
		}else {
			throw new ObjectNotFoundException("ERRO", "ESSE ITEM NÃO EXISTE");
		}
	}
	
	@PatchMapping(path = "/insereproduto")
	public ResponseEntity<Pedido> addProd(
			@RequestParam(value = "pedido")  Long pedido,
			@RequestParam(value = "produto")  Long produto){
		logger.info("PRODUTO-ID=="+produto.toString());
		logger.info("PEDIDO -ID=="+pedido.toString());
		
		Pedido update = pedidoService.insertPro(produto, pedido);
		return ResponseEntity.ok().body(update);
	}
	
	@PatchMapping(path = "/deleteproduto")
	public ResponseEntity<Pedido> deleteProd(
			@RequestParam(value = "pedido") Long pedido,
			@RequestParam(value = "produto") Long produto){
		Pedido deleteProduto = pedidoService.deleteProd(produto, pedido);
		return ResponseEntity.ok().body(deleteProduto);
	}
}
