package bresciani.paleocapa.it;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;

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
        Cliente cliente = new Cliente("123", "Mario", "Rossi", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
        assertEquals(clienti.clienti.size(), 1);
    }

    @Test
    void testRimuoviCliente(){
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "Mario", "Rossi", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
        clienti.rimuoviCliente("123", "Mario"); 
        assertEquals(0, clienti.clienti.size()); 
    }
    
    @Test
    void testModificaCliente() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "Mario", "Rossi", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
    
        clienti.modificaCliente("123", "NuovoNome", "NuovoCognome", "NuovaNazione", "NuovaCitta", new Date());
    
        assertEquals("NuovoNome", cliente.getNome());
        assertEquals("NuovoCognome", cliente.getCognome());
    }
    
    @Test
    void testRicercaClientePerNomeCognome() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "Mario", "Rossi", "Italia", "Roma", new Date());
        clienti.aggiungiCliente(cliente);
    
        clienti.ricercaClientePerNomeCognome("Mario", "Rossi");
    
        assertEquals("Mario", cliente.getNome());
        assertEquals("Rossi", cliente.getCognome());
    }

    @Test
    void testRicercaClientePerCodice() {
        Clienti clienti = new Clienti();
        Cliente cliente = new Cliente("123", "Mario", "Rossi", "Italia", "Roma", new Date());
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
        Voli voli
    }

}
