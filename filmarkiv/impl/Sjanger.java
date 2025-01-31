package filmarkiv.impl;

public enum Sjanger {
	ACTION, SKREKK, DRAMA, KOMEDIE, ROMANTIKK, SCIFI, EVENTYR, ANIMASJON, FANTASY, ROMANSE, KRIM, MUSIKAL, SHREK,
	THRILLER, DOKUMENTAR;

	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}
}
