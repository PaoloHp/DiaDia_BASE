package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 0.1
 */

public class Stanza {
	private String nome;
	private AbstractPersonaggio personaggio;
	private Map<String,Attrezzo> name2item;
	private Map<String,Stanza> dir2room;


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.dir2room = new HashMap<>();
		this.name2item = new HashMap<>();
		this.nome = nome;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
		this.dir2room.put(direzione,stanzaAdiacente);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.dir2room.get(direzione);
	}
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.name2item.values();
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null) {
			this.name2item.put(attrezzo.getNome(), attrezzo);
			return true;
		}
		else
			return false;
	}

	/**
	 * Rimuove un attrezzo dalla stanza.
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */

	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (this.name2item.containsKey(attrezzo.getNome())) {
			this.name2item.remove(attrezzo.getNome());
			return true;
		}
		else
			return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("---------------------------\n");
		str.append("Nome: ");
		str.append(this.nome);
		str.append("\n");
		str.append("---------------------------\n");
		str.append("Porte: ");
		str.append("\n");
		Set<String> porte = this.dir2room.keySet();
		for (String s : porte) {
			str.append(s);
			str.append("\n");
		}
		str.append("---------------------------\n");
		str.append("Attrezzi: ");
		Set<String> oggetti = this.name2item.keySet();
		for (String p : oggetti) {
			str.append(p);
			str.append(": ");
			str.append(this.name2item.get(p).getPeso()+"Kg");
			str.append("\n");
		}
		str.append("---------------------------\n");
		return str.toString();

	}

	/**
	 * Controlla se un attrezzo esiste nella stanza .
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.name2item.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.name2item.get(nomeAttrezzo);
	}

	public boolean isEmpty() {
		return this.getAttrezzi().isEmpty();
	}
	public String[] getDirezioni() {
		return this.dir2room.keySet().toArray(new String[0]);
	}
	//	public String[] getDirezioni() {
	//		String[] direzioni = new String[this.dir2room.size()];
	//		Iterator<String> dirIt = this.dir2room.keySet().iterator();
	//		int i = 0;
	//		while(dirIt.hasNext()) {
	//			String direzione = dirIt.next();
	//			direzioni[i] = direzione;
	//			i++;
	//		}
	//		return direzioni;
	//	}
	
	public Collection<Stanza> getAdiacenti() {
		return this.dir2room.values();
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	public void setPersonaggio(AbstractPersonaggio p) {
		this.personaggio = p;
		
	}
	public boolean hasPersonaggio() {
		return this.personaggio!=null;
	}

}