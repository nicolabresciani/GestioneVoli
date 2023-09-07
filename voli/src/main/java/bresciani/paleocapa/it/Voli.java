package bresciani.paleocapa.it;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Voli {

    public LinkedList<Volo> voli = new LinkedList<>();
    
    public void aggiungiVolo(Volo volo) {
        voli.add(volo);
    }
    public void rimuoviVolo(Volo volo) {
        voli.remove(volo);
    }
    public void rimuoviVoloCodice(String codiceVolo) {
        Iterator<Volo> iterator = voli.iterator();
        while (iterator.hasNext()) {
            Volo volo = iterator.next();
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                iterator.remove();
                break;
            }
        }
    }
    public void stampaVoli() {
        for (Volo volo : voli) {
            System.out.println(volo);
        }
    }
    
    public void modificaVolo(String codiceVolo, String aeroportoPartenza, String aeroportoArrivo, LocalDate dataVolo, String oraPartenza, String oraArrivo, int numeroPosti) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                volo.setAeroportoPartenza(aeroportoPartenza);
                volo.setAeroportoArrivo(aeroportoArrivo);
                volo.setDataVolo(dataVolo);
                volo.setOraPartenza(oraPartenza);
                volo.setOraArrivo(oraArrivo);
                volo.setNumeroPosti(numeroPosti);
                break;
            }
        }
    }

    public Volo ricercaVoloCodice(String codiceVolo) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                return volo;
            }
        }
        return null;
    }

    public Volo ricercaVoloCompleto(LocalDate data, String aereoportoPartenza, String aereoportoArrivo, LocalTime orario){
        for (Volo volo : voli) {
            if (volo.getDataVolo().equals(data) && volo.getAeroportoPartenza().equals(aereoportoPartenza) && volo.getAeroportoArrivo().equals(aereoportoArrivo) && volo.getOraPartenza().equals(orario)) {
                return volo;
            }
        }
        return null;
    }
    

    public static void main(String[] args) {
        Voli voli = new Voli();

        // Creazione di alcuni oggetti Volo
        Volo volo1 = new Volo("AZ123", "Roma", "Milano", LocalDate.of(2023, 6, 12), "08:00", "09:00", 100);
        Volo volo2 = new Volo("LH456", "Berlino", "Parigi", LocalDate.of(2023, 6, 13), "10:00", "12:00", 150);
        Volo volo3 = new Volo("AF789", "Londra", "Madrid", LocalDate.of(2023, 6, 14), "14:00", "16:00", 120);

        // Aggiunta dei voli
        voli.aggiungiVolo(volo1);
        voli.aggiungiVolo(volo2);
        voli.aggiungiVolo(volo3);

        // Stampa dei voli
        System.out.println("Elenco voli:");
        voli.stampaVoli();

        // Ricerca di un volo per codice
        String codiceVoloDaRicercare = "AZ123";
        System.out.println("Volo ricercato: " + voli.ricercaVoloCodice(codiceVoloDaRicercare));

        // Modifica di un volo
        voli.modificaVolo("AZ123", "Milano", "Roma", LocalDate.of(2023, 6, 12), "08:00", "09:00", 100);
        
        // Rimozione di un volo
        voli.rimuoviVolo(volo3);

        // Stampa dei voli aggiornati
        System.out.println("Elenco voli aggiornato:");
        voli.stampaVoli();
    }

}