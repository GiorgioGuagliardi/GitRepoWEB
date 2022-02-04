package it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;
import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;
import it.mat.unical.webcomp21.serviziuni.persistance.DBSource;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.SchedaEsercitazioneDAO;

public class SchedaEsercitazioneDAOJDBC implements SchedaEsercitazioneDAO{

	DBSource dbSource;
	
	public SchedaEsercitazioneDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public SchedaEsercitazione findByPrimaryKey(String id) {
		SchedaEsercitazione esercitazione = new SchedaEsercitazione();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaesercitazione where id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				esercitazione.setIdEsercitazione(rs.getString("id"));
				esercitazione.setUrlImmagine(rs.getString("urlimmagine"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esercitazione;
	}

	@Override
	public boolean modificaEsercitazione(SchedaEsercitazione schedaEsercitazione) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "update schedaesercitazione SET urlimmagine=? WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, schedaEsercitazione.getUrlImmagine());
			st.setString(2, schedaEsercitazione.getIdEsercitazione());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	@Override
	public boolean eliminaEsercitazione(SchedaEsercitazione schedaEsercitazione) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "delete FROM schedaesercitazione WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, schedaEsercitazione.getIdEsercitazione());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	@Override
	public boolean aggiungiEsercitazione(SchedaEsercitazione schedaEsercitazione) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "insert into schedaesercitazione values (?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, schedaEsercitazione.getIdEsercitazione());
			st.setString(2, schedaEsercitazione.getUrlImmagine());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	
	
}
