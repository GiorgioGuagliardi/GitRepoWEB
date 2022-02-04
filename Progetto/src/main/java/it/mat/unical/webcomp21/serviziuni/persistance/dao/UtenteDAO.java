package it.mat.unical.webcomp21.serviziuni.persistance.dao;

import java.util.List;

import it.mat.unical.webcomp21.serviziuni.model.Utente;
import it.mat.unical.webcomp21.serviziuni.model.UtentePunteggio;


public interface UtenteDAO {

	public boolean save(Utente utente);  // Create  == insert/store
	public Utente findByPrimaryKey(String email);     // Retrieve  == select stud
	public List<Utente> findAll();     //  select*
	public List<Utente> findAllOtherUsers(String email);     //  select*
	public void update(Utente old, Utente newu); //Update
	public void updateWithoutPsw(Utente old, Utente newu);
	public void delete(String email); //Delete	
	public String findUsername(String email);
	public boolean checkPassword(String email, String password);
	public String getNome(String email);
	public String getCognome(String email);
	public String getUsername(String email);
	public boolean existsUser(String email);
	public boolean existsUsername (String username);
	public int findPunteggio(String email);
	public List<UtentePunteggio> creaClassificaUtenti();
	public List<Integer> creaClassificaPUnteggi();
	public void setPassword(String email, String password); //Update
	public List<Utente> findByName(String cercaNome);     // Retrieve  == select stud
	public int findPermessi(String utente);
	public boolean updatePermessi(String user, int permessi);
}
