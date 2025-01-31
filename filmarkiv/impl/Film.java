package filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String produsent;
	private String Tittel;
	private int aar;
	private Sjanger sjanger; // Enum for sjanger
	private String filmeselskap;



	public Film() {
	}

	public Film(int filmnr, String produsent, String tittel, int aar, Sjanger sjanger, String filmeskap) {
		super();
		this.filmnr = filmnr;
		this.produsent = produsent;
		Tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.filmeselskap = filmeskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return Tittel;
	}

	public void setTittel(String tittel) {
		Tittel = tittel;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmeskap() {
		return filmeselskap;
	}

	public void setFilmeskap(String filmeskap) {
		this.filmeselskap = filmeskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Tittel, aar, filmeselskap, filmnr, produsent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(Tittel, other.Tittel) && aar == other.aar
				&& Objects.equals(filmeselskap, other.filmeselskap) && filmnr == other.filmnr
				&& Objects.equals(produsent, other.produsent);
	}

}