package bresciani.paleocapa.it;

import java.time.LocalDate;
import java.util.Random;

public class Volo {
    private String codiceVolo;
    private String aeroportoPartenza;
    private String aeroportoArrivo;
    private LocalDate dataVolo;
    private String oraPartenza;
    private String oraArrivo;
    private int numeroPosti;
    private double costoVolo;

    private static int contatoreCodiceVolo = 1; // Contatore per il codice del volo

    public Volo(String codiceVolo,String aeroportoPartenza, String aeroportoArrivo, LocalDate dataVolo,
                String oraPartenza, String oraArrivo, int numeroPosti) {
        this.aeroportoPartenza = aeroportoPartenza;
        this.aeroportoArrivo = aeroportoArrivo;
        this.dataVolo = dataVolo;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.numeroPosti = numeroPosti;
        this.codiceVolo = codiceVolo;
        this.costoVolo = generaCostoVolo();
        contatoreCodiceVolo++; // Incremento del contatore
    }
    
    public double generaCostoVolo() {
        Random random = new Random();
        double costo = 100 + random.nextDouble() * 200; // Genera un costo casuale tra 100 e 300
        return Math.round(costo * 100) / 100.0; // Arrotonda il costo a due cifre decimali
    }


    // Getters and setters

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public String getAeroportoPartenza() {
        return aeroportoPartenza;
    }

    public void setAeroportoPartenza(String aeroportoPartenza) {
        this.aeroportoPartenza = aeroportoPartenza;
    }

    public String getAeroportoArrivo() {
        return aeroportoArrivo;
    }

    public void setAeroportoArrivo(String aeroportoArrivo) {
        this.aeroportoArrivo = aeroportoArrivo;
    }

    public LocalDate getDataVolo() {
        return dataVolo;
    }

    public void setDataVolo(LocalDate dataVolo) {
        this.dataVolo = dataVolo;
    }

    public String getOraPartenza() {
        return oraPartenza;
    }

    public void setOraPartenza(String oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public String getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(String oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public double getCostoVolo() {
        return costoVolo;
    }

    public void setCostoVolo(double costoVolo) {
        this.costoVolo = costoVolo;
    }

     public int getNumeroVoli() {
        return contatoreCodiceVolo;
    }
    

    @Override
    public String toString() {
        return "Volo{" +
                "codiceVolo='" + codiceVolo + "" +
                ", aeroportoPartenza='" + aeroportoPartenza + "" +
                ", aeroportoArrivo='" + aeroportoArrivo + "" +
                ", dataVolo=" + dataVolo +
                ", oraPartenza='" + oraPartenza + "" +
                ", oraArrivo='" + oraArrivo + "" +
                ", numeroPosti=" + numeroPosti +
                ", costoVolo=" + costoVolo +
                '}';
    }




    public static void main(String[] args) {
        Volo volo = new Volo("aze33","Aeroporto A", "Aeroporto B", LocalDate.now(), "10:00", "12:00", 100);

        // Stampa i dati del volo
        System.out.println("Codice volo: " + volo.getCodiceVolo());
        System.out.println("Aeroporto di partenza: " + volo.getAeroportoPartenza());
        System.out.println("Aeroporto di arrivo: " + volo.getAeroportoArrivo());
        System.out.println("Data del volo: " + volo.getDataVolo());
        System.out.println("Ora di partenza: " + volo.getOraPartenza());
        System.out.println("Ora di arrivo: " + volo.getOraArrivo());
        System.out.println("Numero di posti: " + volo.getNumeroPosti());
        System.out.println("Costo del volo: " + volo.getCostoVolo()+"€");
    }
}