package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_OFFESA = "Sei un vero maleducato, " +
			"per questo nella stanza peggiore verrai mandato!";
	private static final String MESSAGGIO_AMICHEVOLE = "Grazie per avermi salutato, " +
			"per questo nella stanza migliore sarai inviato!";
	private static final String MESSAGGIO_RISA = "Muahahahahahah!";
	public Strega(String nome, String presentazione) {
		super(nome,presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (!this.haSalutato()) {
			Stanza peggiore = null;
			int min = 100;
			for (Stanza p : partita.getLabirinto().getStanzaCorrente().getAdiacenti()) {
				if (p.getAttrezzi().size() < min) {
					min = p.getAttrezzi().size();
					peggiore = p;
				}
			}
			partita.getLabirinto().setStanzaCorrente(peggiore);
			msg = MESSAGGIO_OFFESA;	
		}
		else {
			Stanza migliore = null;
			int max = 0;
			for (Stanza m : partita.getLabirinto().getStanzaCorrente().getAdiacenti()) {
				if (m.getAttrezzi().size() > max) {
					max = m.getAttrezzi().size();
					migliore = m;
				}
			}
			partita.getLabirinto().setStanzaCorrente(migliore);
			msg = MESSAGGIO_AMICHEVOLE;
		}
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		msg=MESSAGGIO_RISA;
		return msg;
		
	}

}
