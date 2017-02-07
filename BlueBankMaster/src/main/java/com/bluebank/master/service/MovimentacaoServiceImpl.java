package com.bluebank.master.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.master.dao.MovimentacaoDAO;
import com.bluebank.master.model.Movimentacao;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
	
	private MovimentacaoDAO movimentacaoDAO;

	public void setMovimentacaoDAO(MovimentacaoDAO movimentacaoDAO) {
		this.movimentacaoDAO = movimentacaoDAO;
	}
	
	@Override
	@Transactional
	public void addMovimentacao(Movimentacao m) {
		this.movimentacaoDAO.addMovimentacao(m);
	}

	@Override
	@Transactional
	public void updateMovimentacao(Movimentacao m) {
		this.movimentacaoDAO.updateMovimentacao(m);
	}

	@Override
	@Transactional
	public List<Movimentacao> listMovimentacoes() {
		return this.movimentacaoDAO.listMovimentacoes();
	}

	@Override
	@Transactional
	public Movimentacao getMovimentacaoById(int id) {
		return this.movimentacaoDAO.getMovimentacaoById(id);
	}

	@Override
	@Transactional
	public void removeMovimentacao(int id) {
		this.movimentacaoDAO.removeMovimentacao(id);
	}

	@Override
	public void transferir(Movimentacao d, Movimentacao c) {
		this.movimentacaoDAO.transferir(d, c);		
	}

}
