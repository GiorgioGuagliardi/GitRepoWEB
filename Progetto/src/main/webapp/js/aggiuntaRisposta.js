function Risposta(numeroRisposta, idEsercitazione, risposta){
	this.numeroRisposta = numeroRisposta;
	this.idEsercitazione = idEsercitazione;
	this.risposta = risposta;
}

function aggiunta(){
	var numeroRisposta = document.getElementById("numeroRisposta").value;
	var idEsercitazione = document.getElementById("esercitazione").value;
	var risposta = document.getElementById("risposta").value;
	
	var risp = new Risposta(numeroRisposta, idEsercitazione, risposta);
	
	$.ajax({
					  url: "ServizioAggiuntaRisposta",  
			          method: "POST",	         
			          data: JSON.stringify(risp),	       
			          contentType: "application/json",	         
			          success: function(risposta){				  									
						if(risposta=="success"){
							location.reload();
						}					
						if(risposta=="error"){
							window.location.replace("/index");						
						} 									
			          },	            	  
			    });
}