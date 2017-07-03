package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	private Partita partita;
	private Labirinto labirinto;
	private Stanza current,next;
	private AbstractComando vai;
	private FabbricaDiComandiRiflessiva factory;
	
    @Before
    public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
    	this.partita = new Partita("prova");
    	this.labirinto = new Labirinto();
    	this.current = new Stanza("corrente");
    	this.next = new Stanza("next");
    	this.factory = new FabbricaDiComandiRiflessiva();
    	this.vai = factory.costruisciComando("vai");
    	this.partita.setLabirinto(labirinto);
    	this.labirinto.setStanzaCorrente(current);
    	current.impostaStanzaAdiacente("nord",next);
    	
    }
	@Test
	public void testDirezione_Inesistente() {
		vai.setParametro("sud");
		vai.esegui(this.partita);
		assertEquals(current,this.partita.getLabirinto().getStanzaCorrente());
	}
	@Test
	public void testDirezione_Esistente() {
		vai.setParametro("nord");
		vai.esegui(this.partita);
		assertEquals(next, this.partita.getLabirinto().getStanzaCorrente());
	}
	@Test
	public void testDirezione_NonSpecificata() {
		vai.esegui(this.partita);
		assertEquals(current,this.partita.getLabirinto().getStanzaCorrente());
	}

}

