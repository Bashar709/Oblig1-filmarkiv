package filmarkiv.klient;

import filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {
	public static void main(String[] args) {
		Filmarkiv filma = new Filmarkiv(100);
		
		Meny meny = new Meny(filma);
		meny.start();
        System.out.println("\nProgrammet er avsluttet. Ha en fin dag!");

	}
}
