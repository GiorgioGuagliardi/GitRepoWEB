var profile;

function accessoGoogle(googleUser){
   
		  profile = googleUser.getBasicProfile();
//        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
//        console.log('Full Name: ' + profile.getName());
//        console.log('Given Name: ' + profile.getGivenName());
//        console.log('Family Name: ' + profile.getFamilyName());
//        console.log("Image URL: " + profile.getImageUrl());
//        console.log("Email: " + profile.getEmail());
    //		var btn=document.getElementById("logginGoogle").click();	
		
		
}

 
function logoutSocial(){
	// logout google
	gapi.auth2.getAuthInstance().signOut().then(function(){
		console.log('user logout')
	})
	
}

function Utente (email, nome, cognome,username, password, permessi){
	this.email=email;
	this.nome=nome;
	this.cognome=cognome;
	this.username=username;
	this.password=password;
	this.permessi=permessi;
}


function ricarica(){
    
    var nome= profile.getGivenName();
    var cognome= profile.getFamilyName();
    var email= profile.getEmail();
	
	var utente= new Utente(email,nome,cognome,email,false,0);
	
	$.ajax({
			  url: "loginSocial",  
	          method: "POST",	          
	          data: JSON.stringify(utente),	          
	          contentType: "application/json",	          
	          success: function(risposta){
	         	if(risposta=="success"){
					location.reload();
				}					        	          
			  },	          
	          fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
	          }        
	    });	

}