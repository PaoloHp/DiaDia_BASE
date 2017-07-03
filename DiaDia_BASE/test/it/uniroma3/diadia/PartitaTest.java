package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Test;
import org.junit.Before;

public class PartitaTest {
    private Partita partitaVinta, partitaNonVinta, partitaNoCfu;
    private Stanza atrio;
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
	  partitaVinta = new Partita("test");
	  partitaVinta.getLabirinto().setStanzaCorrente(partitaVinta.getLabirinto().getStanzaVincente());
	  
	  partitaNonVinta = new Partita("test");
	  partitaNonVinta.getLabirinto().setStanzaCorrente(atrio);
	  
	  partitaNoCfu = new Partita("test");
	  partitaNoCfu.getGiocatore().setCfu(0);
	}
	@Test
	public void testPartitaVinta_TRUE() {
		assertTrue(this.partitaVinta.vinta());
	}
	@Test
    public void testPartitaVinta_FALSE() {
    	assertFalse(this.partitaNonVinta.vinta());
    }
	@Test
    public void testPartitaFinita_TRUE() {
    	assertTrue(this.partitaVinta.isFinita());
    }
	@Test
    public void testPartitaFinita_NOCFU() {
    	assertTrue(this.partitaNoCfu.isFinita());
    }
	@Test
	public void testPartitaFinita_FALSE() {
		assertFalse(this.partitaNonVinta.isFinita());
	}
}
