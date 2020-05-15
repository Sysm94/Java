package br.com.exemploAutenticacao.loginFiltro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroDeslogar
 */
public class FiltroDeslogar implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroDeslogar() {
        // TODO Auto-generated constructor stub
    }

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
		
		String sair = ((HttpServletRequest) request).getParameter("usuario");
		
		if(sair == null) {
			chain.doFilter(request, response);
		}else {
			if(sair.equals("sair")) {
		
			HttpSession sessao = ((HttpServletRequest) request).getSession();	
			sessao.invalidate();			
		
		}else {
			chain.doFilter(request, response);
		}
		
	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
