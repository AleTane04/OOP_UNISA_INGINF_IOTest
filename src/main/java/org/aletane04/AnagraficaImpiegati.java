package org.aletane04;

import java.io.*;
import java.time.LocalDate;
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

    public void aggiungiImpiegato(Impiegato imp)
    {
        anagraficaImpiegati.put(imp.getCodiceMatricola(), imp);
    }

    public Impiegato cercaImpiegato(String mt)
    {
        return anagraficaImpiegati.get(mt);
    }

    public void salvaDOS(String nomefile) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(nomefile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeUTF(descrizione);

        for(Impiegato imp: anagraficaImpiegati.values())
        {
            dos.writeUTF(imp.getNome());
            dos.writeUTF(imp.getCognome());
            dos.writeUTF(imp.getCodiceMatricola());
            switch (imp.getClass().getName())
            {
                case "Capo": 
                    Capo cap = (Capo) imp;
                    dos.writeDouble(cap.calcolaStipendioMensile());
                    break;
                case "Tecnico":
                    Tecnico tec = (Tecnico) imp;
                    dos.writeDouble(tec.calcolaStipendioMensile());
                    break;
                case "Fattorino":
                    Fattorino fat = (Fattorino) imp;
                    dos.writeDouble(fat.calcolaStipendioMensile());
                    break;
                default:
                    dos.writeUTF("Stipendio di default");
            }

            dos.writeUTF(imp.getDataAssunzione().toString());
        }
        dos.close();
    }

    public static AnagraficaImpiegati leggiDIS(String nomeFile) throws IOException
    {
        FileInputStream fis = new FileInputStream(nomeFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        AnagraficaImpiegati a = new AnagraficaImpiegati(dis.readUTF());
        try
        {
            while(true)
            {
                String nome = dis.readUTF();
                String cognome = dis.readUTF();
                String codiceMatricola = dis.readUTF();
                double stipendio = dis.readDouble();
                LocalDate dataAssunzione = LocalDate.parse(dis.readUTF());

                Impiegato imp = new Impiegato(nome,cognome,codiceMatricola,stipendio,dataAssunzione);
                a.aggiungiImpiegato(imp);
            }
        }
        catch (EOFException e)
        {
            System.out.println("Lettura terminata. \n");
        }
        dis.close();
        return a;
    }

}
