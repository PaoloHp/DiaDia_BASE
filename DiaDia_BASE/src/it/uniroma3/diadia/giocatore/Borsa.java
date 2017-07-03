package it.uniroma3.diadia.giocatore;
/**
 * Classe che modella l'inventario di un oggetto istanza della classe giocatore.
 * @author Paolo Accaputo
 */
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.WeightComparator;

import java.util.*;

public class Borsa {
	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;
	private int peso;
	private static final int DEFAULT_PESO_MAX = 10;

	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX;
		this.peso = 0;
		this.attrezzi = new HashMap<>();
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.peso = 0;
		this.attrezzi = new HashMap<>(); 
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.peso + attrezzo.getPeso() > this.pesoMax)
			return false;
		else {
			this.attrezzi.put(attrezzo.getNome(),attrezzo);
			this.peso=+attrezzo.getPeso();
			return true;}    
	}
	/**
	 * Rimuove l'attrezzo desiderato dalla borsa (ricerca per nome)
	 * @param nomeAttrezzo
	 * @return l'attrezzo se rimosso correttamente, null altrimenti
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}
	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	public int getPeso() {
		return this.peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo (String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> tmp;
		tmp = new ArrayList<Attrezzo>();
		tmp.addAll(this.attrezzi.values());
		WeightComparator wc = new WeightComparator();
		Collections.sort(tmp,wc);
		return tmp;
	}

	public List<Attrezzo> getContenutoOrdinatoPerNome() {
		List<Attrezzo> tmp;
		tmp = new ArrayList<Attrezzo>();
		tmp.addAll(this.attrezzi.values());
		Collections.sort(tmp);
		return tmp;
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> tmp;
		Map<Integer,Set<Attrezzo>> mappa;
		mappa = new HashMap<Integer,Set<Attrezzo>>();
		for (String nomeAttrezzo:this.attrezzi.keySet()) {
			if (mappa.containsKey(this.attrezzi.get(nomeAttrezzo).getPeso())) {
				tmp = mappa.get(this.attrezzi.get(nomeAttrezzo).getPeso());
				tmp.add(this.attrezzi.get(nomeAttrezzo));
			}
			else {
				tmp = new HashSet<Attrezzo>();
				tmp.add(this.attrezzi.get(nomeAttrezzo));
				mappa.put(this.attrezzi.get(nomeAttrezzo).getPeso(),tmp);
			}
		}
		return mappa;

	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("--------------------------\n");
		str.append("Peso massimo trasportabile");
		str.append(": ");
		str.append(this.pesoMax);
		str.append("\n---------------------------\n");
		str.append("Peso corrente");
		str.append(": ");
		str.append(this.peso);
		str.append("\n---------------------------\n");
		str.append("Attrezzi contenuti\n");
		Set<String> oggetti = this.attrezzi.keySet();
		for (String s : oggetti) {
			str.append(s);
			str.append(": ");
			str.append(this.attrezzi.get(s).getPeso()+"Kg");
			str.append("\n");
		}
		str.append("---------------------------\n");
		return str.toString();
	}
}

