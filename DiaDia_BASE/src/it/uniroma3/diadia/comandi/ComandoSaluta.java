package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {
	private String nomePersonaggio;

	@Override
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		if (!partita.getLabirinto().getStanzaCorrente().hasPersonaggio()) {
			str.append("Spiacenti, in questa stanza non c'è nessuno da salutare!");
		}
		else if (partita.getLabirinto().getStanzaCorrente().getPersonaggio().getNome()!=nomePersonaggio) {
			str.append("Spiacenti, ma ");
			str.append(nomePersonaggio);
			str.append(" non è presente in questa stanza!");
		}
		else {
			str.append(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
		}
		return str.toString();
	}

	@Override
	public void setParametro(String parametro) {
		this.nomePersonaggio = parametro;
	}

	@Override
	public String getParametro() {
		return this.nomePersonaggio;
	}
}
