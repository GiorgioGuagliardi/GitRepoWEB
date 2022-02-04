package it.mat.unical.webcomp21.serviziuni.persistance.dao;

import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;

public interface SchedaEsercitazioneDAO {

	public SchedaEsercitazione findByPrimaryKey(String id);
	public boolean aggiungiEsercitazione(SchedaEsercitazione schedaEsercitazione);
	public boolean modificaEsercitazione(SchedaEsercitazione schedaEsercitazione);
	public boolean eliminaEsercitazione(SchedaEsercitazione schedaEsercitazione);
}
