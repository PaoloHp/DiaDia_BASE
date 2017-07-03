package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza current;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.current = new Stanza("prova");
	    this.labirinto.setStanzaCorrente(current);
	}

	@Test
	public void testCorrente() {
		assertEquals(current, this.labirinto.getStanzaCorrente());
	}

}
