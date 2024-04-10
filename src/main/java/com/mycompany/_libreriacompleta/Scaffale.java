/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreriacompleta;

import java.io.Serializable;
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
    
    public int getNumRipiani() //Restituisce il numero di riapiani/mensole presenti in uno scaffale
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