package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	@Override
	public String esegui (Partita partita) {
		StringBuilder str = new StringBuilder();
		str.append("Spiacente, comando non valido, per conoscere la lista dei comandi disponibili usare il comando aiuto");
		return str.toString();
	}
}
