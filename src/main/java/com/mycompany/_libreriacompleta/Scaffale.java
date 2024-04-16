/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreriacompleta;

import java.io.*;
import eccezioni.*;
import utilita.*;

/**
 *
 * @author Studente
 */
public class Scaffale implements Serializable
{
    private Mensola[] ripiani;
    private final static int NUM_RIPIANI=5;
    
    /**
     * Costruttore
     */
    public Scaffale()
    {
	ripiani=new Mensola[NUM_RIPIANI];
	for(int i=0;i<NUM_RIPIANI;i++)
	{
	    ripiani[i]=new Mensola();
	}
    }
    
    /**
     * Costruttore di copia
     * @param scaffale 
     */
    public Scaffale(Scaffale scaffale)
    {
	ripiani=new Mensola[NUM_RIPIANI];
	Libro lib;
	for(int i=0;i<scaffale.getNumRipiani();i++)
	    ripiani[i]=new Mensola();
        for(int i=0;i<scaffale.getNumRipiani();i++)
        {
            for(int j=0;j<scaffale.getNumMaxLibri(i);j++)
            {
                try
                {
                    lib=scaffale.getLibro(i, j);
                    if(lib!=null)
                        this.setLibro(lib, i, j);
                }
                catch(EccezioneRipianoNonValido e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneNonValida e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneVuota e)
                {
                    //non fare nulla
                }
                catch(EccezionePosizioneOccupata e)
                {
                    //non succederà mai
                }
            }
        }
    }

    /**
     * Inserisce il libro nella posizione "posizione" del ripiano "ripiano".
     * @param libro
     * @param ripiano
     * @param posizione
     */
    public void setLibro(Libro libro, int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
	if(ripiano<0 || ripiano>=NUM_RIPIANI)
	    throw new EccezioneRipianoNonValido();
	ripiani[ripiano].setVolume(libro, posizione);
    }
    
