package com.pedido_lanches.Resourse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Mesa;
import com.pedido_lanches.Entity.Messege;
import com.pedido_lanches.Exception.ObjectNotFoundException;
import com.pedido_lanches.Repository.MesaRepository;
import com.pedido_lanches.Service.MesaService;

@RestController
@RequestMapping(value = "/mesas")
public class MesaResourse {
	
	private static final Logger logger = LogManager.getLogger(MesaResourse.class);
	
	@Autowired
	private MesaService mesaService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Mesa> getId(@PathVariable Long numero){
		Optional<Mesa> mesa = mesaService.getNumero(numero);
		
		if (!mesa.isEmpty()) {
			return ResponseEntity.ok().body(mesa.get());
		} else {
			throw new ObjectNotFoundException("Mesa não encontrada");
		}
		
	}
	@GetMapping
	public ResponseEntity<List<Mesa>> getNumero(
			@RequestParam(value = "numero", required = false)Long numero)
	{
		if(numero != null) {
			List<Mesa> lista = Arrays.asList();
			Optional<Mesa> numMesa = mesaService.getNumero(numero);
			if(numMesa.isPresent()) {
				lista.add(numMesa.get());
			}
			return ResponseEntity.ok().body(lista);
		}
		else {
			List<Mesa> mesa = mesaService.getAll();
			return ResponseEntity.ok().body(mesa);
		}	
	}
	
	@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Mesa> insert(Mesa mesa,
				@RequestParam(value = "numero")Long numero){
		Optional<Mesa> numeroMesa = mesaService.getNumero(numero);
			logger.info("Mesa======"+mesa.getNumero().toString());
			if(numeroMesa.isEmpty()) {
				Mesa numMesa = mesaService.insert(mesa);
				return ResponseEntity.created(null).body(numMesa);
				}
			else {
				throw new ObjectNotFoundException(mesa.getNumero());
			}
		}

	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public Messege atualizaMesa(
			@PathVariable Long numero){
		if (numero != null) {
			Optional<Mesa> mesa = mesaService.getNumero(numero);
			mesa.get().setId(numero);
			mesaService.update(mesa.get());
			return new Messege("OK", "MESA ALTERADA COM SUCESSO!");
		}
		else {
			return new Messege("Erro", "Não existe essa Mesa");
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Messege> delete(@PathVariable Long numero) {
		Messege mesa = mesaService.delete(numero);
		return ResponseEntity.ok().body(mesa);
	}
	
}
