package it.mat.unical.webcomp21.serviziuni.model;

public class SchedaArgomento {

	private String id, idEsercitazione, urlImmagine, descrizione, titolo;
	private int macroargomento, visualizzazioni, permessi;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdEsercitazione() {
		return idEsercitazione;
	}
	public void setIdEsercitazione(String idEsercitazione) {
		this.idEsercitazione = idEsercitazione;
	}
	
	public String getUrlImmagine() {
		return urlImmagine;
	}
	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}
	
	public int getMacroargomento() {
		return macroargomento;
	}
	public void setMacroargomento(int macroargomento) {
		this.macroargomento = macroargomento;
	}
	
	public int getVisualizzazioni() {
		return visualizzazioni;
	}
	public void setVisualizzazioni(int visualizzazioni) {
		this.visualizzazioni = visualizzazioni;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public int getPermessi() {
		return permessi;
	}
	public void setPermessi(int permessi) {
		this.permessi = permessi;
	}
	
}
