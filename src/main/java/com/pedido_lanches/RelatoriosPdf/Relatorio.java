package com.pedido_lanches.RelatoriosPdf;

public interface Relatorio {
	
	public void gerarCabecario();
	public void gerarCorpo();
	public void gerarRodape();
	public void imprimir();
	
}
