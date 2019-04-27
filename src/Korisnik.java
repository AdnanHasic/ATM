
public class Korisnik {

	private String imeIPrezime;
	private String adresa;
	private String brojTelefona;

	public Korisnik(String imeIPrezime, String adresa, String brojTelefona) {
		this.imeIPrezime = imeIPrezime;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIprezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	@Override
	public String toString() {
		return "Korisnik{" + "imeIPrezime='" + imeIPrezime + '\'' + ", adresa='" + adresa + '\'' + ", brojTelefona='"
				+ brojTelefona + '\'' + '}';
	}
}
