package it.uniroma3.diadia.interfacce;

import java.util.Scanner;


public class InterfacciaUtenteConsole implements InterfacciaUtente {
	private String input;

	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	@Override
	public String prendiIstruzione() {
		@SuppressWarnings("resource")
		Scanner sdl = new Scanner(System.in);
		this.input = sdl.nextLine();
		return input;
	}

}

