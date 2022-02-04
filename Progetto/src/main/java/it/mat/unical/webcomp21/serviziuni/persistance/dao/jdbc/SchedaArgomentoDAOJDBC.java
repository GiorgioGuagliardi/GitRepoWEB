package it.mat.unical.webcomp21.serviziuni.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.mat.unical.webcomp21.serviziuni.model.SchedaArgomento;
import it.mat.unical.webcomp21.serviziuni.persistance.DBSource;
import it.mat.unical.webcomp21.serviziuni.persistance.dao.SchedaArgomentoDAO;

public class SchedaArgomentoDAOJDBC implements SchedaArgomentoDAO{

	DBSource dbSource;
	
	public SchedaArgomentoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	
	@Override
	public List<SchedaArgomento> findMostThreeClicked() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where permessi=0 order by visualizzazioni desc limit 3";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findVerbi() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where macroargomento=0 and permessi=0 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findVocabolario() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where macroargomento=1 and permessi=0 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findGrammatica() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where macroargomento=2 and permessi=0 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public SchedaArgomento findByPrimaryKey(String id) {
		SchedaArgomento argomento = new SchedaArgomento();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where id=? and permessi=0";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomento;
	}


	@Override
	public List<SchedaArgomento> findCerca(String cerca) {
		String daCercare = cerca.toLowerCase();
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where permessi=0 and titolo ILIKE ? or id ILIKE ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, daCercare);
			st.setString(2, daCercare);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
			}
			if(cerca.equals("verbi")) {
				query = "select * from schedaargomento where macroargomento=0 and permessi=0 order by visualizzazioni desc";
				PreparedStatement verbi = conn.prepareStatement(query);
				ResultSet verbiResult = verbi.executeQuery();
				while(verbiResult.next()) {
					SchedaArgomento argomento = new SchedaArgomento();
					argomento.setId(verbiResult.getString("id"));
					argomento.setIdEsercitazione(verbiResult.getString("idesercitazione"));
					argomento.setMacroargomento(verbiResult.getInt("macroargomento"));
					argomento.setVisualizzazioni(verbiResult.getInt("visualizzazioni"));
					argomento.setUrlImmagine(verbiResult.getString("urlimmagine"));
					argomento.setDescrizione(verbiResult.getString("descrizione"));
					argomento.setTitolo(verbiResult.getString("titolo"));
					argomento.setPermessi(verbiResult.getInt("permessi"));
					
					argomenti.add(argomento);
				}
			}
			else if(cerca.equals("vocabolario")) {
				query = "select * from schedaargomento where macroargomento=1 and permessi=0 order by visualizzazioni desc";
				PreparedStatement vocabolario = conn.prepareStatement(query);
				ResultSet vocabolarioResult = vocabolario.executeQuery();
				while(vocabolarioResult.next()) {
					SchedaArgomento argomento = new SchedaArgomento();
					argomento.setId(vocabolarioResult.getString("id"));
					argomento.setIdEsercitazione(vocabolarioResult.getString("idesercitazione"));
					argomento.setMacroargomento(vocabolarioResult.getInt("macroargomento"));
					argomento.setVisualizzazioni(vocabolarioResult.getInt("visualizzazioni"));
					argomento.setUrlImmagine(vocabolarioResult.getString("urlimmagine"));
					argomento.setDescrizione(vocabolarioResult.getString("descrizione"));
					argomento.setTitolo(vocabolarioResult.getString("titolo"));
					argomento.setPermessi(vocabolarioResult.getInt("permessi"));
					
					argomenti.add(argomento);
				}
			}
			else if(cerca.equals("grammatica")) {
				query = "select * from schedaargomento where macroargomento=2 and permessi=0 order by visualizzazioni desc";
				PreparedStatement grammatica = conn.prepareStatement(query);
				ResultSet grammaticaResult = grammatica.executeQuery();
				while(grammaticaResult.next()) {
					SchedaArgomento argomento = new SchedaArgomento();
					argomento.setId(grammaticaResult.getString("id"));
					argomento.setIdEsercitazione(grammaticaResult.getString("idesercitazione"));
					argomento.setMacroargomento(grammaticaResult.getInt("macroargomento"));
					argomento.setVisualizzazioni(grammaticaResult.getInt("visualizzazioni"));
					argomento.setUrlImmagine(grammaticaResult.getString("urlimmagine"));
					argomento.setDescrizione(grammaticaResult.getString("descrizione"));
					argomento.setTitolo(grammaticaResult.getString("titolo"));
					argomento.setPermessi(grammaticaResult.getInt("permessi"));
					
					argomenti.add(argomento);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findVerbiPro() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where macroargomento=0 and permessi=1 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findVocabolarioPro() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where macroargomento=1 and permessi=1 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findGrammaticaPro() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where macroargomento=2 and permessi=1 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public SchedaArgomento findByPrimaryKeyPro(String id) {
		SchedaArgomento argomento = new SchedaArgomento();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where id=? and permessi=1";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomento;
	}


	@Override
	public List<SchedaArgomento> findCercaPro(String cerca) {
		String daCercare = cerca.toLowerCase();
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where permessi=1 and titolo ILIKE ? or id ILIKE ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, daCercare);
			st.setString(2, daCercare);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
			if(cerca.equals("verbi")) {
				query = "select * from schedaargomento where macroargomento=0 and permessi=1 order by visualizzazioni desc";
				PreparedStatement verbi = conn.prepareStatement(query);
				ResultSet verbiResult = verbi.executeQuery();
				while(verbiResult.next()) {
					SchedaArgomento argomento = new SchedaArgomento();
					argomento.setId(verbiResult.getString("id"));
					argomento.setIdEsercitazione(verbiResult.getString("idesercitazione"));
					argomento.setMacroargomento(verbiResult.getInt("macroargomento"));
					argomento.setVisualizzazioni(verbiResult.getInt("visualizzazioni"));
					argomento.setUrlImmagine(verbiResult.getString("urlimmagine"));
					argomento.setDescrizione(verbiResult.getString("descrizione"));
					argomento.setTitolo(verbiResult.getString("titolo"));
					argomento.setPermessi(rs.getInt("permessi"));
					
					argomenti.add(argomento);
				}
			}
			else if(cerca.equals("vocabolario")) {
				query = "select * from schedaargomento where macroargomento=1 and permessi=1 order by visualizzazioni desc";
				PreparedStatement vocabolario = conn.prepareStatement(query);
				ResultSet vocabolarioResult = vocabolario.executeQuery();
				while(vocabolarioResult.next()) {
					SchedaArgomento argomento = new SchedaArgomento();
					argomento.setId(vocabolarioResult.getString("id"));
					argomento.setIdEsercitazione(vocabolarioResult.getString("idesercitazione"));
					argomento.setMacroargomento(vocabolarioResult.getInt("macroargomento"));
					argomento.setVisualizzazioni(vocabolarioResult.getInt("visualizzazioni"));
					argomento.setUrlImmagine(vocabolarioResult.getString("urlimmagine"));
					argomento.setDescrizione(vocabolarioResult.getString("descrizione"));
					argomento.setTitolo(vocabolarioResult.getString("titolo"));
					argomento.setPermessi(rs.getInt("permessi"));
					
					argomenti.add(argomento);
				}
			}
			else if(cerca.equals("grammatica")) {
				query = "select * from schedaargomento where macroargomento=2 and permessi=1 order by visualizzazioni desc";
				PreparedStatement grammatica = conn.prepareStatement(query);
				ResultSet grammaticaResult = grammatica.executeQuery();
				while(grammaticaResult.next()) {
					SchedaArgomento argomento = new SchedaArgomento();
					argomento.setId(grammaticaResult.getString("id"));
					argomento.setIdEsercitazione(grammaticaResult.getString("idesercitazione"));
					argomento.setMacroargomento(grammaticaResult.getInt("macroargomento"));
					argomento.setVisualizzazioni(grammaticaResult.getInt("visualizzazioni"));
					argomento.setUrlImmagine(grammaticaResult.getString("urlimmagine"));
					argomento.setDescrizione(grammaticaResult.getString("descrizione"));
					argomento.setTitolo(grammaticaResult.getString("titolo"));
					argomento.setPermessi(rs.getInt("permessi"));
					
					argomenti.add(argomento);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findAll() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where permessi=0 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public List<SchedaArgomento> findAllPro() {
		List<SchedaArgomento> argomenti = new ArrayList<SchedaArgomento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where permessi=1 order by visualizzazioni desc";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				SchedaArgomento argomento = new SchedaArgomento();
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
				
				argomenti.add(argomento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomenti;
	}


	@Override
	public SchedaArgomento findAmministratore(String id) {
		SchedaArgomento argomento = new SchedaArgomento();
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				argomento.setId(rs.getString("id"));
				argomento.setIdEsercitazione(rs.getString("idesercitazione"));
				argomento.setMacroargomento(rs.getInt("macroargomento"));
				argomento.setVisualizzazioni(rs.getInt("visualizzazioni"));
				argomento.setUrlImmagine(rs.getString("urlimmagine"));
				argomento.setDescrizione(rs.getString("descrizione"));
				argomento.setTitolo(rs.getString("titolo"));
				argomento.setPermessi(rs.getInt("permessi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return argomento;
	}


	@Override
	public boolean modificaArgomento(SchedaArgomento schedaArgomento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "update schedaargomento SET macroargomento=?, urlImmagine=?, descrizione=?, titolo=?, permessi=?, visualizzazioni=? WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, schedaArgomento.getMacroargomento());
			st.setString(2, schedaArgomento.getUrlImmagine());
			st.setString(3, schedaArgomento.getDescrizione());
			st.setString(4, schedaArgomento.getTitolo());
			st.setInt(5, schedaArgomento.getPermessi());
			st.setInt(6, schedaArgomento.getVisualizzazioni());
			st.setString(7, schedaArgomento.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}


	@Override
	public boolean eliminaArgomento(SchedaArgomento schedaArgomento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "delete FROM schedaargomento WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, schedaArgomento.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}


	@Override
	public boolean aggiungtaArgomento(SchedaArgomento schedaArgomento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "insert into schedaargomento values (?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, schedaArgomento.getId());
			st.setString(2, schedaArgomento.getIdEsercitazione());
			st.setInt(3, schedaArgomento.getMacroargomento());
			st.setInt(4, schedaArgomento.getVisualizzazioni());
			st.setString(5, schedaArgomento.getUrlImmagine());
			st.setString(6, schedaArgomento.getDescrizione());
			st.setString(7, schedaArgomento.getTitolo());
			st.setInt(8, schedaArgomento.getPermessi());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}


	@Override
	public boolean updateVisual(String id, int visual) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "update schedaargomento SET visualizzazioni=? WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, visual);
			st.setString(2, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}


	@Override
	public int getVisual(String id) {
		int visual = 0;
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from schedaargomento where id=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				visual = (rs.getInt("visualizzazioni"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return visual;
	}
	
	
}
