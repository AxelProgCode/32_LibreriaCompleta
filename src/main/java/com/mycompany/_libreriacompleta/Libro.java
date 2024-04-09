/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreriacompleta;

/**
 * Rappresenta un libro
 * double costoPagina rappresenta il costo necessario per realizzare ogni pagina del libro
 * double COSTO_FISSO rappresenta il costo fisso per realizzare ogni libro
 * 
 * @author Studente
 */
public class Libro
{
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina=0.05;
    static final double COSTO_FISSO=5.5;
    
    /**
     * Costruttore
     * @param titolo
     * @param autore
     * @param numeroPagine
     */
    public Libro(String titolo, String autore, int numeroPagine)
    {
	setTitolo(titolo);
	setAutore(autore);
	setNumeroPagine(numeroPagine);
    }
    
    /**
     * Costruttore di copia
     * @param libro
     */
    public Libro(Libro libro)
    {
	this.titolo=libro.getTitolo();
	this.autore=libro.getAutore();
	this.numeroPagine=libro.getNumeroPagine();
    }
    
    public void setTitolo(String titolo)
    {
	this.titolo=titolo;
    }
    public void setAutore(String autore)
    {
	this.autore=autore;
    }
    public void setNumeroPagine(int numeroPagine)
    {
	this.numeroPagine=numeroPagine;
    }

    public String getTitolo()
    {
	return titolo;
    }
    public String getAutore()
    {
	return autore;
    }
    public int getNumeroPagine()
    {
	return numeroPagine;
    }
    public double getCostoPagina()
    {
	return costoPagina;
    }
    public static void setCostoPagina(double costoPag)
    {
        costoPagina=costoPag;
    }
    public double getCostoFisso()
    {
        return COSTO_FISSO;
    }
    
    /**
     * Calcola il costo di un libro come somma di COSTO_FISSO e numeroPagine*costoPagina
     * @return costo del libro
     */
    public double prezzo()
    {
	double prezzo=COSTO_FISSO+getCostoPagina()*getNumeroPagine();
	return prezzo;
    }
    
    /**
     * Restituisce una stringa con tutti i valori degli attributi di un libro
     * @return valore di ogni attributo
     */
    public String toString()
    {
	String s="\tTitolo: "+getTitolo()+"\n\tAutore: "+getAutore()+"\n\tPagine: "+getNumeroPagine()+"\n\tPrezzo: €"+prezzo();
	return s;
    }
}