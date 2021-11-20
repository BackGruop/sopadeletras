package com.sopadeletras.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopadeletras.dao.palabraDAO;
import com.sopadeletras.dao.partidaDAO;
import com.sopadeletras.model.Partida;
import com.sopadeletras.model.palabra;

/**
 * Servlet implementation class PalabrasServlet
 */
@WebServlet("/palabras")
public class PalabrasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PalabrasServlet() {
         // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Obtenemos Datos desde la bbdd
		
		palabraDAO palabrasBBDD= new palabraDAO();
		List<palabra> todasPalabras = palabrasBBDD.findAll();
		
		/*List<palabra> listaPalabras = new ArrayList<palabra>();
		
		String [] pruebas = {"prueba", "pru2", "pru3"};*/
		
		//Mandamos lista de palabras a la Vista
		request.setAttribute("listaPalabras", todasPalabras);
		request.getRequestDispatcher("palabras.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
