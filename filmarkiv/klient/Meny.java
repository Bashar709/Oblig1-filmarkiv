package filmarkiv.klient;

import java.util.Scanner;
import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Film;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    private Scanner input;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
        this.input = new Scanner(System.in);
    }

    public void start() {
        boolean fortsett = true;

        while (fortsett) {
            System.out.println("\n==== FILMARKIV ====");
            System.out.println("1. Finn film");
            System.out.println("2. Legg til en ny film");
            System.out.println("3. Slett film: ");
            System.out.println("4. Søk etter film");
            System.out.println("5. Søk etter produsent");
            System.out.println("6. Avslutt");
            System.out.print("Velg et alternativ: ");

            int valg = input.nextInt();
            input.nextLine(); // Fjerner linjeskift etter nextInt()

            switch (valg) {
                case 1:
                    finnFilm();
                    break;
                case 2:
                    leggTilFilm();
                    break;
                case 3:
                	slettFilm();
                    break;
                case 4:
                    søkEtterFilm();
                    break;
                case 5:
                    søkEtterProdusent();
                    break;
                case 6:
                    fortsett = false;
                    System.out.println("Avslutter programmet...");
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }

        input.close();
    }

    private void leggTilFilm() {
        Film nyFilm = tekstgr.lesFilm();
        filmarkiv.leggTilFilm(nyFilm);
        System.out.println("Filmen er lagt til i arkivet!");
        System.out.println("----------------" + "--------------------------");

    }
    private void slettFilm() {
        System.out.print("Skriv inn film-ID du vil slette: ");
        int filmId = input.nextInt();
        input.nextLine(); // Fjerner linjeskift etter nextInt()

        boolean slettet = filmarkiv.slettFilm(filmId);
        
        if (slettet) {
            System.out.println("Filmen med ID " + filmId + " er slettet.");
        } else {
            System.out.println("Fant ingen film med ID " + filmId + ".");
        }
        System.out.println("----------------" + "--------------------------");
    }


    private void finnFilm() {
        System.out.print("Skriv inn film-ID: ");
        int filmId = input.nextInt();
        input.nextLine();
        Film film = filmarkiv.finnFilm(filmId);
        if (film != null) {
            tekstgr.skrivUtFilm(film);
        } else {
            System.out.println("Fant ingen film med ID " + filmId);
        }
        System.out.println("----------------" + "--------------------------");

    }

    private void søkEtterFilm() {
        System.out.print("Skriv inn tittel: ");
        String tittel = input.nextLine();
        Film[] filmer = filmarkiv.soekTittel(tittel);
        if (filmer.length == 0) {
            System.out.println("Ingen filmer funnet med denne tittelen.");
        } else {
            for (Film film : filmer) {
                tekstgr.skrivUtFilm(film);
            }
        }
        System.out.println("----------------" + "--------------------------");

    }

    private void søkEtterProdusent() {
        System.out.print("Skriv inn produsentens navn: ");
        String produsent = input.nextLine();
        Film[] filmer = filmarkiv.soekProdusent(produsent);
        if (filmer.length == 0) {
            System.out.println("Ingen filmer funnet med denne produsenten.");
        } else {
            for (Film film : filmer) {
                tekstgr.skrivUtFilm(film);
            }
        }
        System.out.println("----------------" + "--------------------------");

    }
}
