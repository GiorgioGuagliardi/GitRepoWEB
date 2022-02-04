package it.mat.unical.webcomp21.serviziuni.model;

public class Risposta {

	private int numeroRisposta;
	private String idEsercitazione, risposta;
	
	public int getNumeroRisposta() {
		return numeroRisposta;
	}
	public void setNumeroRisposta(int numeroRisposta) {
		this.numeroRisposta = numeroRisposta;
	}
	
	public String getIdEsercitazione() {
		return idEsercitazione;
	}
	public void setIdEsercitazione(String idEsercitazione) {
		this.idEsercitazione = idEsercitazione;
	}
	
	public String getRisposta() {
		return risposta;
	}
	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}	
}
