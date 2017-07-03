package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
    private Giocatore giocatore;
    private Borsa borsa;
    
    @Before
    public void setUp() {
    	this.giocatore = new Giocatore("giocatore");
    	this.borsa = new Borsa();
    	this.giocatore.inventario = borsa;
    	this.giocatore.setCfu(5);
    }
	
    @Test
	public void testNome() {
		assertEquals("giocatore", this.giocatore.getNome());
	}
    @Test
    public void testCfu() {
    	assertEquals(5, this.giocatore.getCfu());
    }
    @Test
    public void testInventario() {
    	assertEquals(borsa, this.giocatore.getInventario());
    }

}
