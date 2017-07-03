package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {
	private Labirinto l;
	private Partita p;
	
	@Before
	public void setUp() {
		try {
		this.l = new Labirinto("labirinto.txt");
		this.p = new Partita(l,"labirinto.txt","p");
		} catch (FileNotFoundException | FormatoFileNonValidoException e) {
			System.out.println(e);
			return;
		}
	}

	@Test(expected =java.io.FileNotFoundException.class)
	public void testFile_INESISTENTE() throws FileNotFoundException, FormatoFileNonValidoException {
		{
			new Labirinto("fnf.txt");
		}
	}

	@Test
	public void testFile_ADIACENTE() {
		assertEquals("biblioteca", this.p.getLabirinto().getStanzaCorrente().getStanzaAdiacente("sud").getNome());
	}
	
	@Test
	public void testFile_ATTREZZO() {
		assertTrue(this.p.getLabirinto().getStanzaCorrente().hasAttrezzo("pinza"));
	}
	
	@Test
	public void testFile_VINCENTE() {
	this.p.getLabirinto().setStanzaCorrente(this.p.getLabirinto().getStanzaVincente());
	assertTrue(this.p.vinta());
	}
	
}
