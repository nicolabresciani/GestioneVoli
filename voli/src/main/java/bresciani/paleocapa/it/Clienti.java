package bresciani.paleocapa.it;

import java.util.*;

public class Clienti {
    public LinkedList<Cliente> clienti = new LinkedList<>();

    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }
    public void rimuoviCliente(String codiceCliente, String nomeCliente) {
        Iterator<Cliente> iterator = clienti.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCodiceCliente().equals(codiceCliente) && cliente.getNome().equals(nomeCliente)) {
                iterator.remove(); 
                break; 
            }
        }
    }
    public void stampaClienti() {
        for (Cliente cliente : clienti) {
            System.out.println(cliente);
        }
    }

    public void modificaCliente(String codiceCliente, String nuovoNome, String nuovoCognome, String nuovaNazioneDiNascita, String nuovaCittaDiNascita, Date nuovaDataDiNascita) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(codiceCliente)) {
                cliente.setNome(nuovoNome);
                cliente.setCognome(nuovoCognome);
                cliente.setNazioneDiNascita(nuovaNazioneDiNascita);
                cliente.setCittaDiNascita(nuovaCittaDiNascita);
                cliente.setDataDiNascita(nuovaDataDiNascita);
                break;
            }
        }
    }
    
    
    public void ricercaClientePerNomeCognome(String nomeCliente, String cognomeCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(nomeCliente) && cliente.getCognome().equals(cognomeCliente)) {
                System.out.println(cliente);
                break;
            }
        }
    }

    public void ricercaClientePerCodice(String codiceCliente){
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(codiceCliente)) {
                System.out.println(cliente);
                break;
            }
        }
    }

    
}