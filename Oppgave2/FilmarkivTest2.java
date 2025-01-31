package Oppgave2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.*;

class FilmarkivTest2 {

	private FilmarkivADT filmarkiv2;

	@BeforeEach
	void setUp() {
		filmarkiv2 = new Filmarkiv2(); // Oppretter et nytt filmarkiv med plass til 10 filmer¨
		filmarkiv2.leggTilFilm(new Film(1, "Inception", "Christopher Nolan", 2010, Sjanger.ACTION, "Warner Bros"));
		filmarkiv2.leggTilFilm(new Film(2, "Interstellar", "Christopher Nolan", 2014, Sjanger.DRAMA, "Paramount"));
		filmarkiv2.leggTilFilm(new Film(3, "The Dark Knight", "Christopher Nolan", 2008, Sjanger.ACTION, "Warner Bros"));
		filmarkiv2.leggTilFilm(new Film(4, "Finding Nemo", "Andrew Stanton", 2003, Sjanger.ANIMASJON, "Pixar"));
	}

	@Test
	void testFinnFilm() {
		assertNotNull(filmarkiv2.finnFilm(1));
	}

	@Test
	void testLeggTilFilm() {
		Film film5 = new Film(5, "bashar", "fast", 2004, Sjanger.ANIMASJON, "bfe");
		filmarkiv2.leggTilFilm(film5);
		assertEquals(5, filmarkiv2.antall());
		assertEquals(film5, filmarkiv2.finnFilm(5));

	}

	@Test
	void testSlettFilm() {
		assertNotNull(filmarkiv2.finnFilm(2)); // for å sjekke om filmen eksistera
		assertTrue(filmarkiv2.slettFilm(2)); // slette filmen
		assertNull(filmarkiv2.finnFilm(2)); // sjekke om filmen he blitt sletta og retunera null evt.

	}

	@Test
	void testsoekTittel() {
		Film[] result = filmarkiv2.soekTittel("Inception");
		assertEquals(0, result.length);

		Film[] result1 = filmarkiv2.soekTittel("Titanic");
		assertEquals(0, result1.length);
	}

	@Test
	void testsoekProdusent() {
		Film[] produsent = filmarkiv2.soekProdusent("Pixar");
		assertEquals(0, produsent.length);

		Film[] produsent1 = filmarkiv2.soekProdusent("bashar");
		assertEquals(0, produsent1.length);

	}

	@Test
	void testAntall() {
		assertEquals(4, filmarkiv2.antall());

	}

	@Test
	void tetstAntallSjanger() {
		assertEquals(2, filmarkiv2.antall(Sjanger.ACTION)); // finne ut antall filma so he den sjangeren
		assertEquals(1, filmarkiv2.antall(Sjanger.ANIMASJON));

	}

}
