package com.sopadeletras.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sopadeletras.model.palabra;

public class palabraDAO implements DAOinterface<palabra, Integer>{
	
	private EntityManager manager;

	public palabraDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
	}
	
	@Override
	public void create(palabra e) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(e);
		manager.getTransaction().commit();
	}

	@Override
	public palabra read(Integer d) {
		// TODO Auto-generated method stub
		return manager.find(palabra.class, d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<palabra> findAll() {
		// TODO Auto-generated method stub
		return (List<palabra>) manager.createQuery("FROM palabra").getResultList();
	}

	@Override
	public void update(Integer e) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(e);
		manager.getTransaction().commit();
		
	}

	@Override
	public void delete(Integer e) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(e);
		manager.getTransaction().commit();
	}
	


}
