package Oppgave2;

import java.util.ArrayList;
import java.util.List;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Film;
import filmarkiv.impl.Sjanger;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall; // Antall filmer i arkivet
    private LinearNode<Film> start;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getFilmnr() == nr) { // Bruker data i stedet for film
                return current.data;
            }
            current = current.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm); 
        if (start == null) {
            start = nyNode; 
        } else {
            LinearNode<Film> current = start;
            while (current.neste != null) {
                current = current.neste; 
            }
            current.neste = nyNode; 
        }
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start == null) {
            return false; 
        }

        // Hvis første node skal slettes
        if (start.data.getFilmnr() == filmnr) {
            start = start.neste; 
            antall--;
            return true;
        }

        LinearNode<Film> current = start;
        while (current.neste != null) {
            if (current.neste.data.getFilmnr() == filmnr) {
                current.neste = current.neste.neste; 
                antall--;
                return true;
            }
            current = current.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        List<Film> treff = new ArrayList<>();
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(current.data); 
            }
            current = current.neste;
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        List<Film> treff = new ArrayList<>();
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                treff.add(current.data); 
            }
            current = current.neste;
        }
        return treff.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getSjanger() == sjanger) {
                count++;
            }
            current = current.neste;
        }
        return count;
    }

    @Override
    public int antall() {
        return antall;
    }
}