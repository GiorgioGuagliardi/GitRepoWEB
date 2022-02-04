package it.mat.unical.webcomp21.serviziuni.controller;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.mat.unical.webcomp21.serviziuni.model.Utente;
import it.mat.unical.webcomp21.serviziuni.persistance.DBManager;

@RestController
public class ServiziLoginController {


	@PostMapping("loginSocial")
	public String loginSocial(HttpSession session, @RequestBody Utente utente) {
		
		if(!DBManager.getInstance().utenteDAO().existsUser(utente.getEmail())) {		
			DBManager.getInstance().utenteDAO().save(utente);
		}
		session.setAttribute("usernameLogged", utente.getEmail());
		session.setAttribute("username",utente.getUsername());
		return "success";		
	}
	
	@PostMapping("ModificaProfilo")
	public String setProfilo(@RequestBody Utente utente) {
	
		try {
			if(DBManager.getInstance().utenteDAO().existsUser(utente.getEmail())) {			
				Utente old = DBManager.getInstance().utenteDAO().findByPrimaryKey(utente.getEmail());
				if(!utente.getPassword().equals("")) 
					DBManager.getInstance().utenteDAO().update(old, utente);				
				else
					DBManager.getInstance().utenteDAO().updateWithoutPsw(old, utente);			
			}
		} catch (Exception e) {
			return "error";
		}
		return "success";		
	}
	
	
	@PostMapping("Serviziologin")
	public String login(HttpSession session, @RequestBody Utente utente) {
		if (!DBManager.getInstance().utenteDAO().existsUser(utente.getEmail())) {
			return "nonRegistrato";
		}
			

		if(DBManager.getInstance().utenteDAO().checkPassword(utente.getEmail(), utente.getPassword())){
			    session.setAttribute("usernameLogged", utente.getEmail());
				session.setAttribute("username", utente.getUsername());
				session.setAttribute("permessi", utente.getPermessi());
				return "success";
		}
		else {
			return "error";
		}							

	}

	
	@PostMapping("ServizioRegistrazione")
	public String registrazione(HttpSession session, @RequestBody Utente utente) {
		if (DBManager.getInstance().utenteDAO().existsUser(utente.getEmail())) {
			return "errorEsiste";
		}
		else if (utente.getPassword().length() < 8)
			return "errorPassword";
		else {
			utente.setPermessi(1);
			DBManager.getInstance().utenteDAO().save(utente);
			session.setAttribute("usernameLogged", utente.getEmail());
			session.setAttribute("username",utente.getUsername());
			return "success";
		}
	}
}