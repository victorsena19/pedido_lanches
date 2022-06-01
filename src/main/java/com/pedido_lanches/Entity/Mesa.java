package com.pedido_lanches.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private int numero;
	
	@OneToOne(mappedBy = "mesa", cascade = CascadeType.ALL)
	private Pedido pedido;
	
	public Mesa() {}

	public Mesa(Long id, int numero, Pedido pedido) {
		super();
		this.pedido = pedido;
		this.id = id;
		this.numero = numero;
	}
	
	

	public Pedido getPedido() {
		return pedido;
	}

	public Pedido setPedido() {
		return pedido;
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
