package it.uniroma3.diadia;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
    private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	
	public Partita(String nome) throws FileNotFoundException, FormatoFileNonValidoException {
		this(new Labirinto(),nome);
	}
	public Partita(Labirinto labirinto, String nome) throws FileNotFoundException, FormatoFileNonValidoException  {
		this.setLabirinto(new Labirinto());
		this.finita = false;
		this.giocatore = new Giocatore(nome);
	}
	
	public Partita(Labirinto labirinto,String nomeFile, String nome) throws FileNotFoundException, FormatoFileNonValidoException  {
		this.setLabirinto(new Labirinto(nomeFile));
		this.finita = false;
		this.giocatore = new Giocatore(nome);
	}

    /**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getLabirinto().getStanzaCorrente()== this.getLabirinto().getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu()==0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
}
