package obskc.petarp.proizvod;

public class Proizvod {
    private static int proizvodCount = 0;

    private final String sifra;
    private String naziv;
    private double cijena;
    private int kolicina;

    // konstruktor
    public Proizvod(String naziv, double cijena, int kolicina) {
        setNaziv(naziv);
        setCijena(cijena);
        checkCount(kolicina);
        this.kolicina = kolicina;

        proizvodCount++;
        this.sifra = "P" + String.format("%03d", proizvodCount);
    }

    public Proizvod(String naziv, double cijena) {
        this(naziv, cijena, 0);
    }

    // getter
    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    // setter
    public void setNaziv(String naziv) {
        if (naziv == null || naziv.isBlank()) {
            throw new IllegalArgumentException("Naziv ne smije biti prazan.");
        }

        this.naziv = naziv.strip();
    }

    public void setCijena(double cijena) {
        if (Double.isNaN(cijena) || Double.isInfinite(cijena) || cijena < 0) {
            throw new IllegalArgumentException("Cijena ne moze biti negativna ili neispravna.");
        }

        this.cijena = cijena;
    }

    // samostalna validacijska metoda
    private void checkCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Kolicina ne moze biti negativna.");
        }
    }

    // dodavanje i prodaja
    public void dodaj(int kolicina) {
        checkCount(kolicina);
        if (kolicina > Integer.MAX_VALUE - this.kolicina) {
            throw new IllegalArgumentException("Kolicina je prevelika.");
        }
        this.kolicina += kolicina;
    }

    public void prodaj(int kolicina) {
        checkCount(kolicina);

        if (kolicina > this.kolicina) {
            throw new IllegalArgumentException("Nema dovoljno proizvoda.");
        }

        this.kolicina -= kolicina;
    }

    // ukupna vrijednost
    public double ukupnaVrijednost() {
        return cijena * kolicina;
    }

    public double ukupnaVrijednost(double popust) {
        if (Double.isNaN(popust) || popust < 0 || popust > 100) {
            throw new IllegalArgumentException("Popust mora biti izmedu 0 i 100.");
        }

        return ukupnaVrijednost() * (1 - popust / 100);
    }

    // opis proizvoda
    public String opis() {
        return sifra + " | " + naziv + " | "
                + String.format("%.2f", cijena) + " EUR | "
                + kolicina + " kom";
    }

    // broj proizvoda
    public static int getProizvodCount() {
        return proizvodCount;
    }
}
