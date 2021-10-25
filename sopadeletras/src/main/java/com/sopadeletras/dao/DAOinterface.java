package com.sopadeletras.dao;

import java.util.List;

public interface DAOinterface <T, K> {
	
	void create(T e);
	
	T read(K e);
	
	List<T> findAll();
	
	void update(K e);
	
	void delete(K d);
	

}
