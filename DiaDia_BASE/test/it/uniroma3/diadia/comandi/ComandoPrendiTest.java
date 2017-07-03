package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {
	private Partita partita,p;
	private Stanza current,cor;
	private Attrezzo a,b;
	private AbstractComando prendi;
	private FabbricaDiComandiRiflessiva factory;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita("prova");
		new Labirinto();
		this.current = new Stanza("corrente");
		this.a = new Attrezzo("a", 6);
		this.b = new Attrezzo("b",7);
		this.factory = new FabbricaDiComandiRiflessiva();
		this.prendi = factory.costruisciComando("prendi");
		this.partita.getLabirinto().setStanzaCorrente(current);
		current.addAttrezzo(a);		
		
		this.p = new Partita("p");
		this.cor = new Stanza("cor");
		this.p.getLabirinto().setStanzaCorrente(cor);
		this.p.getGiocatore().getInventario().addAttrezzo(a);
		cor.addAttrezzo(b);
	}

	@Test
	public void testPrendi_Ok() {
		prendi.setParametro("a");
		prendi.esegui(this.partita);
		assertFalse(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("a"));
		
	}
	@Test
	public void testPrendi_AttrezzoNonPresente() {
		prendi.setParametro("b");
		prendi.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getInventario().hasAttrezzo("b"));
		
	}
	@Test
	public void testPrendi_InventarioPieno() {
			prendi.setParametro("b");
			prendi.esegui(this.partita);
			assertTrue(this.p.getLabirinto().getStanzaCorrente().hasAttrezzo("b"));
			

	}
}

