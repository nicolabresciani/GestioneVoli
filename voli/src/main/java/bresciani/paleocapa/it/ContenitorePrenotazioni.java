package bresciani.paleocapa.it;
import java.time.*;
import java.util.*;

public class ContenitorePrenotazioni {
    
    public HashMap<Cliente, LinkedList<Prenotazione>> prenotazioni = new HashMap<>();


    public void aggiungiCliente(Cliente cliente) {
        prenotazioni.put(cliente, new LinkedList<>());
    }

    public void eliminaCliente(String codiceCliente){
        for (Cliente cliente : prenotazioni.keySet()) {
            if (cliente.getCodiceCliente().equals(codiceCliente)) {
                prenotazioni.remove(cliente);
                break;
            }
        }
    }

    public void modificaCliente(String nome, String cognome, String codiceSpecifico, String nuovoNome, String nuovoCognome){
        for (Cliente cliente : prenotazioni.keySet()) {
            if (cliente.getCodiceCliente().equals(codiceSpecifico) && cliente.getCognome().equals(cognome) && cliente.getNome().equals(nome)) {
                cliente.setNome(nuovoNome);
                cliente.setCognome(nuovoCognome);
                break;
            }
        }
    }

    public void ricercaCliente(String codicePartenza){
        for (Cliente cliente : prenotazioni.keySet()) {
            if (cliente.getCodiceCliente().equals(codicePartenza)) {
                System.out.println("il cliente cercato a partire dal codice e':" + cliente);
                break;
            }
        }
    }
    
    public void ricercaClientePerNomeCognome(String nome, String cognome){
        for(Cliente cliente: prenotazioni.keySet()){
            if(cliente.getNome().equals(nome) && cliente.getCognome().equals(cognome)){
                System.out.println("il cliente cercato a partire da nome e cognome e':" + cliente);
                break;
            }
        }
    }

    public void aggiungiVolo(Cliente cliente, Volo volo) {
        Prenotazione prenotazione = new Prenotazione(cliente.getCodiceCliente(), volo.getCodiceVolo());
        prenotazioni.get(cliente).add(prenotazione);
    }

    public void eliminaVolo(Cliente cliente, String codiceVolo){
        for (Prenotazione prenotazione : prenotazioni.get(cliente)) {
            if (prenotazione.getCodiceVolo().equals(codiceVolo)) {
                prenotazioni.get(cliente).remove(prenotazione);
                break;
            }
        }
    }

    //public void modificaVolo(String codiceVolo, String partenza, String arrivo, String nuovaPartenza, String nuovoArrivo){}

    public void ricercaVolo(String codiceVolo){
        for (Cliente cliente : prenotazioni.keySet()) {
            for (Prenotazione prenotazione : prenotazioni.get(cliente)) {
                if (prenotazione.getCodiceVolo().equals(codiceVolo)) {
                    System.out.println("il volo cercato a partire dal codice e':" + prenotazione);
                    break;
                }
            }
        }
    }

    public void ricercaVoloCompleto(LocalDate dataPartenza,String aereoportoPartenza, String aereoportoArrivo, LocalTime orarioPartenza){
        for (Cliente cliente : prenotazioni.keySet()) {
            for (Prenotazione prenotazione : prenotazioni.get(cliente)) {
                if (prenotazione.getDataPartenza().equals(dataPartenza) && prenotazione.getAereoportoPartenza().equals(aereoportoPartenza) && prenotazione.getAereoportoArrivo().equals(aereoportoArrivo) && prenotazione.getOrarioPartenza().equals(orarioPartenza)) {
                    System.out.println("il volo cercato a partire da tutti i parametri e':" + prenotazione);
                    break;
                }
            }
        }
    }

    public void aggiungiNuovaPrenotazione(Prenotazione p){
        Cliente cliente = new Cliente(p.getCodiceCliente());
        Volo volo = new Volo(p.getCodiceVolo());
        aggiungiCliente(cliente);
        aggiungiVolo(cliente, volo);
    }
    
    public void eliminaPrenotazione(String codiceCliente, String codiceVolo){
        for(Cliente cliente: prenotazioni.keySet()){
            if(cliente.getCodiceCliente().equals(codiceCliente)){
                for(Prenotazione prenotazione: prenotazioni.get(cliente)){
                    if(prenotazione.getCodiceVolo().equals(codiceVolo)){
                        prenotazioni.get(cliente).remove(prenotazione);
                        break;
                    }
                }
            }
        }
    }

    public void modificaPrenotazione(String codiceCliente, String codiceVolo, int NuovoNumeroBagagli, int NuovoPesoBagaglio){
        for(Cliente cliente: prenotazioni.keySet()){
            if(cliente.getCodiceCliente().equals(codiceCliente)){
                for(Prenotazione prenotazione: prenotazioni.get(cliente)){
                    if(prenotazione.getCodiceVolo().equals(codiceVolo)){
                        prenotazione.setNumeroBagagli(NuovoNumeroBagagli);
                        prenotazione.setPesoBagaglio(NuovoPesoBagaglio);
                        break;
                    }
                }
            }
        }
    }

    public void ricercaPrenotazioneClienteSpecifico(String codiceCliente){
        for(Cliente cliente: prenotazioni.keySet()){
            if(cliente.getCodiceCliente().equals(codiceCliente)){
                System.out.println("le prenotazioni del cliente cercato sono: " + prenotazioni.get(cliente));
                break;
            }
        }
    }

    public void ricercaPrenotazioneVoloSpecifico(String codiceVolo){
        for(Cliente cliente: prenotazioni.keySet()){
            for(Prenotazione prenotazione: prenotazioni.get(cliente)){
                if(prenotazione.getCodiceVolo().equals(codiceVolo)){
                    System.out.println("le prenotazioni del volo cercato sono: " + prenotazione);
                    break;
                }
            }
        }
    }

    

    
}