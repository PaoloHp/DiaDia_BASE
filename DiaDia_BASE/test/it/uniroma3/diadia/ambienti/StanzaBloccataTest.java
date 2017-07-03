package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	private String porta;
	private Attrezzo chiave;
	private StanzaBloccata stanzaChiusa,stanzaAperta;
	private Stanza adiacente;
	private String s;
	
	@Before
	public void setUp() {

		this.porta = "nord";
		this.chiave = new Attrezzo("chiave",1);
		s = "per sbloccare la direzione:"+" "+ this.porta +" "+ "serve l'attrezzo:"+" "+ this.chiave.getNome();
		this.adiacente = new Stanza("adiacente");
		
		
		this.stanzaChiusa = new StanzaBloccata("chiusa",this.porta,this.chiave.getNome());
		this.stanzaChiusa.impostaStanzaAdiacente(porta,adiacente);
		
		this.stanzaAperta = new StanzaBloccata("chiusa",this.porta,this.chiave.getNome());
		this.stanzaAperta.addAttrezzo(this.chiave);
		this.stanzaAperta.impostaStanzaAdiacente(porta,adiacente);
	}

	@Test
	public void testAdiacente_CHIUSA() {
		assertEquals(this.stanzaChiusa,this.stanzaChiusa.getStanzaAdiacente(porta));
	}
	@Test
	public void testAdiacente_APERTA() {
		assertEquals(this.adiacente,this.stanzaAperta.getStanzaAdiacente(porta));
	}
	@Test
	public void testDescrizione_CHIUSA() {
		assertEquals(this.stanzaChiusa.toString()+" "+s,this.stanzaChiusa.getDescrizione());	
	}
	@Test
	public void testDescrizione_APERTA() {
		assertEquals(this.stanzaAperta.toString(),this.stanzaAperta.getDescrizione());
		
	}

}
