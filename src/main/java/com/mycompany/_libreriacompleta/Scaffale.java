/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreriacompleta;

import utilita.Ordinatore;

/**
 *
 * @author Studente
 */
public class Scaffale
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
	{
	    ripiani[i]=new Mensola();
	    for(int j=0;j<scaffale.getNumMaxLibri(i);j++)
	    {
		lib=scaffale.getLibro(i, j);
		if(lib!=null)
		    scaffale.setLibro(lib, i, j);
	    }
	}
    }

    
    /**
     * Inserisce il libro nella posizione "posizione" del ripiano "ripiano".
     * @param libro
     * @param ripiano
     * @param posizione
     * @return
     * se il ripiano non è valido --> return -3
     * se la posizione non è valida --> return -1 
     * se la posizione è occupata --> return -2
     * se il libro viene posizionato --> return 0
     */
    public int setLibro(Libro libro, int ripiano, int posizione)
    {
	int esito;
	if(ripiano<0 || ripiano>=NUM_RIPIANI)
	    return -3; //ripiano non valido
	esito=ripiani[ripiano].setVolume(libro, posizione);
	if(esito>0)
	    return 0;
	else
	    return esito;
    }
    /**
     * Restituisce il libro nella posizione "posizione" del ripiano "ripiano".
     * @param ripiano
     * @param posizione
     * @return
     * se il ripiano non è valido --> return null
     * se la posizione non è valida --> return null
     * se la posizione è vuota --> return null
     * se il libro è presente --> restituisce l’oggetto libro
     */
    public Libro getLibro(int ripiano, int posizione)
    {
	Libro lib;
	if(ripiano<0 || ripiano>=NUM_RIPIANI)
	    return null; //ripiano non valido
	lib=ripiani[ripiano].getVolume(posizione);
	return lib;
    }
    /**
     * Libera la posizione "posizione" del ripiano "ripiano"
     * @param ripiano
     * @param posizione
     * @return
     * se la posizione non esiste --> return -1
     * se la posizione è già vuota --> return -2
     * se la posizione è occupata --> return posizione liberata
     */
    public int rimuoviLibro(int ripiano, int posizione)
    {
	int esito;
	if(ripiano<0 || ripiano>=NUM_RIPIANI)
	    return -3; //ripiano non valido
	esito=ripiani[ripiano].rimuoviVolume(posizione);
	if(esito>=0)
	    return 0;
	else
	    return esito;
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
		lib=getLibro(i, j);
		if(lib!=null)
		{
		    if(lib.getAutore().equals(autore))
			contaLibriAutore++;
		}
	    }
	}
    //STEP 2: istanzio l'array con l'elenco dei titoli dei libri dello stesso autore
	elencoTitoliAutore=new String[contaLibriAutore];
	contaLibriAutore=0;
	for(int i=0;i<getNumRipiani();i++)
	{
	    for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
	    {
		lib=getLibro(i, j);
		if(lib!=null)
		{
		    if(lib.getAutore().equals(autore))
		    {
			elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
			contaLibriAutore++;
		    }
		}
	    }
	}
	if(contaLibriAutore==0)
	    return null; //non ci sono libri dell'autore "autore"
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
		lib=getLibro(i, j);
		if(lib!=null)
		{
		    elencoLibriOrdinati[c]=lib;
		    c++;
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