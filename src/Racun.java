import java.util.Date;
import java.util.List;

public class Racun {

	private int brojRacuna;
	private int pinKod;
	private double stanjeNaRacunu;
	private Korisnik noviKorisnik;

	public Racun() {

	}

	public Racun(int brojRacuna, int pinKod, double stanjeNaRacunu, Korisnik noviKorisnik) {

		this.brojRacuna = brojRacuna;
		this.pinKod = pinKod;
		this.stanjeNaRacunu = stanjeNaRacunu;
		this.noviKorisnik = noviKorisnik;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public double getStanjeNaRacunu() {
		return stanjeNaRacunu;
	}

	public void setStanjeNaRacunu(double stanjeNaRacunu) {
		this.stanjeNaRacunu = stanjeNaRacunu;
	}

	public Korisnik getNoviKorisnik() {
		return noviKorisnik;
	}

	public void setNoviKorisnik(Korisnik noviKorisnik) {
		this.noviKorisnik = noviKorisnik;
	}

	public int getPinKod() {
		return pinKod;
	}

	public void setPinKod(int pinKod) {
		this.pinKod = pinKod;
	}

	public void ispisListeKreiranihRacuna(List<Racun> listaNovihRacuna) {

		System.out.println(new Date());
		for (int i = 0; i < listaNovihRacuna.size(); i++) {
			System.out.println(listaNovihRacuna.get(i));
		}
		for (int i = 0; i < 23; i++) {
			System.out.print("=" + " ");
		}
	}

	public boolean provjeraDaLiImaKreiranRacunSaIstimBrojem(int brojRacuna, List<Racun> listaNovihRacuna) {
		for (int i = 0; i < listaNovihRacuna.size(); i++) {
			if (listaNovihRacuna.get(i).getBrojRacuna() == brojRacuna) {
				return true;
			}
		}
		return false;
	}

	public void prenosNovca(int sourceBrojRacuna, int targetBrojRacuna, double iznos, List<Racun> listaNovihRacuna) {

		for (int i = 0; i < listaNovihRacuna.size(); i++) {
			if (listaNovihRacuna.get(i).getBrojRacuna() == sourceBrojRacuna) {
				if (listaNovihRacuna.get(i).getStanjeNaRacunu() >= 0
						&& (listaNovihRacuna.get(i).getStanjeNaRacunu() - iznos) >= 0) {
					listaNovihRacuna.get(i).setStanjeNaRacunu(listaNovihRacuna.get(i).getStanjeNaRacunu() - iznos);
				} else {
					System.out.println("Pokusajte ponovo !");
					return;
				}
				break;
			}
		}
		for (int j = 0; j < listaNovihRacuna.size(); j++) {
			if (listaNovihRacuna.get(j).getBrojRacuna() == targetBrojRacuna) {
				listaNovihRacuna.get(j).setStanjeNaRacunu(listaNovihRacuna.get(j).getStanjeNaRacunu() + iznos);
			}
		}
	}

	public boolean provjeraPinKodaIImena(String imeIPrezime, int pinKod, List<Racun> listaNovihRacuna) {
		for (int i = 0; i < listaNovihRacuna.size(); i++) {
			if (noviKorisnik.getImeIPrezime().equalsIgnoreCase(imeIPrezime)) {
				if (listaNovihRacuna.get(i).getPinKod() == pinKod) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%-18s%16s%-18s%16s%-18s%16s%-18s%16d%-18s%16s%-18s%13.2f", "\nIme i prezime : ",
				noviKorisnik.getImeIPrezime(), "\nadresa : ", noviKorisnik.getAdresa(), "\nbroj telefona : ",
				noviKorisnik.getBrojTelefona(), "\nbrojRacuna : ", this.brojRacuna, "\npinKod : ", "****",
				"\nstanjeNaRacunu KM : ", this.stanjeNaRacunu);

	}
}
