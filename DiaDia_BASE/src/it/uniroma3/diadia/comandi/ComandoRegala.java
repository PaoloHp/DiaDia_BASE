package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	private String nomeAttrezzo;

	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		Attrezzo regalo = null;
		if (!partita.getGiocatore().getInventario().hasAttrezzo(nomeAttrezzo)) {
			str.append("Spiacenti, non possiedi questo attrezzo...");
		}
		else {
			regalo = partita.getGiocatore().getInventario().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getInventario().removeAttrezzo(nomeAttrezzo);
			partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(regalo,partita);
			str.append("Oggetto regalato: ");
			str.append(nomeAttrezzo);
		}
		return str.toString();
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
