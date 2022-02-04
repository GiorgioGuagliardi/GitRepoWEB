package it.mat.unical.webcomp21.serviziuni.persistance.dao;

import it.mat.unical.webcomp21.serviziuni.model.EsercitazioneCompletata;

public interface EsercitazioneCompletataDAO {

	public boolean findProva(EsercitazioneCompletata esercitazione);
	public boolean salvaProva(EsercitazioneCompletata esercitazione);
}
