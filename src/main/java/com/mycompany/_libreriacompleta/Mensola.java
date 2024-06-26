/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreriacompleta;

import java.io.Serializable;
import eccezioni.*;

/**
 *
 * @author Studente
 */
public class Mensola implements Serializable
{
    private Libro[] volumi;
    private final static int NUM_MAX_VOLUMI=15;
    
    /**
     * Costruttore
     */
    public Mensola()
    {
	volumi=new Libro[NUM_MAX_VOLUMI];
    }
    
    /**
     * Costruttore di copia
     * @param mensola
     */
    public Mensola(Mensola mensola)
    {
	Libro lib;
	volumi=new Libro[NUM_MAX_VOLUMI];
	for(int i=0;i<NUM_MAX_VOLUMI;i++)
	{
	    try
            {
                lib=mensola.getVolume(i);
                if(lib!=null)
                    this.setVolume(lib, i);
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
    
    /**
     * Nuovo costruttore
     * Restituisco una mensola con al massimo 15 libri dall'array elencoLibri
     * @param elencoLibri
     */
    public Mensola(Libro[] elencoLibri)
    {
	volumi=new Libro[NUM_MAX_VOLUMI];
	int numeroLibri;
	//se i libri da aggiungere sono troppi aggiungo solo NUM_MAX_VOLUMI
        numeroLibri=elencoLibri.length;
        if(numeroLibri>NUM_MAX_VOLUMI)
            numeroLibri=NUM_MAX_VOLUMI;
        //Copio l'i-esimo libro dell'array
        for(int i=0;i<numeroLibri;i++)
        {
            if(elencoLibri[i]!=null)
               try
               {
                   setVolume(elencoLibri[i], i);
               } 
               catch(EccezionePosizioneNonValida e)
               {
                   //non succederà mai
               }
               catch(EccezionePosizioneOccupata e)
               {
                   //non succederà mai
               }
        }
    }
    
    /**
     * Aggiunge il volume alla mensola in posizione "posizione"
     * @param volume
     * @param posizione
     */
    public void setVolume(Libro volume, int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
	if(posizione<0 || posizione>=NUM_MAX_VOLUMI)
	    throw new EccezionePosizioneNonValida();
	if(volumi[posizione]!=null)
	    throw new EccezionePosizioneOccupata();
	volumi[posizione]=new Libro(volume);
    }
    
    /**
     * Restituisce il volume della mensola in posizione "posizione"
     * @param posizione
     * @return
     * se la posizione non esiste --> return null
     * se la posizione è vuota --> return null
     * se la posizione è occupata --> return volume
     */
    public Libro getVolume(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
	Libro lib;
	if(posizione<0 || posizione>=NUM_MAX_VOLUMI)
	    throw new EccezionePosizioneNonValida();
	if(volumi[posizione]==null)
	    throw  new EccezionePosizioneVuota();
        lib=volumi[posizione];
            return new Libro(lib); //restituisco una copia del libro
    }
    
    /**
     * Libera la posizione "posizione" e restituisce il numero della posizione liberata
     * @param posizione
     */
    public void rimuoviVolume(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
	if(posizione<0 || posizione>=NUM_MAX_VOLUMI)
	    throw new EccezionePosizioneNonValida();
	if(volumi[posizione]==null)
	    throw new EccezionePosizioneVuota();
	volumi[posizione]=null;
    }
    
    public int getNumMaxVolumi()
    {
	return NUM_MAX_VOLUMI;
    }
    
    /**
     * Restituisce il numero di libri presenti sulla mensola
     * @return
     */
    public int getNumVolumi()
    {
	int numeroVolumiPresenti=0;
	for(int i=0;i<NUM_MAX_VOLUMI;i++)
	{
	    if(volumi[i]!=null)
		numeroVolumiPresenti++;
	}
	return numeroVolumiPresenti;
    }
    
    /**
     * Restituisce true se esiste un libro con lo stesso titolo
     * @param titolo
     * @return
     * se presente --> true
     * se assente --> false
     */
    public boolean presenzaTitolo(String titolo)
    {
	for(int i=0;i<NUM_MAX_VOLUMI;i++)
	{
	    if(volumi[i]!=null)
	    {
		if(volumi[i].getTitolo().equals(titolo))
		    return true;
	    }
	}
	return false;
    }
    
    /**
     * Restituisce una stringa con tutti i dati dei libri presenti sulla mensola
     * @return libri presenti sulla mensola
     */
    public String toString()
    {
	String s="";
	for(int i=0;i<NUM_MAX_VOLUMI;i++)
	{
	    if(volumi[i]==null)
		s+=i+"-->\n";
	    else
		s+=i+"-->"+volumi[i].toString()+"\n";
	}
	return s;
    }
}