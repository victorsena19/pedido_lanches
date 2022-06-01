package com.pedido_lanches.Resourse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResourse {
	
	private PedidoService pedidoService;

}
