package it.mat.unical.webcomp21.serviziuni.persistance;

import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.EsercitazioneCompletataDAO;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.RispostaDAO;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.SchedaArgomentoDAO;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.SchedaEsercitazioneDAO;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.UtenteDAO;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc.EsercitazioneCompletataDAOJDBC;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc.RispostaDAOJDBC;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc.SchedaArgomentoDAOJDBC;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc.SchedaEsercitazioneDAOJDBC;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc.UtenteDAOJDBC;

public class DBManager {

	private static DBManager instance = null;
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {}
	
	public static DBSource getDataSource() {
		return dataSource;
	}
	
	public UtenteDAO utenteDAO() {
		return new UtenteDAOJDBC(dataSource);
	}
	public SchedaEsercitazioneDAO schedaEsercitazioneDAO() {
		return new SchedaEsercitazioneDAOJDBC(dataSource);
	}
	public SchedaArgomentoDAO schedaArgomentoDAO() {
		return new SchedaArgomentoDAOJDBC(dataSource);
	}
	public RispostaDAO rispostaDAO() {
		return new RispostaDAOJDBC(dataSource);
	}
	public EsercitazioneCompletataDAO EsercitazioneCompletataDAO() {
		return new EsercitazioneCompletataDAOJDBC(dataSource);
	}
}
