package com.pedido_lanches.Seed;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedido_lanches.Entity.Categoria;
import com.pedido_lanches.Entity.Mesa;
import com.pedido_lanches.Entity.Pagamento;
import com.pedido_lanches.Entity.Pedido;
import com.pedido_lanches.Entity.Produto;
import com.pedido_lanches.Entity.StatusPedido;
import com.pedido_lanches.Repository.CategoriaRepository;
import com.pedido_lanches.Repository.MesaRepository;
import com.pedido_lanches.Repository.PagamentoRepository;
import com.pedido_lanches.Repository.PedidoRepository;
import com.pedido_lanches.Repository.ProdutoRepository;
import com.pedido_lanches.Repository.StatusPedidoRepository;

@Configuration
@Profile("test")
public class addDados implements CommandLineRunner {

	@Autowired
	MesaRepository mesaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	StatusPedidoRepository statusPedidoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PagamentoRepository pagamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		Mesa m1 = new Mesa(null, 1);
		mesaRepository.save(m1);
		
		Pagamento pg1 = new Pagamento(null, Instant.parse("2022-06-09T09:23:07Z"));
		pagamentoRepository.saveAll(Arrays.asList(pg1));

		StatusPedido st1 = new StatusPedido(null, "Pago");
		statusPedidoRepository.saveAll(Arrays.asList(st1));

		Categoria cat1 = new Categoria(null, "Lanches");
		Categoria cat2 = new Categoria(null, "Bebidas");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		Produto p1 = new Produto(null, "X Salada", "Pão, Hambuerguer, Alface, Presunto e Queijo", 12.50, null, cat1, null);
		Produto p2 = new Produto(null, "X Egg", "Pão, Hambuerguer, Ovo, Presunto e Queijo", 13.00, null, cat1, null);
		Produto p3 = new Produto(null, "Coca-lata", "Refrigerante de 350 ML", 5.00, null, cat2, null);
		Produto p4 = new Produto(null, "Coca 1 litro", "Refrigerante de 1 litro", 7.00, null, cat2, null);

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		//Com Variavel
		//List<Produto> p0 = Arrays.asList(p1, p2);

		Pedido pp1 = new Pedido(null, 1, Instant.parse("2022-06-09T09:23:07Z"), 50.20, m1, Arrays.asList(p1, p2), st1, pg1);
		pedidoRepository.saveAll(Arrays.asList(pp1));

	}
}
