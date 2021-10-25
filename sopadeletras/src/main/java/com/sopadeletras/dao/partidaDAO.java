package com.sopadeletras.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sopadeletras.model.Partida;

public class partidaDAO implements DAOinterface<Partida, Integer> {

	private EntityManager manager;
	
	public partidaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
	}
	
	@Override
	public void create(Partida e) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(e);
		manager.getTransaction().commit();
		
	}

	@Override
	public Partida read(Integer d) {
		// TODO Auto-generated method stub
		return manager.find(Partida.class, d);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partida> findAll() {
		// TODO Auto-generated method stub
		return (List<Partida>) manager.createQuery("FROM partida").getResultList();
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
