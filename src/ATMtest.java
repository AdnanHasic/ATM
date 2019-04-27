import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ATMtest {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader unos = new BufferedReader(new InputStreamReader(System.in));

		Racun noviRacun = null;

		List<Racun> listaNovihRacuna = new ArrayList<>();

		Korisnik noviKorisnik = null;

		ispisMenija();

		int izborMenija = Integer.parseInt(unos.readLine());

		do {
			switch (izborMenija) {

			case 1:

				System.out.println("Unesite ime i prezime : ");
				String imeIprezime = unos.readLine();

				System.out.println("Unesite adresu : ");
				String adresa = unos.readLine();

				System.out.println("Unesite broj telefona : ");
				String brojTelefona = unos.readLine();

				int brojRacuna = (int) (Math.random() * 900000000 + 100000000);
				System.out.println("Zapamtite Vas broj racuna :" + brojRacuna);

				int pinKod = (int) (Math.random() * 9000 + 1000);
				System.out.println("Zapamtite Vas pin kod : " + pinKod);

				System.out.println("Unesite stanje na racunu : ");
				double stanjeNaRacunu = Double.parseDouble(unos.readLine());

				noviKorisnik = new Korisnik(imeIprezime, adresa, brojTelefona);

				noviRacun = new Racun(brojRacuna, pinKod, stanjeNaRacunu, noviKorisnik);

				if (!noviRacun.provjeraDaLiImaKreiranRacunSaIstimBrojem(brojRacuna, listaNovihRacuna)
						&& stanjeNaRacunu > 0) {

					listaNovihRacuna.add(noviRacun);

				} else {
					System.out.println("Vec postoji korisnik sa brojem racuna " + brojRacuna
							+ "\n ili Vam je stanje racuna negativno");
				}

				ispisMenija();

				izborMenija = Integer.parseInt(unos.readLine());

				break;

			case 2:
				if (listaNovihRacuna.isEmpty()) {

					System.out.println("Nema kreiranih racuna, izaberite drugu opciju : ");

					ispisMenija();

					izborMenija = Integer.parseInt(unos.readLine());

					continue;

				}
				noviRacun.ispisListeKreiranihRacuna(listaNovihRacuna);

				ispisMenija();

				izborMenija = Integer.parseInt(unos.readLine());

				break;

			case 3:

				System.out.println("Unesite Vase ime i prezime : ");
				String imeIPrezimePosiljaoca = unos.readLine();

				System.out.println("Unesite Vas pin kod : ");
				pinKod = Integer.parseInt(unos.readLine());

				if (!noviRacun.provjeraPinKodaIImena(imeIPrezimePosiljaoca, pinKod, listaNovihRacuna)) {
					System.out.println("Unijeli ste pogresan pin kod ili ime, krenite ponovo :");
					ispisMenija();

					izborMenija = Integer.parseInt(unos.readLine());
					break;
				}

				System.out.println("Unesite broj racuna sa kojeg zelite poslati novac : ");
				int sourceRacun = Integer.parseInt(unos.readLine());

				System.out.println("Unesite broj racuna na koji zelite poslati novac : ");
				int targetRacun = Integer.parseInt(unos.readLine());

				System.out.println("Unesite iznos : ");
				double iznos = Double.parseDouble(unos.readLine());

				if (noviRacun.provjeraDaLiImaKreiranRacunSaIstimBrojem(sourceRacun, listaNovihRacuna)
						&& noviRacun.provjeraDaLiImaKreiranRacunSaIstimBrojem(targetRacun, listaNovihRacuna)) {

					noviRacun.prenosNovca(sourceRacun, targetRacun, iznos, listaNovihRacuna);
				} else {
					System.out.println("Pokusajte ponovo !");
				}
				ispisMenija();

				izborMenija = Integer.parseInt(unos.readLine());

				break;
			}

		} while (izborMenija != 0);

	}

	public static void ispisMenija() {

		String[] noviNiz = new String[4];

		noviNiz[0] = "\nBirajte 1 za kreiranje racuna : ";

		noviNiz[1] = "Birajte 2 za ispis detalja postojecih racuna : ";

		noviNiz[2] = "Birajte 3 za transakciju : ";

		noviNiz[3] = "Birajte 0 za izlaz iz programa : ";

		for (int i = 0; i < noviNiz.length; i++) {
			System.out.println(noviNiz[i]);
		}
		for (int i = 0; i < 23; i++) {
			System.out.print("=" + " ");
		}
	}

}
