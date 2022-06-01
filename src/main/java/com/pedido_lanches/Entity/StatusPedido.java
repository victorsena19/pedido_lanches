package com.pedido_lanches.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "status_pedidos")
public class StatusPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String pago;
	@Getter
	@Setter
	private String enviado;
	@Getter
	@Setter
	private String entregue;
	@Getter
	@Setter
	private String cancelado;
	
	public StatusPedido() {}

	public StatusPedido(Long id, String pago, String enviado, String entregue, String cancelado) {
		super();
		this.id = id;
		this.pago = pago;
		this.enviado = enviado;
		this.entregue = entregue;
		this.cancelado = cancelado;
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
		StatusPedido other = (StatusPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
