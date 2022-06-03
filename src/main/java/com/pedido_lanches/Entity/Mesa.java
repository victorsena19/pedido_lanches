package com.pedido_lanches.Entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	
	@OneToMany(mappedBy = "mesa")
	private List<Pedido> pedido;
	
	public Mesa() {}

	public Mesa(Long id, int numero, List<Pedido> pedido) {
		super();
		this.pedido = pedido;
		this.id = id;
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}

	public void ListId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void ListNumero(int numero) {
		this.numero = numero;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void ListPedido(List<Pedido> pedido) {
		this.pedido = pedido;
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
		Mesa other = (Mesa) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
