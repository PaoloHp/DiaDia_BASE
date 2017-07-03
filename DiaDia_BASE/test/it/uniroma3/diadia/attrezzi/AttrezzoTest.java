package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class AttrezzoTest {
    private Attrezzo attrezzo;
    
    @Before
    public void setUp() {
    	this.attrezzo = new Attrezzo ("randomitem" , 5) ;
    }
    
    @Test
	public void testNome() {
		assertEquals("randomitem" , this.attrezzo.getNome());
	}
    @Test
    public void  testPeso() {
    	assertEquals(5 , this.attrezzo.getPeso() );
    }
    @Test
    public void testStampa() {
    	assertEquals("randomitem"+ " ("+"5"+"kg)" , this.attrezzo.toString());
    }
}   

