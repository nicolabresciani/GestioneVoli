package bresciani.paleocapa.it;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testAggiungiCliente() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "nicola", "bresciani", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
        assertEquals(clienti.clienti.size(), 1);
    }

    @Test
    void testRimuoviCliente(){
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "nicola", "bresciani", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
        clienti.rimuoviCliente("123", "nicola"); 
        assertEquals(0, clienti.clienti.size()); 
    }
    
    @Test
    void testModificaCliente() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "nicola", "bresciani", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
    
        clienti.modificaCliente("123", "luca", "bello", "italia", "bergamo", new Date());
    
        assertEquals("luca", cliente.getNome());
        assertEquals("bello", cliente.getCognome());
    }
    
    @Test
    void testRicercaClientePerNomeCognome() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "nicola", "bresciani", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
    
        clienti.ricercaClientePerNomeCognome("nicola", "bresciani");
    
        assertEquals("nicola", cliente.getNome());
        assertEquals("bresciani", cliente.getCognome());
    }

    @Test
    void testRicercaClientePerCodice() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "nicola", "bresciani", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
    
        clienti.ricercaClientePerCodice("123");
    
        assertEquals("123", cliente.getCodiceCliente());
    }

    @Test
    void testAggiungiVolo(){
        Voli v = new Voli();
        LocalDate dataVolo = LocalDate.now(); 
        Volo volo = new Volo("AZ123", "Roma", "Milano", dataVolo, "08:00", "09:00", 100);
        v.aggiungiVolo(volo);
        assertEquals(1, v.voli.size());

    }

    @Test
    void testRimuoviVoloCodice(){
        Voli v = new Voli();
        LocalDate dataVolo = LocalDate.now();
        Volo volo = new Volo("AZ123", "Roma", "Milano", dataVolo, "08:00", "09:00", 100);
        v.aggiungiVolo(volo);
        v.rimuoviVoloCodice("AZ123");
        assertEquals(0, v.voli.size());
    }

   @Test
    void testModificaVolo(){
        Voli v = new Voli();
        LocalDate dataVolo = LocalDate.now();
        Volo volo = new Volo("AZ123", "Roma", "Milano", dataVolo, "08:00", "09:00", 100);
        v.aggiungiVolo(volo);
        v.modificaVolo("AZ123", "Milano", "Roma", dataVolo, "08:00", "09:00", 100);
        // Ora verifico il volo modificato all'interno della lista, non quello originale
        Volo voloModificato = v.voli.get(0);
        assertEquals("Milano", voloModificato.getAeroportoPartenza());
        assertEquals("Roma", voloModificato.getAeroportoArrivo());
    }

    @Test
    void testRicercaVoloCodice(){
        Voli v = new Voli();
        LocalDate dataVolo = LocalDate.now();
        Volo volo = new Volo("AZ123", "Roma", "Milano", dataVolo, "08:00", "09:00", 100);
        v.aggiungiVolo(volo);
        Volo voloRicercato = v.ricercaVoloCodice("AZ123");
        assertEquals("AZ123", voloRicercato.getCodiceVolo());
    }

    @Test
    void testRicercaVoloCompleto(){
        Voli v = new Voli();
        LocalDate dataVolo = LocalDate.now();
        Volo volo = new Volo("AZ123", "Roma", "Milano", dataVolo, "08:00", "09:00", 100);
        v.aggiungiVolo(volo);
        Volo voloRicercato = v.ricercaVoloCompleto(dataVolo, "Roma", "Milano", LocalTime.of(8,0));
        assertEquals("AZ123", voloRicercato.getCodiceVolo());
    }
    
    @Test
    void aggiungiPrenotazione(){
        Prenotazione prenotazione = new Prenotazione("123", "AZ123");
        prenotazione.aggiungiPrenotazione(prenotazione);
        assertEquals(1, prenotazione.prenotazioni.size());
    }

    @Test
    void eliminaPrenotazione(){
        Prenotazione prenotazione = new Prenotazione("123", "AZ123");
        prenotazione.aggiungiPrenotazione(prenotazione);
        prenotazione.rimuoviPrenotazioneCodiceClienteECodiceVolo("AZ123", "123");
        assertEquals(0, prenotazione.prenotazioni.size());
    }

    @Test
    void ricercaClientePerCodice(){
        Prenotazione prenotazione = new Prenotazione("123", "AZ123");
        prenotazione.aggiungiPrenotazione(prenotazione);
        prenotazione.ricercaPrenotazioneCodiceCliente("123");
        assertEquals("123", prenotazione.getCodiceCliente());
    }

    @Test
    void ricercaPrenotazionePerCodiceVolo(){
        Prenotazione prenotazione = new Prenotazione("123", "AZ123");
        prenotazione.aggiungiPrenotazione(prenotazione);
        prenotazione.ricercaPrenotazionePerCodiceVolo("AZ123");
        assertEquals("AZ123", prenotazione.getCodiceVolo());
    }


    

}
