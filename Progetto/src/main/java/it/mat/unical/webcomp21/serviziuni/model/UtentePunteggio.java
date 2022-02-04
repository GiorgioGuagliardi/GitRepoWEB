package it.mat.unical.webcomp21.serviziuni.model;

public class UtentePunteggio {

	public String utente;
	public Integer punteggio;
	
	public UtentePunteggio(String utente, int punteggio) {
		super();
		this.utente = utente;
		this.punteggio = punteggio;
	}

	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}

	public Integer getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	
}
