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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numPedido;
	private Instant momentoPedido;
	private Double totalPedido;
	@ManyToOne
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;
	@ManyToMany(mappedBy = "pedido")
	private List<Produto> produto;
	@OneToOne
	@JoinColumn(name = "pedido_Status_id")
	private StatusPedido statusPedido;
	
	
	
	public Pedido() {}

	public Pedido(Long id, int numPedido, Instant momentoPedido, Double totalPedido,Mesa mesa, 
			List<Produto> produto, StatusPedido statusPedido) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.momentoPedido = momentoPedido;
		this.totalPedido = totalPedido;
		this.mesa = mesa;
		this.produto = produto;
		this.statusPedido = statusPedido;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
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
