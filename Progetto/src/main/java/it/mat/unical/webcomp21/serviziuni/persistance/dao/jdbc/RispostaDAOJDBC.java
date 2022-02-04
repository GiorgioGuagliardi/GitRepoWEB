package it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.mat.unical.webcomp21.serviziuni.model.Risposta;
import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;
import it.mat.unical.webcomp21.serviziuni.persistance.DBSource;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.RispostaDAO;

public class RispostaDAOJDBC implements RispostaDAO{
	
	DBSource dbSource;
	
	public RispostaDAOJDBC(DBSource dbSource) {
		this.dbSource=dbSource;
	}

	@Override
	public List<Risposta> findRisposte(String id) {
		List<Risposta> risposte = new ArrayList<Risposta>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from risposta where idesercitazione=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Risposta risposta = new Risposta();
				risposta.setNumeroRisposta(rs.getInt("numerorisposta"));
				risposta.setIdEsercitazione(rs.getString("idesercitazione"));
				risposta.setRisposta(rs.getString("risposta"));
				
				risposte.add(risposta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risposte;
	}

	@Override
	public boolean eliminaRisposte(Risposta risposta) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "delete FROM risposta WHERE id=? and numerorisposta=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, risposta.getIdEsercitazione());
			st.setInt(2, risposta.getNumeroRisposta());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	@Override
	public boolean modificaRisposte(Risposta risposta) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "update risposta SET risposta=? WHERE idesercitazione=? and numerorisposta=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, risposta.getRisposta());
			st.setString(2, risposta.getIdEsercitazione());
			st.setInt(3, risposta.getNumeroRisposta());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	@Override
	public boolean eliminaRisposteAll(String id) {
		try {
			System.out.println("provaElimina: "+id);
			Connection conn = dbSource.getConnection();
			String query = "delete FROM risposta WHERE idesercitazione=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("nope");
			return false;
		}
		System.out.println("yep");
		return true;
	}

	@Override
	public boolean aggiungiRisposta(Risposta risposta) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "insert into risposta values (?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, risposta.getNumeroRisposta());
			st.setString(2, risposta.getIdEsercitazione());
			st.setString(3, risposta.getRisposta());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
}
	
