package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	private String nomeAttrezzo;
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		Attrezzo preso = null;
    	if (partita.getGiocatore().getInventario().getPeso()>=partita.getGiocatore().getInventario().getPesoMax())
    		str.append("Inventario pieno!");
    	else if (!partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
    		str.append("Impossibile raccogliere oggetti non presenti nella stanza");
    	}
    	else 
    	{
    		preso = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
    		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(preso);
    		partita.getGiocatore().getInventario().addAttrezzo(preso);	
    		str.append("oggetto preso: ");
    		str.append(nomeAttrezzo);
    	}
    	return str.toString();
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
