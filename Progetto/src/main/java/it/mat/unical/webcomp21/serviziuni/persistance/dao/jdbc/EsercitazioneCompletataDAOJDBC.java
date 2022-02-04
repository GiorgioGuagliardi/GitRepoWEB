package it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.mat.unical.webcomp21.serviziuni.model.EsercitazioneCompletata;
import it.mat.unical.webcomp21.serviziuni.model.Risposta;
import it.mat.unical.webcomp21.serviziuni.persistance.DBSource;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.EsercitazioneCompletataDAO;

public class EsercitazioneCompletataDAOJDBC implements EsercitazioneCompletataDAO{

	DBSource dbSource;
	
	public EsercitazioneCompletataDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public boolean findProva(EsercitazioneCompletata esercitazione) {
		List<EsercitazioneCompletata> check = new ArrayList<>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from esercitazionicompletate where esercitazione=? and utente=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, esercitazione.getEsercitazione());
			st.setString(2, esercitazione.getUtente());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				EsercitazioneCompletata es = new EsercitazioneCompletata();
				es.setEsercitazione(rs.getString("esercitazione"));
				es.setUtente(rs.getString("utente"));
				
				check.add(es);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check.size()!=0)
			return false;
		return true;
	}

	@Override
	public boolean salvaProva(EsercitazioneCompletata esercitazione) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "insert into esercitazionicompletate values(?,?,?);";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, esercitazione.getUtente());
			st.setString(2, esercitazione.getEsercitazione());
			st.setInt(3, esercitazione.getPunteggio());
			st.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
