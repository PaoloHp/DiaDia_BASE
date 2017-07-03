package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	private StanzaBuia stanzaBuia,stanzaIlluminata;
	private Attrezzo lanterna;
	
	@Before
	public void setUp() {
		this.lanterna = new Attrezzo ("lanterna",2);

		this.stanzaBuia = new StanzaBuia("cantina",this.lanterna.getNome());

		this.stanzaIlluminata = new StanzaBuia("giardino",this.lanterna.getNome());
		this.stanzaIlluminata.addAttrezzo(this.lanterna);
	}
  
	@Test
	public void testDescrizione_NOTRIGGER() {
		assertEquals("qui c'è buio pesto!", this.stanzaBuia.getDescrizione());
	}
	@Test
	public void testDescrizione_TRIGGER() {
		assertEquals(this.stanzaIlluminata.toString(), this.stanzaIlluminata.getDescrizione());
		
	}

}
