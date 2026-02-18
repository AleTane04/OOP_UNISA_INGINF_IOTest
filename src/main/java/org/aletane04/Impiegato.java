package org.aletane04;

import java.time.LocalDate;

public class Impiegato implements Comparable<Impiegato>
{
    private static int counter=0;
    private int id;
    private String nome;
    private String cognome;
    private String codiceMatricola;
    private Double stipendio;
    private LocalDate dataAssunzione;


    public Impiegato(String n, String c, String cM, Double s,LocalDate d)
    {
        this.nome=n;
        this.cognome=c;
        this.codiceMatricola=cM;
        this.stipendio=s;
        this.dataAssunzione=d;
        this.id=++counter;
    }

    public void setNome(String n)
    {
        this.nome=n;
    }
    public void setCognome(String c)
    {
        this.cognome=c;
    }
    public void setCodiceMatricola(String cM)
    {
        this.codiceMatricola=cM;
    }
    public void setStipendio(double s)
    {
        this.stipendio=s;
    }
    public void setDataAssunzione(LocalDate d)
    {
        this.dataAssunzione=d;
    }


    public /*abstract*/ double calcolaStipendioMensile()
    {
        return 0.0;
    }


    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public String getCodiceMatricola()
    {
        return codiceMatricola;
    }
    public Double getStipendio()
    {
        return stipendio;
    }
    public LocalDate getDataAssunzione()
    {
        return dataAssunzione;
    }
    public int getID()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;

        Impiegato imp = (Impiegato) obj;
        return this.codiceMatricola.equals(imp.codiceMatricola);
    }

    @Override
    public int hashCode()
    {
        int code = (this.codiceMatricola == null) ? 0 : this.codiceMatricola.hashCode();
        return code;
    }
    
    @Override
    public int compareTo(Impiegato imp)
    {
        if(this.cognome.equals(imp.cognome))
            return this.cognome.compareTo(imp.cognome);
        return this.nome.compareTo(imp.nome);
    }


    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: "+nome+"\n");
        sb.append("Cognome: "+cognome+"\n");
        sb.append("Codice matricola: "+codiceMatricola+"\n");
        sb.append("Data assunzione: "+dataAssunzione+"\n");
        sb.append("Id: "+id+"\n");
        sb.append("\n");
        return sb.toString();
    }





}
