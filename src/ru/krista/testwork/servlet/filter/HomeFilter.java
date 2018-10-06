package ru.krista.testwork.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
//@WebFilter(urlPatterns="/*")
public class HomeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Работаем HomeFilter");
	      HttpServletRequest req = (HttpServletRequest)request;
		 req.getRequestDispatcher("WEB-INF/page/statistic.html").forward(request, response);
		//System.out.println("Работаем перед chain HomeFilter");
//		 chain.doFilter(request, response);
//		 System.out.println("Работаем после до chain HomeFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
