package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private static final String MESSAGGIO = "Ghrr..." + "*Il cane ti ha morso e hai perso 1 Cfu!!!*";
	private static final String MESSAGGIO_REWARD = "*Il cane è felice ed ha lasciato cadere qualcosa ai tuoi piedi...*";
	private static final String MESSAGGIO_REFUSE = "*Non è di suo gradimento e lo lascia a terra...*";
	private Attrezzo ciboPreferito;
	private Attrezzo reward;
	
	public Cane(String nome , String presentazione, Attrezzo ciboPreferito, Attrezzo reward) {
		super(nome,presentazione);
		this.ciboPreferito = ciboPreferito;
		this. reward = reward;
	}
	
	public Attrezzo getCibo() {
		return this.ciboPreferito;
	}
	
	public Attrezzo getReward() {
		return this.reward;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		msg = MESSAGGIO;
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		if (attrezzo.equals(this.getCibo())) {
			msg = MESSAGGIO_REWARD;
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.getReward());
		}
		else {
			msg = MESSAGGIO_REFUSE;
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		}
		return msg;			
	}


}
