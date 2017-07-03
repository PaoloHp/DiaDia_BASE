package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	private String direzione;
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			str.append("Dove vuoi andare? Devi specificare una direzione");
			return str.toString();
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza==null) {
			str.append("Direzione inesistente");
			return str.toString();
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		str.append(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return str.toString();
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
}


