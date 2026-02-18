package org.aletane04;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            dos.writeUTF(imp.getClass().getSimpleName());
            dos.writeUTF(imp.getDataAssunzione().toString());
            switch (imp.getClass().getSimpleName())
            {
                case "Capo": 
                    Capo cap = (Capo) imp;
                    dos.writeDouble(cap.calcolaStipendioMensile());
                    dos.writeDouble(cap.getBonusDirigenziale());
                    break;
                case "Tecnico":
                    Tecnico tec = (Tecnico) imp;
                    dos.writeDouble(tec.calcolaStipendioMensile());
                    dos.writeInt(tec.getLivello());
                    dos.writeUTF(tec.getSpecializzazione());
                    break;
                case "Fattorino":
                    Fattorino fat = (Fattorino) imp;
                    dos.writeDouble(fat.calcolaStipendioMensile());
                    dos.writeInt(fat.getCAPs().size());
                    dos.writeInt(fat.getNumeroConsegneEffettuate());
                    for(String cappippo : fat.getCAPs())
                        dos.writeUTF(cappippo);

                    break;
                default:
                    dos.writeUTF("Stipendio di default");
            }


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
                String tipo = dis.readUTF();
                LocalDate dataAssunzione = LocalDate.parse(dis.readUTF());
                if(tipo.equals("Fattorino"))
                {
                    List<String> lista = new ArrayList<>();

                    double stipendio = dis.readDouble();
                    int lunghezza = dis.readInt();
                    int nCE = dis.readInt();
                    for (int i = 0; i < lunghezza; i++)
                    {
                        String elemento = dis.readUTF();
                        lista.add(elemento);
                    }

                    a.aggiungiImpiegato(new Fattorino(nome,cognome,codiceMatricola,stipendio,dataAssunzione,nCE));
                }
                if(tipo.equals("Tecnico"))
                {
                    double stipendio = dis.readDouble();
                    int livello = dis.readInt();
                    String specializzazione = dis.readUTF();

                    a.aggiungiImpiegato(new Tecnico(nome, cognome,codiceMatricola, stipendio, dataAssunzione,livello,specializzazione));
                }
                if(tipo.equals("Capo"))
                {
                    double stipendio = dis.readDouble();
                    double bonus = dis.readDouble();

                    a.aggiungiImpiegato(new Capo(nome, cognome,codiceMatricola, stipendio, dataAssunzione,bonus));
                }
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
