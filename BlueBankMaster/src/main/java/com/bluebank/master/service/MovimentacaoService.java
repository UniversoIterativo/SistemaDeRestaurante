package com.bluebank.master.service;

import java.util.List;

import com.bluebank.master.model.Movimentacao;

public interface MovimentacaoService {

	public void addMovimentacao(Movimentacao m);
	public void updateMovimentacao(Movimentacao m);
	public List<Movimentacao> listMovimentacoes();
	public Movimentacao getMovimentacaoById(int id);
	public void removeMovimentacao(int id);
	public void transferir(Movimentacao d, Movimentacao c); 
}
