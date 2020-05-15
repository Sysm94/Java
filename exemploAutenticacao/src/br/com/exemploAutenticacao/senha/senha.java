package br.com.exemploAutenticacao.senha;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.exemploAutenticacao.objetos.Usuario;

public class senha  {	
	
	public senha( ){}
	
	public String preparaSenha(Usuario usuario) {
		
		String senha = usuario.getSenha();
		senha=encriptSenha(senha);
		
		return senha;		
	}	
	
	private String  encriptSenha (String senha){
		
		String SenhaMd5B16="teste";  
		
		try {
			 
		    MessageDigest algoritmo = MessageDigest.getInstance("MD5");
		    senha=addSalt(senha);	    
		    System.out.println("Senha Com o salt: "+senha);
		    
		    byte[] txtconvertido = senha.getBytes(StandardCharsets.UTF_8); 		// Convertendo o texto em bytes.
		    algoritmo.update(txtconvertido);									// enviando os bytes para serem criptografados;
		    
		    byte [] arrayByte=algoritmo.digest(); 								// retorna uma cadeia de bytes;
		    BigInteger numInteiros = new BigInteger(1,arrayByte); 				// transforma o array de bytes e um bigint	 
		    SenhaMd5B16 = numInteiros.toString(16); 							// transforma o numInteiros em hexadecimal			    
	    
	    // Essa exceção é lançada quando um algoritmo criptográfico específico é solicitado, mas não está disponível no ambiente.
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
		return SenhaMd5B16;
	
	}// fim do método encriptSenha**************************
	
	
	private String addSalt(String Senha) {
				
		if(Senha.length()<=7){
			
			Senha+="S.a.L.t.heineken#MD5&64%";	
			
		}else {
			
			Senha +="#SaltMd5base64#heineken";			
		
		};		
		
		return Senha;
		
	}// fim do método addSalt******************************	
}
