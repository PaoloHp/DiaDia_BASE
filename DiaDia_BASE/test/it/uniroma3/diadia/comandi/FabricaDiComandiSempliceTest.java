//package it.uniroma3.diadia.comandi;
//
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//
//public class FabricaDiComandiSempliceTest {
//	private Comando aiuto,fine,invalid,posa,prendi,vai;
//	private FabricaDiComandiSemplice factory;
//	
//	@Before
//	public void setUp() {
//		this.factory = new FabricaDiComandiSemplice();
//		this.aiuto = factory.costruisciComando("aiuto");
//		this.fine = factory.costruisciComando("fine");
//		this.invalid = factory.costruisciComando("invalid");
//		this.posa = factory.costruisciComando("posa");
//		this.prendi = factory.costruisciComando("prendi");
//		this.vai = factory.costruisciComando("vai");
//
//			
//		
//	}
//
//	@Test
//	public void testComando_Aiuto() {
//		assertEquals("aiuto",this.aiuto.getNome());
//	}
//	@Test
//	public void testComando_Fine() {
//		assertEquals("fine",this.fine.getNome());
//
//	}
//	@Test
//	public void testComando_NonValido() {
//		assertEquals("non valido",this.invalid.getNome());
//
//	}
//	@Test
//	public void testComando_Posa() {
//		assertEquals("posa",this.posa.getNome());
//
//	}
//	@Test
//	public void testComando_Prendi() {
//		assertEquals("prendi",this.prendi.getNome());
//
//	}
//	@Test
//	public void testComando_Vai() {
//		assertEquals("vai",this.vai.getNome());
//	}
//
//}
