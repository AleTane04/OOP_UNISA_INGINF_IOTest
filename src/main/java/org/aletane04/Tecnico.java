package org.aletane04;

import java.time.LocalDate;

public class Tecnico extends Impiegato
{
    private int livello;
    private String specializzazione;

    public Tecnico(String n, String c, String cM, Double s, LocalDate d, int lvl, String sp)
    {
        super(n,c,cM,s,d);
        this.livello=lvl;
        this.specializzazione=sp;
    }

    public void setLivello(int lvl)
    {
        this.livello=lvl;
    }
    public void setSpecializzazione(String specia)
    {
        this.specializzazione=specia;
    }

    public int getLivello()
    {
        return this.livello;
    }
    public String getSpecializzazione()
    {
        return this.specializzazione;
    }
    @Override
    public double calcolaStipendioMensile()
    {
       return super.getStipendio() * (1 + 0.10 * (livello - 1));
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Stipendio: "+calcolaStipendioMensile()+"\n");
        sb.append("Specializzazione: " + specializzazione+"\n");
        sb.append("Livello: "+livello+"\n");
        return sb.toString();
    }

}
