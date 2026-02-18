package org.aletane04;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        Fattorino giovanni = new Fattorino("Giovanni","Rossi","0612708777",500.90,LocalDate.of(2025,12,12),4);
        System.out.println(giovanni);
        giovanni.addCAP("86039");
        giovanni.addCAP("84014");
        System.out.println(giovanni.getCAPs());


        AnagraficaImpiegati anagrafica1 = new AnagraficaImpiegati("Questa è la prima anagrafica dell'azienda");

        /*
        List <String> myList = new ArrayList<>();
        myList.add("Andrea");
        myList.add("Bob");
        myList.add("Daniel");
        myList.add("Gaetano");
        myList.add("Lucia");

        System.out.println(" ---- DATA OUTPUT/INPUT STREAM ---- ");
        FileOutputStream fos = new FileOutputStream("myList.bin");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeUTF("Questa è la mia lista degli studenti");

        for(String s : myList)
        {
            dos.writeUTF(s);
        }

        dos.close();




        FileInputStream fis = new FileInputStream("myList");
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        String descrizione =  dis.readUTF();

        try
        {
            while(true)
            {
                System.out.println(dis.readUTF());
            }

        }
        catch (EOFException e)
        {
            System.err.println("Lettura completata");
        }

        dis.close();

        System.out.println(" ---- OBJECT OUTPUT/INPUT STREAM ---- ");

        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("mioSerializzato.obj"))))
        {
            oos.writeObject(myList);
        }
        catch (IOException e)
        {
            System.out.println("Ziopew scrittura fallita");
        }

        ArrayList miaListaLetta = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("mioSerializzato.obj"))))
        {
            miaListaLetta = (ArrayList) ois.readObject();
            for(Object people : miaListaLetta)
            {
                System.out.println(people.toString());
            }
        }
        catch (IOException e)
        {
            System.out.println("Ziopew lettura fallita");
        }

        System.out.println(" ---- PRINT WRITED/BYUFFERED READER ---- ");

        try(PrintWriter pw = new PrintWriter(new FileWriter("mioSerializzato.csv")))
        {
            pw.println("NOME;COGNOME");
            for(String s : myList)
            {
                pw.append(s);
                pw.append(";");
                pw.println("Ruggiero");
            }
        }
        catch (EOFException e)
        {
            System.out.println(e);
        }



        ArrayList listCSV = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader("mioSerializzato.csv")))
        {
            String line;
            System.out.println("\n" + br.readLine()); //Mi tolgo da mezzo l'header
            while((line=br.readLine())!=null)
            {
                String[] chunks =  line.split(";");
                listCSV.add(chunks[0]);

            }

        }
        catch (EOFException e)
        {
            System.out.println(e);
        }

        //System.out.println(listCSV);
        for(Object studentini : listCSV)
        {
            System.out.println(studentini.toString());
        }

        System.out.println(" ------- SCANNER ---------- ");

        List <String> mioScanner = new ArrayList();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("mioSerializzato.csv"))))
        {
            scanner.useDelimiter("[;\n]");
            scanner.useLocale(Locale.US);
            if(scanner.hasNextLine())
                System.out.println(scanner.nextLine());

            while(scanner.hasNext())
            {
                String[] pezzi =  scanner.nextLine().split(";");
                mioScanner.add(pezzi[0]);
            }


        }
        catch(IOException e)
        {
            System.out.println("Ziopew lettura fallita");
        }

        System.out.println(mioScanner);
        */
    }



}