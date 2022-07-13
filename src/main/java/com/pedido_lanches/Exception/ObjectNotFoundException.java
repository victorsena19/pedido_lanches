package com.pedido_lanches.Exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (Object nome) {
		super("Esta "+nome+" já existe");
	}

}
