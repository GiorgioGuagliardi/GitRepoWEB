function SchedaEsercitazione(idEsercitazione, urlImmagine){
	this.idEsercitazione = idEsercitazione;
	this.urlImmagine = urlImmagine;
}

function modifica(){
	var id = document.getElementById("id").value;
	var urlImmagine = document.getElementById("urlImmagine").value;
	
	var schedaEsercitazione = new SchedaEsercitazione(id, urlImmagine);
	
	alert(id);
	alert(urlImmagine);
	
	$.ajax({
					  url: "ServizioModificaEsercitazione",  
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

function elimina(){
	var id = document.getElementById("id").value;
	var urlImmagine = document.getElementById("urlImmagine").value;
	
	var schedaEsercitazione = new SchedaEsercitazione(id, urlImmagine);
	
	$.ajax({
					  url: "ServizioEliminaEsercitazione",  
			          method: "POST",	         
			          data: JSON.stringify(schedaEsercitazione),	       
			          contentType: "application/json",	         
			          success: function(risposta){				  									
						if(risposta=="success"){
							window.location.replace("/index");
						}					
						if(risposta=="error"){
							location.reload();						
						} 									
			          },	            	  
			    });
}