window.addEventListener("load", function(){ //"load"-->al caricamento della pagina inizializziamo il form per effettuare login e sign up
	checklogin();
});

var modalLogin=true;

function  checklogin(){
	 
	$("#registrati").click(function() {	
		$("#first").fadeOut("fast", function() {
			$("#second").fadeIn("fast");
			modalLogin=false;
		});
	});
	
	$("#accedi").click(function() {
		$("#second").fadeOut("fast", function() {
			$("#first").fadeIn("fast");
			modalLogin=true;
		});
	});
}


function Utente (email, nome, cognome,username, password, permessi){
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
	this.username=username;
	this.password=password;
	this.permessi=permessi;
}

$(document).ready(function(){ 
	
	var Login = document.getElementById("loginForm");
		document.getElementById("btnLogin").addEventListener("submit", function () {
 	 	Login.submit();
	});
	
	var Registrazione = document.getElementById("formRegistrazione");
		document.getElementById("btnIscriviti").addEventListener("submit", function () {
 	 	Registrazione.submit();
	});
	

	
	$("#loginForm").on("submit", function(e){
		
		if(modalLogin){
			e.preventDefault();
			var email1 = document.getElementById("emailLogin").value;
			var password1 = document.getElementById("passwordLogin").value;
			
			var utente1= new Utente(email1,null,null,null,password1,null);
		
			$.ajax({
					  url: "Serviziologin",  
			          method: "POST",	         
			          data: JSON.stringify(utente1),	       
			          contentType: "application/json",	         
			          success: function(risposta){				  									
						if(risposta=="success"){
							location.reload();
						}					
						else if(risposta=="error"){
							alert("Utente non registrato");					
						} 
						else if (risposta=="nonRegistrato"){
							alert("Email o password errati");						
						}									
			          },	            	  
			    });	
		}
	});


	$("#formRegistrazione").on("submit", function(e){

		
		e.preventDefault();		
		var nome = document.getElementById("nome").value;
		var cognome = document.getElementById("cognome").value;
		var username = document.getElementById("username").value;
		var email2 = document.getElementById("email").value;
		var password2 = document.getElementById("password").value;
		
		
		
		var utente2= new Utente(email2,nome,cognome,username,password2,1);
		$.ajax({
				  url: "ServizioRegistrazione",  
		          method: "POST",	         
		          data: JSON.stringify(utente2),	       
		          contentType: "application/json",	         
		          success: function(risposta){				  									
					if(risposta=="success"){
						location.reload();
					}					
					if(risposta=="error"){
						alert("Registrazione non riuscita, riprova");					
					}									
		          },	            	  
		    });	
	});
	
	
	$("#chiudi").on("click", function(e){
		$('#recuperaPassword').modal('hide');	
	});
	
	
});