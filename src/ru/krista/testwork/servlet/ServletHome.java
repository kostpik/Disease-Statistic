package ru.krista.testwork.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.krista.testwork.servlet.dao.DBUtils;
import ru.krista.testwork.servlet.dao.SettingsConn;
import ru.krista.testwork.servlet.model.EntityForResponse;

/**
 * Servlet implementation class ServletHome
 */
@WebServlet("/home")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) das is fantastic
	 */
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
               req.getRequestDispatcher("WEB-INF/page/statistic.html").forward(req, resp);
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
