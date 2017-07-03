package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	final static private String ATTREZZO_TRIGGER = "lanterna";
    private String attrezzoTrigger;
	
	public StanzaBuia(String nome) {
		this(nome, ATTREZZO_TRIGGER);
		
	}

	public StanzaBuia(String nome, String attrezzoTrigger) {
		super(nome);
		this.attrezzoTrigger = attrezzoTrigger;
	}
	@Override
	 public String getDescrizione() {
		String s;
		if (!hasAttrezzo(attrezzoTrigger)) {
			s = "qui c'è buio pesto!";
			return s;
		}
		else 
			return super.getDescrizione();		
	}

}
