package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	private Borsa borsaVuota, borsaPiena, borsaProva;
	private Attrezzo a,b,piombo,ps,piuma,libro;
    @Before
	public void setUp() {
		this.a = new Attrezzo("a", 10);
		this.b = new Attrezzo("b", 2);
		
		this.borsaPiena = new Borsa();
		this.borsaPiena.addAttrezzo(a);
		
		this.borsaVuota = new Borsa();
		
		/**
		 * HomeWork-3 esercizio 3
		 */
		this.borsaProva = new Borsa(25);
		this.piombo = new Attrezzo("piombo", 10);
		this.ps = new Attrezzo("ps", 5);
		this.piuma = new Attrezzo("piuma", 1);
		this.libro = new Attrezzo("libro", 5);
        this.borsaProva.addAttrezzo(piombo);
        this.borsaProva.addAttrezzo(ps);
        this.borsaProva.addAttrezzo(piuma);
        this.borsaProva.addAttrezzo(libro);
       

	}

	@Test
	public void testAddAttrezzo_FALSE() {
		assertFalse(this.borsaPiena.addAttrezzo(b));
	}
	@Test
	public void testAddAttrezzo_TRUE() {
		assertTrue(this.borsaVuota.addAttrezzo(a));
	}
	@Test
	public void testRemoveAttrezzo_NULL() {
		assertNull(this.borsaVuota.removeAttrezzo("a"));
	}
	@Test
	public void testRemoveAttrezzo_OK() {
	    assertSame(a, this.borsaPiena.removeAttrezzo("a"));
	}
	@Test
	public void testIsEmpty_TRUE() {
		assertTrue(this.borsaVuota.isEmpty());
	}
	@Test
	public void testIsEmpty_FALSE() {
		assertFalse(this.borsaPiena.isEmpty());
	}
	
	/**
	 * HomeWork-3 esercizio 3
	 */
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		assertEquals("[piuma (1kg), libro (5kg), ps (5kg), piombo (10kg)]", this.borsaProva.getContenutoOrdinatoPerPeso().toString());
	}
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		assertEquals("[libro (5kg), piombo (10kg), piuma (1kg), ps (5kg)]", this.borsaProva.getContenutoOrdinatoPerNome().toString());

	}
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		assertEquals("{1=[piuma (1kg)], 5=[libro (5kg), ps (5kg)], 10=[piombo (10kg)]}", this.borsaProva.getContenutoRaggruppatoPerPeso().toString());
	}
}
