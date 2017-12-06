package br.edu.ctp.ads.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.edu.ctp.ads.entity.Passagem;

public class PassagemDAO {

	public void inserir(Passagem passagem) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		if (passagem.getId() == null) {
		em.persist(passagem);
		} else {
			em.merge(passagem);
		}
			
		em.getTransaction().commit();
	}

	public ArrayList<Passagem> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("from Passagem");

		return new ArrayList<Passagem>(q.getResultList());
	}

	public void excluir(Integer id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		Passagem passagem = em.find(Passagem.class, id);
		em.remove(passagem);
		em.getTransaction().commit();

	}

}
