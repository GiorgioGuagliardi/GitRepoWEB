package it.mat.unical.webcomp21.serviziuni.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;
import it.mat.unical.webcomp21.serviziuni.model.UtentePunteggio;
import it.mat.unical.webcomp21.serviziuni.persistance.DBManager;

@Controller
public class NavbarController {

	
	@PostMapping("cerca")
	public String risultatiRicerca(HttpSession session, Model model, @RequestParam String daCercare) {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		argomenti = DBManager.getInstance().schedaArgomentoDAO().findCerca(daCercare);
		model.addAttribute("argomenti", argomenti);
		
		List<SchedaArgomento> argomentiPro = new ArrayList<SchedaArgomento>();
		argomentiPro = DBManager.getInstance().schedaArgomentoDAO().findCercaPro(daCercare);
		model.addAttribute("argomentiPro", argomentiPro);
		
		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);	
		}
		model.addAttribute("permessiUtente", permessi);
		return "risultatiRicerca";			
	}
	
	@GetMapping("tendenze")
	public String getTendenze(HttpSession session, Model model) {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		argomenti = DBManager.getInstance().schedaArgomentoDAO().findAll();
		model.addAttribute("argomenti", argomenti);
		
		List<SchedaArgomento> argomentiPro = new ArrayList<SchedaArgomento>();
		argomentiPro = DBManager.getInstance().schedaArgomentoDAO().findAllPro();
		model.addAttribute("argomentiPro", argomentiPro);
		
		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);	
		}
		model.addAttribute("permessiUtente", permessi);
		return "risultatiRicerca";
	}
	
	@GetMapping("/index")
	public String getHome(HttpSession session, Model model) {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		argomenti = DBManager.getInstance().schedaArgomentoDAO().findMostThreeClicked();
		model.addAttribute("tendenze", argomenti);
		
		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);	
		}
		model.addAttribute("permessiUtente", permessi);
		return "index";
	}
	
	@GetMapping("")
	public String getHomeLoad(HttpSession session, Model model) {
		return getHome(session, model);
	}
	
	@GetMapping("/verbi")
	public String getPaginaVerbi(HttpSession session, Model model) {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		argomenti = DBManager.getInstance().schedaArgomentoDAO().findVerbi();
		model.addAttribute("verbi", argomenti);
		
		List<SchedaArgomento> argomentiPro = new ArrayList<SchedaArgomento>();
		argomentiPro = DBManager.getInstance().schedaArgomentoDAO().findVerbiPro();
		model.addAttribute("verbiPro", argomentiPro);
		
		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);
			}
		model.addAttribute("permessiUtente", permessi);
		return "verbi";
	}
	
	@GetMapping("/vocabolario")
	public String getPaginaVocabolario(HttpSession session, Model model) {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		argomenti = DBManager.getInstance().schedaArgomentoDAO().findVocabolario();
		model.addAttribute("vocabolario", argomenti);
		
		List<SchedaArgomento> argomentiPro = new ArrayList<SchedaArgomento>();
		argomentiPro = DBManager.getInstance().schedaArgomentoDAO().findVocabolarioPro();
		model.addAttribute("vocabolarioPro", argomentiPro);
		
		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);		
		}
		model.addAttribute("permessiUtente", permessi);
		return "vocabolario";
	}
	
	@GetMapping("/grammatica")
	public String getPaginaGrammatica(HttpSession session, Model model){
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		argomenti = DBManager.getInstance().schedaArgomentoDAO().findGrammatica();
		model.addAttribute("grammatica", argomenti);
		
		List<SchedaArgomento> argomentiPro = new ArrayList<SchedaArgomento>();
		argomentiPro = DBManager.getInstance().schedaArgomentoDAO().findGrammaticaPro();
		model.addAttribute("grammaticaPro", argomentiPro);
		
		String user = "nessuno";
		int permessi = 0;
		if((session.getAttribute("usernameLogged") != null)) {
			user = session.getAttribute("usernameLogged").toString();
			permessi = DBManager.getInstance().utenteDAO().findPermessi(user);			
		}
		model.addAttribute("permessiUtente", permessi);
		return "grammatica";
	}
	
	@GetMapping("/profilePage")
	public String getProfilePage(HttpSession session, Model model) {
		String user = session.getAttribute("usernameLogged").toString();
		int permessi = DBManager.getInstance().utenteDAO().findPermessi(user);
		String nome = DBManager.getInstance().utenteDAO().getNome(user);
		String cognome = DBManager.getInstance().utenteDAO().getCognome(user);
		String username = DBManager.getInstance().utenteDAO().getUsername(user);
		int punteggio = DBManager.getInstance().utenteDAO().findPunteggio(user);
		model.addAttribute("user", user);
		model.addAttribute("permessiUtente", permessi);
		model.addAttribute("nome", nome);
		model.addAttribute("cognome", cognome);
		model.addAttribute("username", username);
		model.addAttribute("punteggio", punteggio);
		
		List<UtentePunteggio> utentiPunteggi = DBManager.getInstance().utenteDAO().creaClassificaUtenti();
		model.addAttribute("utentiPunteggi", utentiPunteggi);
		return "profilePage";
	}
	
	@GetMapping("/aggiuntaEsercitazione")
	public String getEsercitazioneAggiunta(HttpSession session, Model model) {
		return "aggiuntaEsercitazione";
	}
	
	@GetMapping("/aggiuntaArgomento")
	public String getArgomentoAggiunta(HttpSession session, Model model) {
		return "aggiuntaArgomento";
	}
	
	@GetMapping("/aggiuntaRisposte")
	public String getRispostaAggiunta(HttpSession session, Model model) {
		return "aggiuntaRisposte";
	}
}
