package com.sopadeletras.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partida")
public class Partida implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="jugador")
	String jugador;
	@Column(name="puntaje")
	int puntaje;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpartida")
	int idpartida;

	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Partida() {
		// TODO Auto-generated constructor stub
	}

}
