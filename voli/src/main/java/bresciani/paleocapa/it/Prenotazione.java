package bresciani.paleocapa.it;

import java.util.*;

public class Prenotazione {

    private String codiceCliente;
    private String codiceVolo;
    private LinkedList<Bagaglio> bagagli;

    public Prenotazione(String codiceCliente, String codiceVolo) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.bagagli = new LinkedList<>();
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
