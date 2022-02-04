function SchedaEsercitazione(idEsercitazione, urlImmagine){
	this.idEsercitazione = idEsercitazione;
	this.urlImmagine = urlImmagine;
}

function aggiunta(){
	var id = document.getElementById("id").value;
	var url = document.getElementById("urlImmagine").value;
	
	var schedaEsercitazione = new SchedaEsercitazione(id, url);
	
	$.ajax({
					  url: "ServizioAggiungiEsercitazione",  
			          method: "POST",	         
			          data: JSON.stringify(schedaEsercitazione),	       
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