package br.com.exemploAutenticacao.login.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemploAutenticacao.bd.conexao.Conexao;
import br.com.exemploAutenticacao.jdbc.JDBCSenhaDAO;
import br.com.exemploAutenticacao.objetos.Usuario;
import br.com.exemploAutenticacao.senha.senha;

public class validaSenhaLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public validaSenhaLogin(){
		super();		
	}	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Veio por get");
		process(request,response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Veio por post");
		process(request,response);
		
	}
	// add uma rotina para expirar após um determinado tempo...
	
	private void process(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
		
		Usuario usuario = new Usuario();				
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));			
		
		// senha:123
		// login:Fe94
		
		senha senha = new senha();
		String retorno = senha.preparaSenha(usuario);
		usuario.setSenha(retorno);
		Conexao conec = new Conexao();		
		
		Connection conexao = conec.abrirConexao();
		JDBCSenhaDAO jdbcSenha = new JDBCSenhaDAO(conexao);		
		Usuario autenticado = jdbcSenha.validaUsuario(usuario);
		String teste = autenticado.getSenha();
		conec.fecharConexao(); 
		boolean valida = retorno.equals(teste);
		
		if(valida) {
			
			request.setAttribute("usuario",usuario.getUsuario());
			
		}else {
			
			request.setAttribute("usuario","usuario não autenticado");
		};
		 
		
	}	
}
		














		

