package it.mat.unical.webcomp21.serviziuni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.mat.unical.webcomp21.serviziuni.model.Risposta;
import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;
import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;
import it.mat.unical.webcomp21.serviziuni.persistance.DBManager;

@Controller
public class ArgomentoController {
	
	@PostMapping("getArgomento")
	public String getArgomento(HttpSession session, Model model, @RequestParam String id) {
		SchedaArgomento argomento = DBManager.getInstance().schedaArgomentoDAO().findByPrimaryKey(id);
		model.addAttribute("argomentoRichiesto", argomento);
		
		SchedaArgomento argomentoPro = DBManager.getInstance().schedaArgomentoDAO().findByPrimaryKeyPro(id);
		model.addAttribute("argomentoRichiestoPro", argomentoPro);
		
		int visual = DBManager.getInstance().schedaArgomentoDAO().getVisual(id);
		visual++;
		DBManager.getInstance().schedaArgomentoDAO().updateVisual(id, visual);

		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);			
		}
		model.addAttribute("permessiUtente", permessi);
		return "paginaArgomento";
	}
	
	@PostMapping("getArgomentoModificaElimina")
	public String getArgomentoModificaElimina(HttpSession session, Model model, @RequestParam String id) {
		SchedaArgomento argomento = DBManager.getInstance().schedaArgomentoDAO().findAmministratore(id);
		model.addAttribute("argomentoRichiesto", argomento);
		
		return "modificaEliminaArgomento";
	}
	
	@PostMapping("getEsercitazione")
	public String getEsercitazione(HttpSession session, Model model, @RequestParam String id) {
		SchedaEsercitazione esercitazione = DBManager.getInstance().schedaEsercitazioneDAO().findByPrimaryKey(id);
		model.addAttribute("esercitazioneRichiesta", esercitazione);
		
		List<Risposta> risposte = new ArrayList<Risposta>();
		risposte = DBManager.getInstance().rispostaDAO().findRisposte(id);
		model.addAttribute("risposte", risposte);
		model.addAttribute("size",risposte.size());
		
		String user = "nessuno";
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();			
		}
		model.addAttribute("user", user);
		return "paginaEsercitazione";
	}
	
	@PostMapping("getEsercitazioneModificaElimina")
	public String getEsercitazioneModificaElimina(HttpSession session, Model model, @RequestParam String id) {
		SchedaEsercitazione esercitazione = DBManager.getInstance().schedaEsercitazioneDAO().findByPrimaryKey(id);
		model.addAttribute("esercitazioneRichiesta", esercitazione);
		
		return "modificaEliminaEsercitazione";
	}
	
	@PostMapping("getRisposteModificaElimina")
	public String getRisposteModificaElimina(HttpSession session, Model model, @RequestParam String id) {
		List<Risposta> risposte = DBManager.getInstance().rispostaDAO().findRisposte(id);
		model.addAttribute("risposte", risposte);
		model.addAttribute("size", risposte.size());
		
		return "modificaEliminaRisposta";
	}
}
