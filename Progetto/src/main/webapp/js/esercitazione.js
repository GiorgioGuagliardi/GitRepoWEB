var inserisciPunteggio = true;

function visualizzaRisposte(){
	inserisciPunteggio = false;
	var risposta = "risposta";
	var size = document.getElementById("size").value;
	for(var i = 1; i <= size; i++){
		var cerca = risposta.concat(i.toString());
		document.getElementById(cerca).style.visibility = "visible";
	}
}

function EsercitazioneCompletata(utente, esercitazione, punteggio){
	this.utente = utente;
	this.esercitazione = esercitazione;
	this.punteggio = punteggio;
}

function consegna(){
	var esercitazione = document.getElementById("argomento").value;
	var size = document.getElementById("size").value;
	
	var risposteUtente = [];
	
	if(inserisciPunteggio)
		for(var i = 1; i <= size; i++){
			risposteUtente[i-1] = document.getElementById(i.toString()).value;
		}
	else{
		for(var i = 1; i <= size; i++){
			risposteUtente[i-1] = "";
	}
	
		$.ajax({
			url: "SettaArgomento",
			method: "POST",
			data: {'esercitazione':esercitazione}
	});
	
	$.ajax({
			url: "ConsegnaEsercitazione",
			method: "POST",
			data: JSON.stringify(risposteUtente),
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

}