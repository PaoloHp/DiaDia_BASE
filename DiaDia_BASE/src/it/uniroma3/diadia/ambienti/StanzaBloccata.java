package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	final static private String DIREZIONE_BLOCCATA = "nord";
	final static private String ATTREZZO_TRIGGER = "chiave";
	private String direzioneBloccata;
	private String attrezzoTrigger;

	public StanzaBloccata(String nome) {
		this(nome, DIREZIONE_BLOCCATA, ATTREZZO_TRIGGER);
		
	}

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoTrigger) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoTrigger = attrezzoTrigger;
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (!hasAttrezzo(this.attrezzoTrigger))
			return this;
		else 
			return super.getStanzaAdiacente(direzione);
	}
	@Override 
	public String getDescrizione() {
		String s;
		if (!hasAttrezzo(this.attrezzoTrigger)) {
			s = "per sbloccare la direzione:"+" "+ direzioneBloccata +" "+ "serve l'attrezzo:"+" "+ attrezzoTrigger;
			return this.toString()+ " " + s;
		}
		else 
			return super.getDescrizione();		
	}


}
