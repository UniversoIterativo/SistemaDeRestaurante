package br.com.administracao.service;

public interface ImpressaoSERVICE {

	public void listaDeComprasAlimentos();
	public void listaDeComprasHortFrutti();
	public void listaDeComprasAcougue();
	
	public void imprimirConta(String conta);
	public void imprimirItensLastPedido();
	public void fechamentoDoCaixaDiario();
	
}
