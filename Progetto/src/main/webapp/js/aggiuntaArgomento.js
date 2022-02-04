function SchedaArgomento(id, idEsercitazione, macroargomento, visualizzazioni, urlImmagine, descrizione, titolo,  permessi){
	this.id = id;
	this.idEsercitazione = idEsercitazione;
	this.urlImmagine = urlImmagine;
	this.descrizione = descrizione;
	this.titolo = titolo;
	this.macroargomento = macroargomento;
	this.visualizzazioni = visualizzazioni;
	this.permessi = permessi;
}

function aggiunta(){
	var id = document.getElementById("id").value;
	var url = document.getElementById("urlImmagine").value;
	var macroargomento = document.getElementById("macroargomento").value;
	var descrizione = document.getElementById("descrizione").value;
	var titolo = document.getElementById("titolo").value;
	var permessi = document.getElementById("permessi").value;
	
	var schedaArgomento = new SchedaArgomento(id, id, macroargomento, 0, url, descrizione, titolo,  permessi);
	
	$.ajax({
					  url: "ServizioAggiuntaArgomento",  
			          method: "POST",	         
			          data: JSON.stringify(schedaArgomento),	       
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
