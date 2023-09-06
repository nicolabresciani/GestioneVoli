package bresciani.paleocapa.it;

import java.util.Date;

public class Cliente {
    private String cognome;
    private String nome;
    private String nazioneDiNascita;
    private String cittaDiNascita;
    private Date dataDiNascita;
    private String codiceCliente;
    private static int contatoreCodiceCliente = 1;

    // Costruttore
    public Cliente(String nome, String cognome, String nazioneDiNascita, String cittaDiNascita, Date dataDiNascita) {
        this.cognome = cognome;
        this.nome = nome;
        this.nazioneDiNascita = nazioneDiNascita;
        this.cittaDiNascita = cittaDiNascita;
        this.dataDiNascita = dataDiNascita;
        this.codiceCliente = generaCodiceCliente();
    }

    public String generaCodiceCliente() {
        String inizialiCognome = cognome.substring(0, Math.min(cognome.length(), 2)).toLowerCase();
        String codiceNumerico = Integer.toString(contatoreCodiceCliente);
        return inizialiCognome + codiceNumerico;
    }
    
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public String getNazioneDiNascita() {
        return nazioneDiNascita;
    }
    public String setNazioneDiNascita(String nazioneDiNascita) {
        return this.nazioneDiNascita = nazioneDiNascita;
    }

    public String getCittaDiNascita() {
        return cittaDiNascita;
    }
    public String setCittaDiNascita(String cittaDiNascita) {
        return this.cittaDiNascita = cittaDiNascita;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }
    public Date setDataDiNascita(Date dataDiNascita) {
        return this.dataDiNascita = dataDiNascita;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }
    public String setCodiceCliente(String codiceCliente) {
        return this.codiceCliente = codiceCliente;
    }
    
    @Override
    public String toString(){
        return "Cliente: " + nome + " " + cognome + " " + nazioneDiNascita + " " + cittaDiNascita + " " + dataDiNascita + " " + codiceCliente;
    }

    public static void main(String[] args) {
        String cognome = "Rossi";
        String nome = "Mario";
        String nazioneDiNascita = "Italia";
        String cittaDiNascita = "Roma";
        Date dataDiNascita = new Date(); // Utilizza la data corrente come esempio
        
        Cliente cliente = new Cliente (nome, cognome, nazioneDiNascita, cittaDiNascita, dataDiNascita);
        
        // Stampa i dati del cliente
        System.out.println("Cognome: " + cliente.getCognome());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Nazione di nascita: " + cliente.getNazioneDiNascita());
        System.out.println("Città di nascita: " + cliente.getCittaDiNascita());
        System.out.println("Data di nascita: " + cliente.getDataDiNascita());
        System.out.println("Codice cliente: " + cliente.getCodiceCliente());
    }
}