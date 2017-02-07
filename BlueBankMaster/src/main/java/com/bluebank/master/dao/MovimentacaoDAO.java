package com.bluebank.master.dao;

import java.util.List;

import com.bluebank.master.model.Movimentacao;

public interface MovimentacaoDAO {

	public void addMovimentacao(Movimentacao m);
	public void updateMovimentacao(Movimentacao m);
	public List<Movimentacao> listMovimentacoes();
	public Movimentacao getMovimentacaoById(int id);
	public void removeMovimentacao(int id);
	public void transferir(Movimentacao d, Movimentacao c);
	
}
