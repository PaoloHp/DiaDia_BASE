package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	private String nome;
	private String parametro;
	
	abstract public String esegui(Partita partita);
	
	public String getNome() {
		return this.nome;
	}
	
	
	public String getParametro() {
		return this.parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
}
