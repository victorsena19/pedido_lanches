package com.pedido_lanches.Resourse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido_lanches.Service.StatusPedidoService;

@RestController
@RequestMapping(value = "/statuspedidos")
public class StatusPedidoResourse {

		private StatusPedidoService statusPedidoService;
}
