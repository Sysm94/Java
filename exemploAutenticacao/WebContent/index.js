$( document ).ready(function() {
    
	
	ValidaSenha =function(){		
		
		var msg="";
		var login=$("#usuario").val();
		var senha=$("#senha").val()
		
		if(login=="" || login=="null" || login==undefined){
			msg+=("digite um login valido.");
		};
		
		if(senha=="" || senha=="null" || senha==undefined){
			msg+=("digite uma senha valida.");
		};
		
		if(msg!=""){			
			alert(msg);
			
		}else{
			
			var usuario = "usuario="+login+"&senha="+btoa(senha); // convert a senha digitada em base64			
			envialogin(usuario);
		};				
	};
	
	envialogin=function(usuario){	
		
		$.ajax({
			type:"Post",
			url:"validaSenhaLogin",
			data:usuario,
			success: function(msg){
				window.location.replace(msg.msg);
			
			},
			error: function(err){				
				alert("Erro:"+err.msg);
			}			
		});	
	};
});