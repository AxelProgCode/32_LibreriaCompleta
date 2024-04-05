/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreriacompleta;

/**
 *
 * @author Studente
 */
public class Mensola
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
	    lib=mensola.getVolume(i);
	    if(lib!=null)
		this.setVolume(lib, i);
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
	int numeroLibri=0;
	//se elecoLibri non contiene libri
	if(elencoLibri.length==0)
	    return;
	if(elencoLibri.length>NUM_MAX_VOLUMI)
	    numeroLibri=NUM_MAX_VOLUMI;
	else
	    numeroLibri=elencoLibri.length;
	//copio l'i-esimo libro dell'array in volumi
	for(int i=0;i<numeroLibri;i++)
	{
	    if(elencoLibri[i]!=null)
		volumi[i]=new Libro(elencoLibri[i]);
	}
    }
    
    /**
     * Aggiunge il volume alla mensola in posizione "posizione"
     * @param volume
     * @param posizione
     * @return
     * se la posizione non esiste --> return -1
     * se la posizione è già occupata --> return -2
     * se il libro viene posizionato --> return posizione
     */
    public int setVolume(Libro volume, int posizione)
    {
	if(posizione<0 || posizione>=NUM_MAX_VOLUMI)
	    return -1; //posizione non valida
	if(volumi[posizione]!=null)
	    return -2; //posizione occupata
	volumi[posizione]=new Libro(volume);
	return posizione;
    }
    /**
     * Restituisce il volume della mensola in posizione "posizione"
     * @param posizione
     * @return
     * se la posizione non esiste --> return null
     * se la posizione è vuota --> return null
     * se la posizione è occupata --> return volume
     */
    public Libro getVolume(int posizione)
    {
	
	if(posizione<0 || posizione>=NUM_MAX_VOLUMI)
	    return null; //posizione non valida
	if(volumi[posizione]==null)
	    return null; //posizione vuota
	return new Libro(volumi[posizione]);
    }
    /**
     * Libera la posizione "posizione" e restituisce il numero della posizione liberata
     * @param posizione
     * @return
     * se la posizione non esiste --> return -1
     * se la posizione è già vuota --> return -2
     * se la posizione è occupata --> return posizione liberata
     */
    public int rimuoviVolume(int posizione)
    {
	if(posizione<0 || posizione>=NUM_MAX_VOLUMI)
	    return -1; //posizione non valida
	if(volumi[posizione]==null)
	    return -2; //posizione vuota
	volumi[posizione]=null;
	return posizione;
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