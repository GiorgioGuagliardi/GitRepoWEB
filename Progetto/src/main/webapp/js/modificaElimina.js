function SchedaArgomento(id, idEsercitazione, urlImmagine, descrizione, titolo,macroargomento, visualizzazioni, permessi){
	this.id = id;
	this.idEsercitazione = idEsercitazione;
	this.urlImmagine = urlImmagine;
	this.descrizione = descrizione;
	this.titolo = titolo;
	this.macroargomento = macroargomento;
	this.visualizzazioni = visualizzazioni;
	this.permessi = permessi;
}

function modifica(){
	var id = document.getElementById("id").value;
	var macroargomento = document.getElementById("macroargomento").value;
	var urlImmagine = document.getElementById("urlImmagine").value;
	var descrizione = document.getElementById("descrizione").value;
	var titolo = document.getElementById("titolo").value;
	var visualizzazioni = document.getElementById("visualizzazioni").value;
	var permessi = document.getElementById("permessi").value;
	
	var schedaArgomento = new SchedaArgomento(id, id, urlImmagine, descrizione, titolo, macroargomento, visualizzazioni, permessi);
	
	$.ajax({
					  url: "ServizioModificaArgomento",  
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

function elimina(){
	var id = document.getElementById("id").value;
	var macroargomento = document.getElementById("macroargomento").value;
	var urlImmagine = document.getElementById("urlImmagine").value;
	var descrizione = document.getElementById("descrizione").value;
	var titolo = document.getElementById("titolo").value;
	var visualizzazioni = document.getElementById("visualizzazioni").value;
	var permessi = document.getElementById("permessi").value;
	
	var schedaArgomento = new SchedaArgomento(id, id, urlImmagine, descrizione, titolo, macroargomento, visualizzazioni, permessi);
	
	$.ajax({
					  url: "ServizioEliminaArgomento",  
			          method: "POST",	         
			          data: JSON.stringify(schedaArgomento),	       
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