package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	private String nomeAttrezzo;
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		Attrezzo posato = null;
		if (!partita.getGiocatore().getInventario().hasAttrezzo(nomeAttrezzo))
			str.append("Non possiedi questo attrezzo!");
		else  {
			posato = partita.getGiocatore().getInventario().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getInventario().removeAttrezzo(posato.getNome());
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(posato);
			str.append("oggetto posato: ");
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
