package obskc.petarp.proizvod;

public class Main {
    public static void main(String[] args) {
        Proizvod first = new Proizvod("  Mlijeko  ", 1.50, 30);
        Proizvod second = new Proizvod("Caj od kamilice", 3.50, 12);
        Proizvod third = new Proizvod("Kruh", 2.00);

        System.out.println(first.opis());
        System.out.println(second.opis());
        System.out.println(third.opis());

        first.prodaj(5);
        second.dodaj(10);
        third.dodaj(20);

        first.setNaziv("Svjeze mlijeko");
        second.setCijena(3.00);

        System.out.println("\nNakon promjena:");
        System.out.println(first.opis());
        System.out.println(second.opis());
        System.out.println(third.opis());

        try {
            first.prodaj(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            new Proizvod("   ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            second.setCijena(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }

        System.out.printf("Vrijednost: %.2f EUR%n",
                second.ukupnaVrijednost());
        System.out.printf("Vrijednost s 20 %% popusta: %.2f EUR%n",
                second.ukupnaVrijednost(20));
        System.out.println("Broj proizvoda: "
                + Proizvod.getProizvodCount());

        System.out.println("Naziv: " + first.getNaziv());
        System.out.println("Sifra: " + first.getSifra());
        System.out.println("Cijena: " + first.getCijena());
        System.out.println("Kolicina: " + first.getKolicina());
    }
}
