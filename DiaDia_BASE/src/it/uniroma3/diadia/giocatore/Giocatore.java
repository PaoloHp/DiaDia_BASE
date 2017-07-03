package it.uniroma3.diadia.giocatore;




/**
 * Questa classe gestisce i CFU del giocatore e ne memorizza gli attrezzi nella Borsa
 * @author Paolo Accaputo
 * @see Borsa
 */

public class Giocatore {
	private int cfu;
	private static int CFU_INIZIALI = 20;
	private String nome;
	Borsa inventario;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.cfu = CFU_INIZIALI;
		this.inventario = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getInventario() {
		return this.inventario;
	}
	
	public String getNome() {
		return this.nome;
	}
	public boolean IsVivo() {
		if (this.cfu==0)
			return false;
		else 
			return true;
	}

}
