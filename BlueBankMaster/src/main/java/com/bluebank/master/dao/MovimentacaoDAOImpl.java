package com.bluebank.master.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bluebank.master.model.Conta;
import com.bluebank.master.model.Movimentacao;

@Repository
public class MovimentacaoDAOImpl implements MovimentacaoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MovimentacaoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addMovimentacao(Movimentacao m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
		logger.info("Movimentacao saved successfully, Movimentacao Details="+m);
	}

	@Override
	public void updateMovimentacao(Movimentacao m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(m);
		logger.info("Movimentacao updated successfully, Movimentacao Details="+m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movimentacao> listMovimentacoes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Movimentacao> movimentacoesList = session.createQuery("from Movimentacao").list();
		for(Movimentacao m : movimentacoesList){
			logger.info("Movimentacoes List::"+m);
		}
		return movimentacoesList;
	}

	@Override
	public Movimentacao getMovimentacaoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Movimentacao m = (Movimentacao) session.load(Movimentacao.class, new Integer(id));
		logger.info("Movimentacao loaded successfully, Movimentacao details="+m);
		return m;
	}

	@Override
	public void removeMovimentacao(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Movimentacao m = (Movimentacao) session.load(Movimentacao.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Movimentacao deleted successfully, person details="+m);
	}
	
	@Override
	public void transferir(Movimentacao d, Movimentacao c) {
		Session session = this.sessionFactory.getCurrentSession();
		// Busca a conta de origem e seta o novo saldo
		Conta origem = d.getConta();
		BigDecimal saldoOrigem = origem.getSaldo();
		BigDecimal debitar = d.getValor();
		saldoOrigem = saldoOrigem.subtract(debitar);
		// Busca a conta de origem e seta o novo saldo
		Conta destino = c.getConta();
		BigDecimal saldoDestino = origem.getSaldo();
		BigDecimal creditar = c.getValor();
		saldoDestino = saldoDestino.subtract(creditar);
		
		// "Comita" as transições
		session.getTransaction().begin();
		session.persist(d);
		session.persist(origem);
		session.persist(c);
		session.persist(destino);
		session.getTransaction().commit();
		session.close();
		logger.info("Movimentacao deleted successfully, person details=");
	}

	
}
