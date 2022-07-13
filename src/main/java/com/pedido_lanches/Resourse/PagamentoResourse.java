package com.pedido_lanches.Resourse;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Pagamento;
import com.pedido_lanches.Service.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResourse {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pagamento>> getMomentoId(
			@RequestParam(value = "momento", required = false)Instant momento,
			@RequestParam(value = "id", required = false)Long id)
	{
		if(momento !=null) {
			List<Pagamento> pagamento = pagamentoService.getMomento(momento);
			return ResponseEntity.ok().body(pagamento);
		}else if(id != null) {
			List<Pagamento> lista = Arrays.asList();
			Optional<Pagamento> pagamento = pagamentoService.getId(id);
			if(pagamento.isPresent()) {
				lista.add(pagamento.get());
			}
			return ResponseEntity.ok().body(lista);
		}
		else {
			List<Pagamento> pagamento = pagamentoService.getAll();
			return ResponseEntity.ok().body(pagamento);
		}
		
	}
}
