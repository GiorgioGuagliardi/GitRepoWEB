package it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import it.mat.unical.webcomp21.serviziuni.model.Utente;
import it.mat.unical.webcomp21.serviziuni.model.UtentePunteggio;
import it.mat.unical.webcomp21.serviziuni.persistance.DBSource;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO {
	
	DBSource dbSource;

	public UtenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public boolean save(Utente utente) {
		Connection conn;
		try {
			conn = dbSource.getConnection();

			String query = "insert into utente values(?,?,?,?,?,?);"; // prendiamo la query
			PreparedStatement st = conn.prepareStatement(query); // creiamo lo statement
			st.setString(1, utente.getEmail());
			st.setString(2, utente.getNome());
			st.setString(3, utente.getCognome());
			st.setString(4, utente.getPassword());
			st.setString(5, utente.getUsername());
			st.setInt(6, utente.getPermessi());
			st.executeUpdate();
			
		} catch (SQLException e) {
			  return false;
		}
		
		return true;
	}

	@Override
	public Utente findByPrimaryKey(String email) {
		Utente utente = new Utente();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				utente.setEmail(rs.getString("email"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setPassword(rs.getString("password"));
				utente.setUsername(rs.getString("username"));
				utente.setPermessi(rs.getInt("permessi"));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	return utente;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAllOtherUsers(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente old, Utente newu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWithoutPsw(Utente old, Utente newu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findUsername(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkPassword(String email, String password) {
		String password_hash=null;
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select password from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				password_hash = rs.getString("password");
			}
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return password.equals(password_hash);
	}

	@Override
	public String getNome(String email) {
		String user = "";
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where email = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = rs.getString("nome");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean existsUser(String email) {
		Utente utente = new Utente();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				utente.setEmail(rs.getString("email"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setPassword(rs.getString("password"));
				utente.setUsername(rs.getString("username"));
				utente.setPermessi(rs.getInt("permessi"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		if (utente.getEmail()!=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean existsUsername(String username) {
		String check = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select utente.username from utente where username=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				check = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (check==null)
			return false;
		else
			return true;
	}

	@Override
	public void setPassword(String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utente> findByName(String cercaNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findPermessi(String utente) {
		int permessi = 0;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where email=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				permessi = rs.getInt("permessi");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return permessi;
	}

	@Override
	public String getCognome(String email) {
		String user = "";
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where email = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = rs.getString("cognome");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getUsername(String email) {
		String user = "";
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente where email = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = rs.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int findPunteggio(String email) {
		int punteggio = 0;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from esercitazionicompletate where utente = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				punteggio+=(rs.getInt("punteggio"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return punteggio;	
	}

	@Override
	public List<UtentePunteggio> creaClassificaUtenti() {
		List<UtentePunteggio> utentiPunteggi = new ArrayList<UtentePunteggio>(); 
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from utente";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String utente = rs.getString("email");
				int punteggio = findPunteggio(rs.getString("email"));
				UtentePunteggio up = new UtentePunteggio(utente, punteggio);
				utentiPunteggi.add(up);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<UtentePunteggio> finale = new ArrayList<UtentePunteggio>();
		if(utentiPunteggi.size() >= 5)
			for(int i = 0; i < 5; i++)
				finale.add(utentiPunteggi.get(i));
		else
			for(int i = 0; i < utentiPunteggi.size(); i++)
				finale.add(utentiPunteggi.get(i));
		Collections.sort(finale, new Comparator<UtentePunteggio>() {
			@Override
			public int compare(UtentePunteggio o1, UtentePunteggio o2) {
				return o2.getPunteggio().compareTo(o1.getPunteggio());
			}
			
		});
		return finale;
	}

	@Override
	public List<Integer> creaClassificaPUnteggi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePermessi(String user, int permessi) {
		List<String> esercitazioni = new ArrayList<String>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from esercitazionicompletate where utente=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, user);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				esercitazioni.add(rs.getString("esercitazione"));
			}
			if(esercitazioni.size() == 10) {
				query = "update utente SET permessi=? WHERE	id=?";
				st = conn.prepareStatement(query);
				st.setInt(1, permessi);
				st.setString(2, user);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	
}
