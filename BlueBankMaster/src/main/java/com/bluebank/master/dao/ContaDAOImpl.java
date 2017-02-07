package com.bluebank.master.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bluebank.master.model.Conta;

@Repository
public class ContaDAOImpl implements ContaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ContaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addConta(Conta c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Conta saved successfully, Conta Details="+c);
	}

	@Override
	public void updateConta(Conta c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Conta updated successfully, Conta Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> listContas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Conta> contasList = session.createQuery("from Conta").list();
		for(Conta c : contasList){
			logger.info("Conta List::"+c);
		}
		return contasList;
	}

	@Override
	public Conta getContaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Conta c = (Conta) session.load(Conta.class, new Integer(id));
		logger.info("Conta loaded successfully, Conta details="+c);
		return c;
	}
	
	@Override
	public void removeConta(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Conta c = (Conta) session.load(Conta.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Conta deleted successfully, person details="+c);
	}

	@Override
	public Conta getContaByAgenciaNumero(Conta conta) {
		Session session = this.sessionFactory.openSession();	
		String hql = "FROM Conta C WHERE C.numero = :numero AND C.agencia = :agencia";
		Query query = session.createQuery(hql);
		query.setParameter("numero", conta.getNumero());
		query.setParameter("agencia", conta.getAgencia());
		Conta c = (Conta) query.uniqueResult();
		this.sessionFactory.close();
		logger.info("Conta loaded successfully, Conta details="+c);
		return c;
	}
	
	@Override
	public Conta getContaByAgenciaNumeroCPF(Conta conta) {
		Session session = this.sessionFactory.openSession();	
		String hql = "FROM Conta C WHERE C.numero = :numero AND C.cpf = :cpf AND C.agencia = :agencia";
		Query query = session.createQuery(hql);
		query.setParameter("numero", conta.getNumero());
		query.setParameter("cpf", conta.getCpf());
		query.setParameter("agencia", conta.getAgencia());
		Conta c = (Conta) query.uniqueResult();
		this.sessionFactory.close();
		logger.info("Conta loaded successfully, Conta details="+c);
		return c;
	}

}
