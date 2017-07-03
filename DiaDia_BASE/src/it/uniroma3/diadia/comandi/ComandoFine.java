package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		str.append("Grazie di aver giocato!");  //si desidera smettere
		return str.toString();
	}

}
