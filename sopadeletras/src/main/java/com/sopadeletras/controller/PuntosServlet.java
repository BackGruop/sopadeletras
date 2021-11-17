package com.sopadeletras.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PuntosServlet")
public class PuntosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*String userName = request.getParameter("userName").trim();
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}*/
		int time = Integer.parseInt(request.getParameter("tiempo"));
		String calificacion = null;
		
		if (time <=60) {
			calificacion = "Ultra veloz!!";
			} else if (time <= 120) {
			calificacion = "Has sido muy rapido: ";
			}else if (time <= 180) {
				calificacion = "Muy bien: ";
			}else if (time <= 240) {
				calificacion = "No esta mal: ";
			}else if (time <= 300) {
				calificacion = "Un poco lento: ";
		}
		
		
		response.setContentType("text/plain");
		response.getWriter().write(calificacion+(String.valueOf(time))+ " segundos");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
