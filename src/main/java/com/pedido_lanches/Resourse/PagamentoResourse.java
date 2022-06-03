package com.pedido_lanches.Resourse;

import java.time.Instant;
import java.util.List;

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
			List<Pagamento> pagamento = pagamentoService.getId(id);
			return ResponseEntity.ok().body(pagamento);
		}
		else {
			List<Pagamento> pagamento = pagamentoService.getAll();
			return ResponseEntity.ok().body(pagamento);
		}
		
	}
}
