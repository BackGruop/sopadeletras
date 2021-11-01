package com.sopadeletras.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="palabra")
public class palabra implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="palabra")
	String palabras;
	
	@Id
	@Column(name= "idpalabra")
	int id;
	
	//Constructor con campos
	public palabra(String palabras, int id) {
		super();
		this.palabras = palabras;
		this.id = id;
	}
	
	//Get y Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras = palabras;
	}

	public palabra() {
		// TODO Auto-generated constructor stub
	}
	
	//To String
	@Override
	public String toString() {
		return "palabra [palabras=" + palabras + ", id=" + id + "]";
	}

}
