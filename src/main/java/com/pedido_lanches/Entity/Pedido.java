package com.pedido_lanches.Entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numPedido;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Porto_Velho")
	private Instant momentoPedido;
	private Double totalPedido;
	
	@ManyToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;
	
	@ManyToMany
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), 
	inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produto;
	
	@OneToOne
	@JoinColumn(name = "status_pedido_id")
	private StatusPedido statusPedido;
	
	@ManyToOne
	@JoinColumn(name = "pagamento_id")
	private Pagamento pagamento;
	
	public Pedido() {}

	public Pedido(Long id, Integer numPedido, Instant momentoPedido, Double totalPedido, Mesa mesa,
			List<Produto> produtos, StatusPedido statusPedido, Pagamento pagamento) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.momentoPedido = momentoPedido;
		this.totalPedido = totalPedido;
		this.mesa = mesa;
		this.produto = produtos;
		this.statusPedido = statusPedido;
		this.pagamento = pagamento;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}
	
	
	public Instant getMomentoPedido() {
		return momentoPedido;
	}

	public void setMomentoPedido(Instant momentoPedido) {
		this.momentoPedido = momentoPedido;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<Produto> getProdutos() {
		return produto;
	}
	
	public void setProdutos(List<Produto> produto) {
		this.produto = produto;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	public Pagamento getPagamento(){
		return pagamento;
	}
	
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
