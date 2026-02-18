package org.aletane04;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AnagraficaImpiegati implements Serializable
{
    Map<String,Impiegato> anagraficaImpiegati;
    String descrizione;
    public AnagraficaImpiegati(String descr)
    {
        this.anagraficaImpiegati = new HashMap<>();
        this.descrizione=descr;
    }
}
