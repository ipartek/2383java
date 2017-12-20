package com.ipartek.MVCompleto.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.MVCompleto.domain.Cd;
import com.ipartek.MVCompleto.repository.CdDAO;

@Repository
public class CdDAOImpl implements CdDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private EntityManager getEntityManager() {
		return sessionFactory.getCurrentSession().getEntityManagerFactory().createEntityManager();
	}

	@Transactional(readOnly=true)
	public List<Cd> getCds() {
		EntityManager em = getEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Cd> criteria = builder.createQuery(Cd.class);
		
		Root<Cd> root = criteria.from(Cd.class);
		
		criteria.select(root);
		
		return em.createQuery(criteria).getResultList();
	}

	@Transactional(readOnly=false)
	public void addCd(Cd cd) {
		EntityManager em = getEntityManager();
		
		em.persist(cd);
	}
	
}
