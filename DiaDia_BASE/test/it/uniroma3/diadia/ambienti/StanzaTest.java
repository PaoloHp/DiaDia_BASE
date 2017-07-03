package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private Stanza stanzaPiena, stanzaIsolata, stanzaVuota, stanzaProva; 
	private Attrezzo a;
	
	@Before
	public void setUp() {
		this.stanzaIsolata = new Stanza("isolata");
		
		this.stanzaPiena = new Stanza("piena");
		this.a = new Attrezzo("a" , 2);
		this.stanzaPiena.addAttrezzo(a);

		this.stanzaVuota = new Stanza ("vuota");

		this.stanzaProva = new Stanza ("prova");
		this.stanzaProva.impostaStanzaAdiacente("nord", stanzaPiena);
		this.stanzaProva.impostaStanzaAdiacente("sud", stanzaVuota);
	}

	@Test
	public void testAddAttrezzo_FALSE() {
		assertFalse(this.stanzaPiena.addAttrezzo(null));
	}
	@Test
	public void testAddAttrezzo_TRUE() {
		assertTrue(this.stanzaVuota.addAttrezzo(a));
	}
	@Test
	public void testRemoveAttrezzo_TRUE() {
		assertTrue(this.stanzaPiena.removeAttrezzo(a));
	}
	@Test
	public void testRemoveAttrezzo_FALSE() {
		assertFalse(this.stanzaVuota.removeAttrezzo(a));
	}
	@Test
	public void testIsEmpty_FALSE() {
		assertFalse(this.stanzaPiena.isEmpty());
	}
	@Test
	public void testIsEmpty_TRUE() {
		assertTrue(this.stanzaVuota.isEmpty());
	}
	@Test
	public void testGetStanzaAdiacente() {   // also tests impostaStanzaAdiacente()
		assertEquals(this.stanzaVuota, this.stanzaProva.getStanzaAdiacente("sud"));
		assertEquals(this.stanzaPiena, this.stanzaProva.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetDirezioni() {
		assertEquals("nord", this.stanzaProva.getDirezioni()[1]);
		assertEquals("sud", this.stanzaProva.getDirezioni()[0]);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetDirezioni_NULL() {
		assertEquals(new String[0],this.stanzaIsolata.getDirezioni());
	}
	@Test
	public void testGetAttrezzo() {
		assertEquals(a, this.stanzaPiena.getAttrezzo(a.getNome()));

	}
	@Test
	public void testGetAttrezzo_NULL() {
		assertNull(this.stanzaVuota.getAttrezzo(a.getNome()));
	}
	@Test
	public void testHasAttrezzo_TRUE() {
		assertTrue(this.stanzaPiena.hasAttrezzo(a.getNome()));
	}
	@Test
	public void testHasAttrezzo_FALSE() {
		assertFalse(this.stanzaVuota.hasAttrezzo(a.getNome()));
	}

}
