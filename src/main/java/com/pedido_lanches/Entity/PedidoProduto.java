package com.pedido_lanches.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", table = "pedido_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id", table = "pedido_produto")
	private Pedido pedido;
	
	@JoinColumn(name = "quantidade_produto")
	private Integer quantidadeProduto;
	
	@JoinColumn(name = "valor_unitario")
	private Double valorUnitario;
	
	@JoinColumn(name = "valor_total_produto")
	private Double valorTotalProduto;
	
	public PedidoProduto() {}
	
	public PedidoProduto(Long id, Produto produto, Pedido pedido, Integer quantidadeProduto,
			Double valorUnitario, Double valorTotalProduto) {
		super();
		this.id = id;
		this.produto = produto;
		this.pedido = pedido;
		this.quantidadeProduto = quantidadeProduto;
		this.valorUnitario = valorUnitario;
		this.valorTotalProduto = valorTotalProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotalProduto() {
		return valorTotalProduto;
	}

	public void setValorTotalProduto(Double valorTotalProduto) {
		this.valorTotalProduto = valorTotalProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoProduto other = (PedidoProduto) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
