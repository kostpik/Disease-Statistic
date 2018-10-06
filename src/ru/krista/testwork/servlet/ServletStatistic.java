package ru.krista.testwork.servlet;

import java.util.List;
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

import ru.krista.testwork.servlet.dao.SettingsConn;
import ru.krista.testwork.servlet.dao.DBUtils;
import ru.krista.testwork.servlet.model.EntityForResponse;


@WebServlet(urlPatterns="/orderByDate")

public class ServletStatistic extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
	List<EntityForResponse> listEntity = null;
	
	Connection conn = (Connection) req.getAttribute("CONN");
	if (conn == null) {
		conn = SettingsConn.getMySQLConnDefault();   // данные для загрузки
		req.setAttribute("CONN",conn);                   
		}	
	String date = req.getParameter("orderByDate");
	if(date != null || "".equalsIgnoreCase(date)) {
		     String newDate = date.replace("/", "");       
			 listEntity = DBUtils.getReportByDate(conn, newDate);
			  if(listEntity.isEmpty()) {
				   resp.setContentType("text/html");
				   resp.setCharacterEncoding("UTF-8");
				   resp.getWriter().write("<p> Извините на данную дату нет данных </p>");
				   System.out.println("Извините на данную дату нет данных");
			  }

			 System.out.println("context_path:"+req.getContextPath());
			 Gson gson = new GsonBuilder().create();
			String json = gson.toJson(listEntity);
			System.out.println("json.toString():"+json.toString());	
			System.out.println("listEntity.toString():"+listEntity.toString());

			resp.setCharacterEncoding("UTF-8"); 
			resp.setContentType("application/json");
			resp.getWriter().write(json);
	}
	else {
		   resp.setContentType("text/html");
		   resp.setCharacterEncoding("UTF-8");
		   resp.getWriter().write("<p>Указаны не правильные параметы</p>");
		   System.out.println("Не правильные параметры");
	}
	
		
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


   }
}
