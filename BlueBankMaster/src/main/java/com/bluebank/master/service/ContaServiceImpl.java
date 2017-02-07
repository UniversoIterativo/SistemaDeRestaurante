package com.bluebank.master.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.master.dao.ContaDAO;
import com.bluebank.master.model.Conta;

@Service
public class ContaServiceImpl implements ContaService {
	
	private ContaDAO contaDAO;

	public void setContaDAO(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

	@Override
	@Transactional
	public void addConta(Conta c) {
		this.contaDAO.addConta(c);
	}

	@Override
	@Transactional
	public void updateConta(Conta c) {
		this.contaDAO.updateConta(c);
	}

	@Override
	@Transactional
	public List<Conta> listContas() {
		return this.contaDAO.listContas();
	}

	@Override
	@Transactional
	public Conta getContaById(int id) {
		return this.contaDAO.getContaById(id);
	}

	@Override
	@Transactional
	public void removeConta(int id) {
		this.contaDAO.removeConta(id);
	}

	@Override
	public Conta getContaByAgenciaNumero(Conta conta) {
		conta = this.contaDAO.getContaByAgenciaNumero(conta);
		return conta;
	}
	
	@Override
	public Conta getContaByAgenciaNumeroCPF(Conta conta) {
		conta = this.contaDAO.getContaByAgenciaNumeroCPF(conta);
		return conta;
	}

}
