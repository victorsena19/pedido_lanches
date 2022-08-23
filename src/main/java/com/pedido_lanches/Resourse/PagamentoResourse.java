package com.pedido_lanches.Resourse;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Entity.Pagamento;
import com.pedido_lanches.Service.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResourse {

	@Autowired
	private PagamentoService pagamentoService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Pagamento>> getId(@PathVariable Long id) {
		Optional<Pagamento> pagamento = pagamentoService.getId(id);
		return ResponseEntity.ok().body(pagamento);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pagamento>> getMomentoId(
			@RequestParam(value = "momento", required = false) Instant momento,
			@RequestParam(value = "id", required = false) Long id) {
		if (momento != null) {
			List<Pagamento> lista = Arrays.asList();
			Optional<Pagamento> pagamento = pagamentoService.getMomento(momento);
			lista.add(pagamento.get());
			return ResponseEntity.ok().body(lista);
		} else if (id != null) {
			List<Pagamento> lista = Arrays.asList();
			Optional<Pagamento> pagamento = pagamentoService.getId(id);
			lista.add(pagamento.get());
			return ResponseEntity.ok().body(lista);
		} else {
			List<Pagamento> pagamento = pagamentoService.getAll();
			return ResponseEntity.ok().body(pagamento);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Optional<Pagamento>> update(@PathVariable Long id,
			@RequestParam(value = "momento", required = false) Instant momento) {
		if (id != null) {
			if (momento != null) {
				Optional<Pagamento> pagamentoId = pagamentoService.getId(id);
				pagamentoId.get().setMomento(momento);
				pagamentoService.save(pagamentoId.get());
				pagamentoId = pagamentoService.getId(id);
				return ResponseEntity.ok().body(pagamentoId);
			} else {
				throw new NoSuchElementException("NÃO FOI PASSADO NENHUM MOMENTO PARA SER ALTERADO");
			}
		}
		else{
			throw new NoSuchElementException("ESSE MOMENTO NÃO EXISTE");
		}
	}
	

	@PostMapping
	public ResponseEntity<Optional<Pagamento>> insert(@RequestParam(value = "momento") Instant momento) {
		Pagamento pagamento = new Pagamento();
		pagamento.setMomento(momento);
		pagamentoService.save(pagamento);
		Optional<Pagamento> pag = pagamentoService.getMomento(momento);
		return ResponseEntity.created(null).body(pag);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Messege> delete(@PathVariable Long id) {
		Messege pagMomento = pagamentoService.delete(id);
		return ResponseEntity.ok().body(pagMomento);
	}
}
