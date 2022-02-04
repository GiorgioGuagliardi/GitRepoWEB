package it.mat.unical.webcomp21.serviziuni.persistance.dao;

import java.util.List;

import it.mat.unical.webcomp21.serviziuni.model.Risposta;
import it.mat.unical.webcomp21.serviziuni.model.SchedaEsercitazione;

public interface RispostaDAO {

	public List<Risposta> findRisposte(String id);
	public boolean aggiungiRisposta(Risposta risposta);
	public boolean eliminaRisposte(Risposta risposta);
	public boolean modificaRisposte(Risposta risposta);
	public boolean eliminaRisposteAll(String id);
}
