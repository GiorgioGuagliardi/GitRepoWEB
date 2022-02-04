package it.mat.unical.webcomp21.serviziuni.model;

public class EsercitazioneCompletata {

	private String utente, esercitazione;
	private int punteggio;
	
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	
	public String getEsercitazione() {
		return esercitazione;
	}
	public void setEsercitazione(String esercitazione) {
		this.esercitazione = esercitazione;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}	
}
