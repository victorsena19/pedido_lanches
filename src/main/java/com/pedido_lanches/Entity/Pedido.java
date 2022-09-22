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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id")
	private Long id;
	
	@JoinColumn(name = "num_pedido")
	private Integer numPedido;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Porto_Velho")
	@JoinColumn(name = "momento_pedido")
	private Instant momentoPedido;
	
	@JoinColumn(name = "total_pedido")
	private Double totalPedido;
	
	@JoinColumn(name = "quantidade")
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "numero_mesa")
	private Mesa mesa;
	
	@ManyToOne
	@JoinColumn(name = "status_pedido_id")
	private StatusPedido statusPedido;

	@ManyToOne
	@JoinColumn(name = "pagamento_id")
	private Pagamento pagamento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pedido")
	List<PedidoProduto> pedidoProduto;
	
	public Pedido() {
	}

	public Pedido(Long id, Integer numPedido, Instant momentoPedido, Double totalPedido, Integer quantidade, Mesa mesa,
			StatusPedido statusPedido, Pagamento pagamento, List<PedidoProduto> pedidoProduto) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.momentoPedido = momentoPedido;
		this.mesa = mesa;
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
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Pagamento getPagamento() {
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
