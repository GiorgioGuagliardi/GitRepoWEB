package it.mat.unical.webcomp21.serviziuni.persistance.dao;

import java.util.List;
import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;

public interface SchedaArgomentoDAO {

	public List<SchedaArgomento> findMostThreeClicked();
	public List<SchedaArgomento> findVerbi();
	public List<SchedaArgomento> findVocabolario();
	public List<SchedaArgomento> findGrammatica();
	public SchedaArgomento findByPrimaryKey(String id);
	public List<SchedaArgomento> findCerca(String cerca);
	public List<SchedaArgomento> findVerbiPro();
	public List<SchedaArgomento> findVocabolarioPro();
	public List<SchedaArgomento> findGrammaticaPro();
	public SchedaArgomento findByPrimaryKeyPro(String id);
	public List<SchedaArgomento> findCercaPro(String cerca);
	public List<SchedaArgomento> findAll();
	public List<SchedaArgomento> findAllPro();
	public SchedaArgomento findAmministratore(String id);
	public boolean aggiungtaArgomento(SchedaArgomento schedaArgomento);
	public boolean modificaArgomento(SchedaArgomento schedaArgomento);
	public boolean eliminaArgomento(SchedaArgomento schedaArgomento);
	public int getVisual(String id);
	public boolean updateVisual(String id, int visual);
}

