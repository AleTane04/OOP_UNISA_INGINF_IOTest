package org.aletane04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fattorino extends Impiegato
{
    private List<String> listaCAP;
    private int numeroConsegneEffettuate;

    public Fattorino(String n, String c, String cM, Double s, LocalDate d, int nCE)
    {
        super(n,c,cM,s,d);
        this.numeroConsegneEffettuate=nCE;
        this.listaCAP=new ArrayList<>();
    }

    public int getNumeroConsegneEffettuate()
    {
        return numeroConsegneEffettuate;
    }

    public void setNumeroConsegneEffettuate(int numeroConsegneEffettuateDato)
    {
        this.numeroConsegneEffettuate=numeroConsegneEffettuateDato;
    }

    public List<String> getCAPs()
    {
        return listaCAP;
    }

    public void addCAP(String cap)
    {
        this.listaCAP.add(cap);
    }

    @Override
    public double calcolaStipendioMensile()
    {
        return super.getStipendio() + 0.10*numeroConsegneEffettuate;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Numero consegne effettuate: "+numeroConsegneEffettuate+"\n");
        sb.append("Lista dei CAP coperti: ");
        sb.append(listaCAP);
        sb.append("\n");
        return sb.toString();
    }
}