    /**
     * Restituisce il libro nella posizione "posizione" del ripiano "ripiano".
     * @param ripiano
     * @param posizione
     * @return
     * se il libro è presente --> restituisce l’oggetto libro
     */
    public Libro getLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
	Libro lib;
	if(ripiano<0 || ripiano>=NUM_RIPIANI)
	    throw new EccezioneRipianoNonValido();
	lib=ripiani[ripiano].getVolume(posizione);
	return lib;
    }
    
    /**
     * Libera la posizione "posizione" del ripiano "ripiano"
     * @param ripiano
     * @param posizione
     */
    public void rimuoviLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
	if(ripiano<0 || ripiano>=NUM_RIPIANI)
	    throw new EccezioneRipianoNonValido();
	ripiani[ripiano].rimuoviVolume(posizione);
    }
    
    public int getNumRipiani() //Restituisce il numero di ripiani/mensole presenti in uno scaffale
    {
	return NUM_RIPIANI;
    }
    public int getNumMaxLibri() //Restituisce il numero massimo di libri inseribili nello scaffale
    {
	int contaLibri=0;
	for(int i=0;i<NUM_RIPIANI;i++)
	    contaLibri+=ripiani[i].getNumMaxVolumi();
	return contaLibri;
    }
    public int getNumMaxLibri(int ripiano) //Restituisce il numero massimo di libri inseribili sul ripiano "ripiano"
    {
	if(ripiano<0 || ripiano>NUM_RIPIANI)
	    return -1; //Ripiano non valido
	return ripiani[ripiano].getNumMaxVolumi();
    }
    public int getNumLibri() //Restituisce il numero di libri presenti nello scaffale
    {
	int contaLibri=0;
	for(int i=0;i<NUM_RIPIANI;i++)
	    contaLibri+=ripiani[i].getNumVolumi();
	return contaLibri;
    }
    public int getNumLibri(int ripiano) //Restituisce il numero di libri presenti sul ripiano "ripiano"
    {
	if(ripiano<0 || ripiano>NUM_RIPIANI)
	    return -1; //Ripiano non valido
	return ripiani[ripiano].getNumVolumi();
    }
    
    /**
     * Restituisce tutti i titoli dei libri dell'autore "autore"
     * @param autore
     * @return titoli dei libri dello stesso autore
     */
    public String[] elencoTitoliAutore(String autore)
    {
    //STEP 1: conto quanti libri dell'autore "autore" sono presenti
	int contaLibriAutore=0;
	Libro lib;
	String[] elencoTitoliAutore;
	for(int i=0;i<getNumRipiani();i++)
	{
	    for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
	    {
		try
                {
                    lib=getLibro(i, j);
                    if(lib.getAutore().equals(autore))
			contaLibriAutore++;
                }
                catch(EccezioneRipianoNonValido e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneNonValida e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneVuota e)
                {
                    //non fare nulla
                }
	    }
	}
        if(contaLibriAutore==0)
            return null; //non ci sono libri di quell'autore
    //STEP 2: istanzio l'array con l'elenco dei titoli dei libri dello stesso autore
	elencoTitoliAutore=new String[contaLibriAutore];
	contaLibriAutore=0;
	for(int i=0;i<getNumRipiani();i++)
	{
	    for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
	    {
		try
                {
                    lib=getLibro(i, j);
                    if(lib.getAutore().equals(autore))
		    {
			elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
			contaLibriAutore++;
		    }
                }
                catch(EccezioneRipianoNonValido e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneNonValida e)
                {
                       //non succederà mai
                }
                catch(EccezionePosizioneVuota e)
                {
                    //non fare nulla
                }
	    }
	}
	return elencoTitoliAutore;
    }
    
    /**
     * Restituisce elenco dei libri ordinati per titolo crescente (A-Z)
     * @return elenco libri ordinati per titolo crescente
     */
    public Libro[] elencoLibriOrdinatiPerTitoloAZ()
    {
    //STEP 1: conto quanti libri sono presenti
	Libro[] elencoLibriOrdinati=new Libro[getNumLibri()];
	Libro lib;
	int c=0; //contatore
	for(int i=0;i<getNumRipiani();i++)
	{
	    for(int j=0;j<getNumMaxLibri(i);j++)
	    {
		try
                {
                    lib=getLibro(i, j);
                    elencoLibriOrdinati[c]=lib;
                    c++;
                }
                catch(EccezioneRipianoNonValido e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneNonValida e)
                {
                    //non succederà mai
                }
                catch(EccezionePosizioneVuota e)
                {
                    //non fare nulla
                }
	    }
	}
    //STEP 2: istanzio l'array con i libri ordinati
        elencoLibriOrdinati=Ordinatore.alfabeticoCrescente(elencoLibriOrdinati);
	return elencoLibriOrdinati;
    }
    
    /**
     * Esporta libri su file in formato CSV
     * @param f1
     * @param nomeFileCSV
     * @param datiLibro
     * @param s1
     * @param lib
     */
    public void esportaCSV(TextFile f1, String nomeFileCSV, String datiLibro, Scaffale s1, Libro lib)
    {
        try
        {
            f1=new TextFile(nomeFileCSV, 'W');
            for(int i=0;i<s1.getNumRipiani();i++)
            {
                for(int j=0;j<s1.getNumMaxLibri(i);j++)
                {
                    try
                    {
                        lib=s1.getLibro(i, j);
                        datiLibro=i+";"+j+";"+lib.getTitolo()+";"+lib.getAutore()+";"+lib.getNumeroPagine();
                        f1.toFile(datiLibro);
                    }
                    catch(FileException e)
                    {
                        System.out.println(e.toString());
                    }
                    catch(EccezioneRipianoNonValido | EccezionePosizioneNonValida e)
                    {
                        //non si verificherà mai
                    }
                    catch(EccezionePosizioneVuota e)
                    {
                        //non fare nulla, continua
                    }
                }
            }
            f1.closeFile();
            System.out.println("Esportazione avvenuta correttamente!");
        }
        catch(IOException e)
        {
            System.out.println("Errore: impossibile accedere al file!");
        }
    }
    
    /**
     * Importa libri da file in formato CSV
     * @param f1
     * @param nomeFileCSV
     * @param s1
     * @param lib
     */
    public void importaCSV(TextFile f1, String nomeFileCSV, Scaffale s1, Libro lib)
    {
        try
        {
            f1=new TextFile(nomeFileCSV, 'R');
            System.out.println("Caricamento...");
            do{
                try
                {
                    String rigaLetta=f1.fromFile();
                    String[] datiVolume=rigaLetta.split(";");
                    int ripiano=Integer.parseInt(datiVolume[0]);
                    int posizione=Integer.parseInt(datiVolume[1]);
                    String titolo=datiVolume[2];
                    String autore=datiVolume[3];
                    int numeroPagine=Integer.parseInt(datiVolume[4]);
                    lib=new Libro(titolo, autore, numeroPagine);
                    try
                    {
                        s1.setLibro(lib, ripiano, posizione);
                        System.out.println("\tLibro "+titolo+" importato!");
                    }
                    catch(EccezioneRipianoNonValido e)
                    {
                        System.out.println("\tErrore: ripiano "+ripiano+" non valido per il libro "+titolo+"!");
                    }
                    catch(EccezionePosizioneNonValida e)
                    {
                        System.out.println("\tErrore: posizione "+posizione+" non valida per il libro "+titolo+"!");
                    }
                    catch(EccezionePosizioneOccupata e)
                    {
                        System.out.println("\tErrore: coordinata ("+ripiano+";"+posizione+") occupata! Libro "+titolo+" non importato!");
                    }
                }
                catch(FileException e)
                {
                    System.out.println("Fine del file!");
                    f1.closeFile();
                    System.out.println("Importazione terminata!");
                    break;
                }
            }while(true);
        }
        catch(IOException e)
        {
            System.out.println("Errore: impossibile accedere al file!");
        }
    }
    
    /**
     * Salva dati su file binario
     * @param s1
     * @param nomeFileBIN
     */
    public void salvaDati(Scaffale s1, String nomeFileBIN)
    {
        try
        {
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFileBIN));
            writer.writeObject(s1);
            writer.flush();
            writer.close();
            System.out.println("Salvataggio effettuato con successo!");
        }
        catch(IOException e)
        {
            System.out.println("Errore: impossibile accedere al file!");
        }
    }
    
    /**
     * Carica dati da file binario
     * @param s1
     * @param nomeFileBIN
     */
    public void caricaDati(Scaffale s1, String nomeFileBIN)
    {
        try
        {
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBIN));
            s1=(Scaffale)reader.readObject();
            reader.close();
            System.out.println("Caricamento avvenuto con successo!");
        }
        catch(IOException e)
        {
            System.out.println("Errore: impossibile accedere al file!");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Errore: impossibile accedere al file!");
        }
    }
    
    /*/**
     * Salva su file binario e chiude l'applicazione
     * @param s1
     * @param nomeFileBIN
     */
    /*public void salvaEsci(Scaffale s1, String nomeFileBIN)
    {
        try
        {
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFileBIN));
            writer.writeObject(s1);
            writer.flush();
            writer.close();
            System.out.println("Salvataggio effettuato con successo!");
        }
        catch(IOException e)
        {
            System.out.println("Errore: impossibile accedere al file!");
        }
        voceMenuScelta=0;
        System.out.println("Arrivederci!");
    }*/
    
    /**
     * Restituisce una stringa con tutti i dati dei libri presenti nello scaffale
     * @return libri presenti nello scaffale
     */
    public String toString()
    {
	String s="";
	for(int i=0;i<NUM_RIPIANI;i++)
	    s+="Ripiano"+i+":\n"+ripiani[i].toString();
	return s;
    }
}