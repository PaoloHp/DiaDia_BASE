package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " + 
			"con una mia magica azione, troverai un nuovo oggetto " + 
			"per il tuo bel borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho più nulla...";
	private static final String MESSAGGIO_REWARD = "Come premio per la tua gentilezza dimezzerò il peso di questo dono";
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome,presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (attrezzo != null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		msg = MESSAGGIO_REWARD;
		attrezzo = this.modificaAttrezzo(attrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		return msg;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		int halfPeso = attrezzo.getPeso()/2;
		attrezzo = new Attrezzo(attrezzo.getNome(), halfPeso);
		return attrezzo;
	}

}
