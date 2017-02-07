package com.bluebank.master.dao;

import java.util.List;

import com.bluebank.master.model.Conta;

public interface ContaDAO {

	public void addConta(Conta c);
	public void updateConta(Conta c);
	public List<Conta> listContas();
	public Conta getContaById(int id);
	public void removeConta(int id);
	public Conta getContaByAgenciaNumero(Conta conta);
	public Conta getContaByAgenciaNumeroCPF(Conta conta);

}
