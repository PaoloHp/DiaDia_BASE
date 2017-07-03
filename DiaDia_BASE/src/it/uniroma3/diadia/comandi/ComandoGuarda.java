package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		if (this.getParametro()!=null) {
			if (this.getParametro().equals("stanza")) {
				str.append(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			}
			else if (this.getParametro().equals("cfu")) {
				str.append("CFU: ");
				str.append(partita.getGiocatore().getCfu());
			}
			else if (this.getParametro().equals("borsa")) {
				str.append(partita.getGiocatore().getInventario().toString());
			}
			else if (this.getParametro().equals("attrezzi")) {
				str.append(partita.getGiocatore().getInventario().getContenutoOrdinatoPerNome().toString());
			}
			else if (this.getParametro().equals("pesoattrezzi")) {
				str.append(partita.getGiocatore().getInventario().getContenutoOrdinatoPerNome().toString());
			}
			else
				str.append("Parametro inesistente");
		}
		return str.toString();
		}
}
