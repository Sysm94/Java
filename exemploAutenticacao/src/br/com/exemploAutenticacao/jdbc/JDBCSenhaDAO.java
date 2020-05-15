package br.com.exemploAutenticacao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.exemploAutenticacao.objetos.Usuario;

public class JDBCSenhaDAO {

private Connection conexao;
	
	public JDBCSenhaDAO(Connection conexao){ 
		this.conexao = conexao;		
	}

public Usuario validaUsuario(Usuario usuario){		
				
		String comando = "select id,usuario,senha from usuario where usuario='"+usuario.getUsuario()+"' and senha='"+usuario.getSenha()+"'";
		Usuario login = null;
		try {
			
		java.sql.Statement stmt =conexao.createStatement();
		ResultSet rs = stmt.executeQuery(comando);
		
		
		if(rs.next()){
			login= new Usuario();			
			login.setId(rs.getInt("id"));		
			login.setUsuario(rs.getString("usuario"));
			login.setSenha(rs.getString("senha"));
		}
			
		}catch (SQLException e){
			e.printStackTrace();			
		}	
	
		return login;	
	}
}
