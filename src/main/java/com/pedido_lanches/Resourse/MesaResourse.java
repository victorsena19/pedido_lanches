package com.pedido_lanches.Resourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Entity.Mesa;
import com.pedido_lanches.Service.MesaService;

@RestController
@RequestMapping(value = "/mesas")
public class MesaResourse {
	
	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Mesa>> getNumeroId(
			@RequestParam(value = "numero", required = false)Integer numero,
			@RequestParam(value = "id", required = false)Long id)
	{
		if(numero !=null) {
			List<Mesa> mesa = mesaService.getNumero(numero);
			return ResponseEntity.ok().body(mesa);
		}else if(id != null) {
			List<Mesa> mesa = mesaService.getId(id);
			return ResponseEntity.ok().body(mesa);
		}
		else {
			List<Mesa> mesa = mesaService.getAll();
			return ResponseEntity.ok().body(mesa);
		}
		
	}
}
