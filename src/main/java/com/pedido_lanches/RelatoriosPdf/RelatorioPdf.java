package com.pedido_lanches.RelatoriosPdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.pedido_lanches.Entity.Pedido;

public class RelatorioPdf implements Relatorio{

	private Pedido pedido;
	private Document documentoPdf;
	
	public RelatorioPdf(Pedido pedido) {
		this.pedido = pedido;
		this.documentoPdf = new Document();
		PdfWriter.getInstance(this.documentoPdf, null);
}
	
	@Override
	public void gerarCabecario() {
		Paragraph paragrafoTitulo = new Paragraph();
		paragrafoTitulo.setAlignment(Element.ALIGN_CENTER);
		paragrafoTitulo.add(new Chunk("Relatorio de Pedido", new Font(Font.HELVETICA, 30)));
		this.documentoPdf.add(paragrafoTitulo);
		this.documentoPdf.add(new Paragraph(""));
		Paragraph paragrafoData = new Paragraph();
		paragrafoData.setAlignment(Element.ALIGN_CENTER);
		paragrafoData.add(new Chunk(this.pedido.getMomentoPedido().toString()));
		this.documentoPdf.add(paragrafoData);
	}

	@Override
	public void gerarCorpo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gerarRodape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		
	}
	

}
