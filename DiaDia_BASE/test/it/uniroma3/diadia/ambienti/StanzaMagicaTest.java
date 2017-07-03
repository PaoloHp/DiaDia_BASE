package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	private StanzaMagica stanzaAttiva,stanzaInattiva;
	private Attrezzo a;
	
	@Before
	public void setUp() {
		this.a = new Attrezzo("ab",1);
		
		this.stanzaAttiva = new StanzaMagica("attiva",0);
		this.stanzaAttiva.addAttrezzo(a);
		
		this.stanzaInattiva = new StanzaMagica("inattiva");
		this.stanzaInattiva.addAttrezzo(a);
	}

	@Test
	public void testNomeAttrezzo_MODIFICATO() {
		assertEquals("ba", stanzaAttiva.getAttrezzo("ba").getNome());
	}
	@Test
	public void testNomeAttrezzo_NORMALE() {
		assertEquals("ab" , this.stanzaInattiva.getAttrezzo(this.a.getNome()).getNome());
		
	}
	@Test
	public void testPesoAttrezzo_MODIFICATO() {
		assertEquals(2 , this.stanzaAttiva.getAttrezzo("ba").getPeso());
	}
	@Test
	public void testPesoAttrezzo_NORMALE() {
		assertEquals(1 , this.stanzaInattiva.getAttrezzo(this.a.getNome()).getPeso());
	}

}
