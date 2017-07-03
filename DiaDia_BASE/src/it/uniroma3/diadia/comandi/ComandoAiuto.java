package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	private String[] elencoComandi = DiaDia.getElencoComandi();
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) {
			str.append(elencoComandi[i]);
			str.append(", ");

		}
		return str.toString();
	}
}