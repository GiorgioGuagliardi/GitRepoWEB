package it.mat.unical.webcomp21.serviziuni.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.mat.unical.webcomp21.serviziuni.model.Risposta;
import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;
import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;
import it.mat.unical.webcomp21.serviziuni.persistance.DBManager;

@RestController
public class ServiziAmministratoreController {

	@PostMapping("ServizioAggiuntaArgomento")
	public String aggiungtaArgomento(HttpSession session, @RequestBody SchedaArgomento schedaArgomento) {
		if(DBManager.getInstance().schedaArgomentoDAO().aggiungtaArgomento(schedaArgomento))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioModificaArgomento")
	public String modificaArgomento(HttpSession session, @RequestBody SchedaArgomento schedaArgomento) {
		if(DBManager.getInstance().schedaArgomentoDAO().modificaArgomento(schedaArgomento))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioEliminaArgomento")
	public String eliminaArgomento(HttpSession session, @RequestBody SchedaArgomento schedaArgomento) {
		if(DBManager.getInstance().schedaArgomentoDAO().eliminaArgomento(schedaArgomento))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioAggiungiEsercitazione")
	public String aggiungiEsercitazione(HttpSession session, @RequestBody SchedaEsercitazione schedaEsercitazione) {
		if(DBManager.getInstance().schedaEsercitazioneDAO().aggiungiEsercitazione(schedaEsercitazione))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioModificaEsercitazione")
	public String modificaEsercitazione(HttpSession session, @RequestBody SchedaEsercitazione schedaEsercitazione) {
		if(DBManager.getInstance().schedaEsercitazioneDAO().modificaEsercitazione(schedaEsercitazione))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioEliminaEsercitazione")
	public String eliminaEsercitazione(HttpSession session, @RequestBody SchedaEsercitazione schedaEsercitazione) {
		if(DBManager.getInstance().rispostaDAO().eliminaRisposteAll(schedaEsercitazione.getIdEsercitazione())) {
			SchedaArgomento argomento = DBManager.getInstance().schedaArgomentoDAO().findByPrimaryKey(schedaEsercitazione.getIdEsercitazione());
			if(DBManager.getInstance().schedaArgomentoDAO().eliminaArgomento(argomento))
				if(DBManager.getInstance().schedaEsercitazioneDAO().eliminaEsercitazione(schedaEsercitazione))
					return "success";
		}			
		return "error";
	}
	
	@PostMapping("ServizioAggiuntaRisposta")
	public String aggiuntaRisposta(HttpSession session, @RequestBody Risposta risposta) {
		if(DBManager.getInstance().rispostaDAO().aggiungiRisposta(risposta))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioModificaRisposta")
	public String modificaRisposte(HttpSession session, @RequestBody Risposta risposta) {
		if(DBManager.getInstance().rispostaDAO().modificaRisposte(risposta))
			return "success";
		return "error";
	}
	
	@PostMapping("ServizioEliminaRisposta")
	public String eliminaRisposte(HttpSession session, @RequestBody Risposta risposta) {
		if(DBManager.getInstance().rispostaDAO().eliminaRisposte(risposta))
			return "success";
		return "error";
	}
}
