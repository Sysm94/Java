package br.com.exemploAutenticacao.loginFiltro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import jdk.nashorn.internal.codegen.MapCreator;

public class filtroLogin implements Filter {

 
    public filtroLogin() {}// construtor do filtro

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Map<String,String>msg = new HashMap<String,String>();
		
		
			
			chain.doFilter(request, response);		
			
			if(!request.getAttribute("usuario").equals("usuario não autenticado")){
				
				HttpSession sessao = ((HttpServletRequest) request).getSession();
				sessao.setAttribute("login",request.getParameter("usuario"));
				sessao.setMaxInactiveInterval(15);
				msg.put("msg", "resources/principal/index.html");	
				
			}else {
				
				msg.put("msg", "index.html");	
			};
		
		
		String json = new Gson().toJson(msg);
		((HttpServletResponse)response).setCharacterEncoding("UTF-8");
		response.setContentType("aplication/json");
		response.getWriter().write(json);	
		
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
