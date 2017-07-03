package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	private static final String MESSAGGIO_CON_CHI = "con chi dovrei interagire?...";
	private String messaggio;

	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			str.append(this.messaggio);
		}
		else
			str.append(MESSAGGIO_CON_CHI);
		return str.toString();
	}

	public String getMessaggio() {
		return this.messaggio;
	}
}
