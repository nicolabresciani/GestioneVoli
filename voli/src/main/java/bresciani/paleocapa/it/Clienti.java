package bresciani.paleocapa.it;

import java.util.*;

public class Clienti {
    public LinkedList<Cliente> clienti = new LinkedList<>();

    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }
    public void rimuoviCliente(Cliente cliente) {
        clienti.remove(cliente);
    }
    public void rimuoviCliente(String nomeCliente, String cognomeCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(nomeCliente) && cliente.getCognome().equals(cognomeCliente)) {
                clienti.remove(cliente);
                break;
            }
        }
    }
    public void stampaClienti() {
        for (Cliente cliente : clienti) {
            System.out.println(cliente);
        }
    }
    public void modificaCliente(String nomeCliente, String cognomeCliente, String nuovoNome, String nuovoCognome, String nuovaNazioneDiNascita, String nuovaCittaDiNascita, Date nuovaDataDiNascita) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(nomeCliente) && cliente.getCognome().equals(cognomeCliente)) {
                cliente.setNome(nuovoNome);
                cliente.setCognome(nuovoCognome);
                cliente.setNazioneDiNascita(nuovaNazioneDiNascita);
                cliente.setCittaDiNascita(nuovaCittaDiNascita);
                cliente.setDataDiNascita(nuovaDataDiNascita);
                break;
            }
        }
    }
    public void ricercaCliente(String nomeCliente, String cognomeCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(nomeCliente) && cliente.getCognome().equals(cognomeCliente)) {
                System.out.println(cliente);
                break;
            }
        }
    }



    public static void main(String[] args) {
        Clienti clienti = new Clienti();

        // Crea alcuni clienti di esempio
        Cliente cliente1 = new Cliente("Mario", "Rossi", "Italia", "Roma", new Date());
        Cliente cliente2 = new Cliente("Laura", "Bianchi", "Italia", "Milano", new Date());
        Cliente cliente3 = new Cliente("Luigi", "Verdi", "Italia", "Torino", new Date());

        // Aggiungi i clienti alla lista
        clienti.aggiungiCliente(cliente1);
        clienti.aggiungiCliente(cliente2);
        clienti.aggiungiCliente(cliente3);

        // Stampa tutti i clienti
        System.out.println("Elenco clienti:");
        clienti.stampaClienti();

        // Ricerca un cliente specifico
        System.out.println("Ricerca cliente:");
        clienti.ricercaCliente("1234", "Mario");
         System.out.println(" ricerca eseguita correttamente.");

        // Modifica un cliente
        System.out.println("Modifica cliente:");
        clienti.modificaCliente("5678", "Laura", "Laura", "Verdi", "Italia", "Firenze", new Date());
         System.out.println(" modifica eseguita correttamente.");

        // Rimuovi un cliente
        System.out.println("Rimozione cliente:");
        clienti.rimuoviCliente("91011", "Luigi");
        System.out.println(" rimozione eseguita correttamente.");

    }

}