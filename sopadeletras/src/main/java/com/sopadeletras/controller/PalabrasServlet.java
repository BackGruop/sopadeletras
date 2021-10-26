package com.sopadeletras.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopadeletras.dao.palabraDAO;
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
		//Datos desde la bbdd
		
		
		/*palabrasDAOMysql palabrasBBDD= new palabrasDAOMysql();
		List<palabra> palabras = palabrasBBDD.findall();
		
		//Vista
		request.setAttribute("palabras", palabras);
		request.getRequestDispatcher("palabra.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
