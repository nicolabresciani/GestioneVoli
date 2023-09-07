package bresciani.paleocapa.it;

import java.util.*;

public class Prenotazione {

    public String codiceCliente;
    public String codiceVolo;
    public LinkedList<Bagaglio> bagagli;
    public LinkedList<Prenotazione> prenotazioni = new LinkedList<>();

    public Prenotazione(String codiceCliente, String codiceVolo) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.bagagli = new LinkedList<>();
    }
    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }
    public void rimuoviPrenotazioneCodiceClienteECodiceVolo(String codiceVolo, String codiceCliente) {
        Iterator<Prenotazione> iterator = prenotazioni.iterator();
        while (iterator.hasNext()) {
            Prenotazione prenotazione = iterator.next();
            if (prenotazione.getCodiceVolo().equals(codiceVolo) && prenotazione.getCodiceCliente().equals(codiceCliente)) {
                iterator.remove();
                break;
            }
        }
    }

    public void ricercaPrenotazioneCodiceCliente(String codiceCliente){
        for(Prenotazione prenotazione : prenotazioni){
            if(prenotazione.getCodiceCliente().equals(codiceCliente)){
                System.out.println(prenotazione);
                break;
            }
        }
    }

    public void ricercaPrenotazionePerCodiceVolo(String codiceVolo){
        for(Prenotazione prenotazione : prenotazioni){
            if(prenotazione.getCodiceVolo().equals(codiceVolo)){
                System.out.println(prenotazione);
                break;
            }
        }
    }


    public void aggiungiBagaglio(double peso) {
        Bagaglio bagaglio = new Bagaglio(peso);
        bagagli.add(bagaglio);
    }

    public LinkedList<Bagaglio> getBagagli() {
        return bagagli;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "codiceCliente='" + codiceCliente + '\'' +
                ", codiceVolo='" + codiceVolo + '\'' +
                ", bagagli=" + bagagli +
                '}';
    }
    public String getCodiceCliente() {
        return codiceCliente;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    private class Bagaglio {
        private double peso;

        public Bagaglio(double peso) {
            this.peso = peso;
        }

        public double getPeso() {
            return peso;
        }

        @Override
        public String toString() {
            return "Bagaglio{" +
                    "peso=" + peso +
                    '}';
        }
    }

}
