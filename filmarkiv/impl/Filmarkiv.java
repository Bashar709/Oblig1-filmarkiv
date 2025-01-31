package filmarkiv.impl;

import java.util.*;

import filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private int antall;
	private Film[] filmer;

	public Filmarkiv(int maksantall) {
		filmer = new Film[maksantall];
		antall = 0;
	}
 
	@Override
	public Film finnFilm(int nr) {
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmnr() == nr) {
				return filmer[i];
 
			}
		}
		return null;
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall < filmer.length) {
			filmer[antall] = nyFilm;
			antall++;
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {		
		for(int i = 0; i < antall; i++) {
			if(filmer[i].getFilmnr() == filmnr) {
				filmer[i] = filmer[antall - 1];
				filmer[antall - 1] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tabell = new Film[filmer.length];
		int antallTreff = 0;

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				tabell[antallTreff] = filmer[i]; // Legg til filmen i resultat-arrayet
				antallTreff++;
			}
		}
	    return Arrays.copyOf(tabell, antallTreff); // Returner kun treffene

	}

	//søke metoda for produsenten, retunere antall treff, 
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] f = new Film[filmer.length];
		int antallTreff = 0;

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				f[antallTreff] = filmer[i]; // Legg til filmen i resultat-arrayet
				antallTreff++;
			}
		}
	    return Arrays.copyOf(f, antallTreff); // Returner kun treffene

	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getSjanger() == sjanger) {
				antall++;
			}
		}
		return antall;
	}

	@Override
	public int antall() {
		return antall;
	}
}
