package ru.krista.testwork.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.krista.testwork.servlet.dao.DBUtils;
import ru.krista.testwork.servlet.dao.SettingsConn;

@WebServlet(urlPatterns="/startData")
public class ServletDataDefault extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDataDefault() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn =(Connection) req.getAttribute("CONN");
		if (conn == null) {
			
			
			conn = SettingsConn.getMySQLConnDefault();//данные из класса
			req.setAttribute("CONN",conn);
			}
		      String lastDate = req.getParameter("lastDate");
		      if(lastDate != null || "".equalsIgnoreCase(lastDate)) {
		           if(lastDate.equals("OK")) {
	                    String month= DBUtils.getLastMonth(conn);
	                    String json = "{ lastMonth : " + month + " }";
	  	                resp.setCharacterEncoding("UTF-8"); 
		                resp.setContentType("application/json");
	                    resp.getWriter().write(json);
		               }
		      } else {
			    resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write("<p>”казаны не правильные параметы</p>");
				System.out.println("Ќе правильные параметры");
	     }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
