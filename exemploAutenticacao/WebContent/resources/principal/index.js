$( document ).ready(function() {

Sairdasessao=function(){
	var login = "sair";
	var usuario = "usuario="+login;
	
	alert("vai caralho");
		$.ajax({
			type:"Post",
			url:"validaSenhaLogin",
			data:usuario,
			success: function(msg){
				window.location.replace(msg.msg);
			
			},
			error: function(msg){				
				alert("Erro:"+err.msg);
			}			
		});	
	};
	
});	