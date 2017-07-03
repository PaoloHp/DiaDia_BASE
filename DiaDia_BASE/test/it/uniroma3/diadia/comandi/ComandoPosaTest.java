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

public class ComandoPosaTest {
	private Partita partita;
	private Stanza stanzaPiena,stanzaVuota;
	private Attrezzo a;
	private Attrezzo[] attrezzi;
	private AbstractComando posa;
	private FabbricaDiComandiRiflessiva factory;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita("prova");
		new Labirinto();
		this.a = new Attrezzo("a",2);
		new Attrezzo("b",3);
		this.attrezzi=new Attrezzo[10];
		this.factory = new FabbricaDiComandiRiflessiva();
		this.posa = factory.costruisciComando("posa");
		
		this.partita.getGiocatore().getInventario().addAttrezzo(a);
		
		this.stanzaVuota = new Stanza("vuota");
		
		this.stanzaPiena = new Stanza("piena");
		for (int i=0; i<attrezzi.length; i++) {
			attrezzi[i]=a;
			this.stanzaPiena.addAttrezzo(a);
		}
		
	}

	@Test
	public void testPosa_Ok() {
		this.partita.getLabirinto().setStanzaCorrente(stanzaVuota);
		posa.setParametro("a");
		posa.esegui(this.partita);
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("a"));
	}
	@Test
	public void testPosa_StanzaPiena() {
		this.partita.getLabirinto().setStanzaCorrente(stanzaPiena);
		posa.setParametro("b");
		posa.esegui(this.partita);
		assertFalse(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("b"));
	}
	@Test
	public void testPosa_AttrezzoInesistente() {
		this.partita.getLabirinto().setStanzaCorrente(stanzaVuota);
		posa.setParametro("b");
		posa.esegui(this.partita);
		assertFalse(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("b"));


	}
	

}
