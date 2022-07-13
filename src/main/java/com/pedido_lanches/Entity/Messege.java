package com.pedido_lanches.Entity;

import java.io.Serializable;

public class Messege implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private String status;
	private String mensagem;
	
	public Messege() {
	}
	
	public Messege(String status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	} 
}
