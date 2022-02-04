package it.mat.unical.webcomp21.serviziuni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;
import it.mat.unical.webcomp21.serviziuni.persistance.DBManager;

@Controller
public class LogoutController {

	@GetMapping("doLogout")	
	public String logout(HttpSession session, Model model) {
			session.invalidate();
			List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
			argomenti = DBManager.getInstance().schedaArgomentoDAO().findMostThreeClicked();
			model.addAttribute("tendenze", argomenti);
			
			
			model.addAttribute("permessiUtente", 0);
			return "index";
	}
	
	
}
