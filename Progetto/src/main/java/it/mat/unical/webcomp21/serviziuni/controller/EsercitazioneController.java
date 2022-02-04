package it.mat.unical.webcomp21.serviziuni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.mat.unical.webcomp21.serviziuni.model.EsercitazioneCompletata;
import it.mat.unical.webcomp21.serviziuni.model.Risposta;
import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;
import it.mat.unical.webcomp21.serviziuni.persistance.DBManager;

@RestController
public class EsercitazioneController {
	
	@PostMapping("PrelevaRisposte")
	public List<String> prelevaRisposte(HttpSession session, @RequestParam String id) {
		List<Risposta> risposte = new ArrayList<Risposta>();
		risposte = DBManager.getInstance().rispostaDAO().findRisposte(id);
		List<String> risposteString = new ArrayList<String>();
		for(int i = 0; i < risposte.size(); i++)
			risposteString.add(risposte.get(i).getRisposta());
		return risposteString;
	}
	
	@PostMapping("InserisciEsercitazione")
	public String inserisciEsercitazione(HttpSession session, @RequestBody EsercitazioneCompletata esercitazione) {
		if(DBManager.getInstance().EsercitazioneCompletataDAO().salvaProva(esercitazione)) {
			String user = "nessuno";
			if((session.getAttribute("usernameLogged") != null)) {
				user = session.getAttribute("usernameLogged").toString();			
			}
			int permessi = DBManager.getInstance().utenteDAO().findPermessi(user);
			permessi++;
			DBManager.getInstance().utenteDAO().updatePermessi(user, permessi);
			System.out.println(DBManager.getInstance().utenteDAO().findPermessi(user));
				return "success";
		}
		return "error";
	}
	
	@PostMapping("SettaArgomento")
	public void settaArgomento(HttpSession session, @RequestParam String esercitazione) {
		session.setAttribute("esercitazioneInCorso", esercitazione);
	}
	
	@PostMapping("ConsegnaEsercitazione")
	public String consegnaEercitazione(HttpSession session, @RequestBody String[] risposteUtente) {
		String esercitazione = session.getAttribute("esercitazioneInCorso").toString();
		List<Risposta> risposte = new ArrayList<Risposta>();
		risposte = DBManager.getInstance().rispostaDAO().findRisposte(esercitazione);
		List<String> risposteString = new ArrayList<String>();
		for(int i = 0; i < risposte.size(); i++)
			risposteString.add(risposte.get(i).getRisposta());
		int punteggio = 0;
		for(int i = 0; i < risposteUtente.length; i++)
			if(risposteUtente[i].equalsIgnoreCase(risposteString.get(i)))
				punteggio++;
		String user = "nessuno";
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();			
		}
		EsercitazioneCompletata es = new EsercitazioneCompletata();
		es.setUtente(user);
		es.setEsercitazione(esercitazione);
		es.setPunteggio(punteggio);
		if(DBManager.getInstance().EsercitazioneCompletataDAO().salvaProva(es))
			return "success";
		return "error";
	}
	
}
