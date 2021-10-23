package com.sopadeletras.dao;

import java.util.List;

import com.sopadeletras.model.palabra;

public interface palabraDAO {
	
	List<palabra> findall();
	palabra findbyId();
	

}
