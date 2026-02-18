package org.aletane04;

import java.time.LocalDate;

public class Capo extends Impiegato
{
    private double bonusDirigenziale;

    public Capo(String n, String c, String cM, Double s, LocalDate d, double bD)
    {
        super(n, c, cM, s, d);
        this.bonusDirigenziale = bD;
    }
    
    public void setBonusDirigenziale(double b)
    {
        this.bonusDirigenziale = b;
    }
    
    public double getBonusDirigenziale()
    {  
        return bonusDirigenziale;
    }
    @Override
    public double calcolaStipendioMensile() 
    {
        return super.getStipendio() + bonusDirigenziale;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("Stipendio: "+calcolaStipendioMensile()+"\n");
        return sb.toString();
    }

}
