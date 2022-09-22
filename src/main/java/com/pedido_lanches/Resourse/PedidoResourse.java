package com.pedido_lanches.Resourse;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Mesa;
import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Pagamento;
import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Entity.StatusPedido;
import com.pedido_lanches.Service.MesaService;
import com.pedido_lanches.Service.PagamentoService;
import com.pedido_lanches.Service.PedidoService;
import com.pedido_lanches.Service.ProdutoService;
import com.pedido_lanches.Service.StatusPedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResourse {

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	StatusPedidoService statusPedidoService;

	@Autowired
	private MesaService mesaService;

	private static final Logger logger = LogManager.getLogger(MesaResourse.class);

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Pedido>> getId(@PathVariable Long id) {
		Optional<Pedido> list = pedidoService.getAllPedido(id);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> getAll(
			@RequestParam(value = "numero", required = false) Integer numero,
			@RequestParam(value = "mesa", required = false) Long mesaId) {
		if (numero != null) {
			List<Pedido> lista = new ArrayList<Pedido>();
			Optional<Pedido> pedidonumero = pedidoService.getNumero(numero);
			if (pedidonumero.isPresent()) {
				lista.add(pedidonumero.get());
			}
			return ResponseEntity.ok().body(lista);
		} 
		else if (mesaId != null) {
			List<Pedido> lista = new ArrayList<Pedido>();
			Optional<Pedido> mesa = pedidoService.getMesa(mesaId);
			logger.info("mesa-ID==" + mesa);
			if (mesa.isPresent()) {
				lista.add(mesa.get());
			}
			return ResponseEntity.ok().body(lista);
		}
	

		else {
			List<Pedido> list = pedidoService.getAll();
			return ResponseEntity.ok().body(list);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Pedido> insert(@RequestParam(value = "numpedido", required = false) Integer numPedido,
			@RequestParam(value = "idmesa") Long idMesa, @RequestParam(value = "totalpedido") Double totalPedido,
			@RequestParam(value = "momentopedido", required = false) Instant momentoPedido,
			@RequestParam(value = "statuspagamento") Long idStatusPedido,
			@RequestParam(value = "produto", required = false) Long idProduto) {

		Optional<Pedido> list = pedidoService.getNumero(numPedido);
		if (list.isEmpty()) {
			Pedido pedido = new Pedido();
			Optional<Mesa> mesa = mesaService.getNumero(idMesa);
			logger.info("mesa-ID==" + mesa.get().toString());
			if (!mesa.isPresent()) {
				throw new ObjectNotFoundException("ERRO", "Mesa não existe");
			}
			Optional<StatusPedido> statusPedido = statusPedidoService.getId(idStatusPedido);
			logger.info("statusPedido-ID==" + statusPedido.get().toString());
			if (!statusPedido.isPresent()) {
				throw new ObjectNotFoundException("ERRO", "StatusPedido não existe");
			}
			
			pedido.setNumPedido(numPedido);
			pedido.setMesa(mesa.get());
			pedido.setMomentoPedido(Instant.now());
			pedido.setStatusPedido(statusPedido.get());

			
			pedidoService.insert(pedido);
			Pedido getPedido = pedidoService.getId(pedido.getId()).get();
			logger.info("Pedido-ID==" + pedido.toString());
			return ResponseEntity.created(null).body(getPedido);
		} else {
			throw new RuntimeException("ERRO, ESSE PEDIDO JÁ EXISTE");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Pedido> upadate(@PathVariable Long id,
			@RequestParam(value = "numpedido", required = false) Integer numPedido,
			@RequestParam(value = "mesa", required = false) Long idMesa,
			@RequestParam(value = "momentopedido", required = false) Instant momentoPedido,
			@RequestParam(value = "statusPedido", required = false) Long idStatusPedido,
			@RequestParam(value = "pagamento", required = false) Long pagamento) {

		Optional<Pedido> pedido = pedidoService.getId(id);
		if (pedido.isPresent()) {
			if (numPedido != null) {
				pedido.get().setNumPedido(numPedido);
				logger.info("numero-ID==" + numPedido.toString());

			}
			if (idMesa != null) {
				Optional<Mesa> mesa = mesaService.getNumero(idMesa);
				pedido.get().setMesa(mesa.get());
				logger.info("mesa-ID==" + mesa.get().toString());

			}
			}
			if (idStatusPedido != null) {
				Optional<StatusPedido> statusPedido = statusPedidoService.getId(idStatusPedido);
				pedido.get().setStatusPedido(statusPedido.get());
				logger.info("StatusPedido-ID==" + statusPedido.toString());

			}
			if (pagamento != null) {
				Optional<Pagamento> pag = pagamentoService.getId(pagamento);
				pedido.get().setPagamento(pag.get());
				logger.info("Pagamento-ID==" + pagamento.toString());
			}
			pedido.get().setMomentoPedido(Instant.now());
			pedidoService.update(pedido.get());

			pedido = pedidoService.getId(id);
			return ResponseEntity.ok().body(pedido.get());
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Messege> delete(@PathVariable Long id) {
		Messege ped = pedidoService.delete(id);
		return ResponseEntity.ok().body(ped);
	}

}
