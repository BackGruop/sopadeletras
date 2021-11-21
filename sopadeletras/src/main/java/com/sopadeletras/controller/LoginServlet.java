package com.sopadeletras.controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void autentificacionLDAP(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException{
    	    	
    	    	final String SUCCESS = "/palabras";
    	    	final String FAILURE = "/denegado";
    	    	String strUrl = "inicio.jsp";
    	    	String username = request.getParameter("nombre");
    	    	String password = request.getParameter("contrasena");
    	    	
    	    	Hashtable<String, String> env = new Hashtable<>();
    	    	boolean autentificado = false;
    	    	
    	    	//Parametros para la conexion LDAP
    	    	env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    	    	env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
    	    	env.put(Context.SECURITY_AUTHENTICATION, "simple");
    	    	env.put(Context.SECURITY_PRINCIPAL, "uid=" + username +", ou=users, ou=system");
    	    	env.put(Context.SECURITY_CREDENTIALS, password);
    	    	try {
    	    		//Contexto inicial
    	    		DirContext ctx = new InitialDirContext(env);
    	    		
    	    		autentificado = true;
    	    		ctx.close();
    	    	} catch (NamingException e) {
    	    		autentificado = false;
    	    	}finally {
    	    		if (autentificado) {
    	    			System.out.print("Acceso a palabras.jsp");
    	    			strUrl = SUCCESS;
    	    			HttpSession session=request.getSession();
    	    			String Username = username.toUpperCase();
      			      	session.setAttribute("nombre",Username);
      			      	
    	    		}else {
    	    			System.out.print("Acceso a denegado.jsp");
    	    			strUrl = FAILURE;
    	    		}
    	    	}
    	    	//ENVIAMOS A Vista CORRESPONDIENTE
    	    	RequestDispatcher rd = request.getRequestDispatcher(strUrl);    	
    	    	rd.forward(request, response);
    	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		autentificacionLDAP(request, response);
	}

}
