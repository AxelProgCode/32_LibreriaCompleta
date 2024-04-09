/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import com.mycompany._libreriacompleta.Libro;

/**
 * Classe che contiene metodi statici per ordinare dei vettori
 * @author Studente
 */
public class Ordinatore
{
    /**
     * Scambia due elementi (pos1 e pos2) in un array di interi (array)
     * @param array array che contiene i due elementi da scambiare
     * @param pos1 posizione del primo elemento
     * @param pos2 posizione del secondo elemento
     */
    public static void scambia(int[] array, int pos1, int pos2)
    {
	int s;
	s=array[pos1];
	array[pos1]=array[pos2];
	array[pos2]=s;
    }
    
    /**
     * Scambia due elementi (pos1 e pos2) in un array di stringhe (array)
     * @param array array che contiene i due elementi da scambiare
     * @param pos1 posizione del primo elemento
     * @param pos2 posizione del secondo elemento
     */
    public static void scambia(String[] array, int pos1, int pos2)
    {
	String s;
	s=array[pos1];
	array[pos1]=array[pos2];
	array[pos2]=s;
    }
//SELECTION SORT
    /**
     * Restituisce un array di interi in ordine crescente
     * @param a array da ordinare
     * @return copia dell'array ordinato in ordine crescente
     */
    public static int[] selectionSortCrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(aOrdinato[j]<aOrdinato[i])
		    scambia(aOrdinato, i, j);
	    }
	}
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di interi in ordine decrescente
     * @param a array da ordinare
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static int[] selectionSortDecrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(aOrdinato[j]>aOrdinato[i])
		    scambia(aOrdinato, i, j);
	    }
	}
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di stringhe in ordine alfabetico crescente (A-Z)
     * @param s array da ordinare
     * @return copia dell'array ordinato in ordine crescente
     */
    public static String[] selectionSortCrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[j])>0)
		    scambia(sOrdinato, i, j);
	    }
	}
	return sOrdinato;
    }
    
    /**
     * Restituisce un array di stringhe in ordine alfabetico decrescente (Z-A)
     * @param s array da ordinare
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static String[] selectionSortDecrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[j])<0)
		    scambia(sOrdinato, i, j);
	    }
	}
	return sOrdinato;
    }
//BUBBLE SORT
    /**
     * Restituisce un array di interi in ordine crescente
     * @param a
     * @return copia dell'array ordinato in ordine crescente
     */
    public static int[] bubbleSortCrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(aOrdinato[i]>aOrdinato[i+1])
		{
		    scambia(aOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di interi in ordine decrescente
     * @param a
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static int[] bubbleSortDecrescente(int[] a)
    {
	int N=a.length;
	int[] aOrdinato=new int[N];
	for(int i=0;i<N;i++)
	    aOrdinato[i]=a[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(aOrdinato[i]<aOrdinato[i+1])
		{
		    scambia(aOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return aOrdinato;
    }
    
    /**
     * Restituisce un array di stringhe in ordine alfabetico crescente (A-Z)
     * @param s
     * @return copia dell'array ordinato in ordine crescente
     */
    public static String[] bubbleSortCrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[i+1])>0)
		{
		    scambia(sOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return sOrdinato;
    }
    
    /**
     * Restituisce un array di stringhe in ordine alfabetico decrescente (Z-A)
     * @param s
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static String[] bubbleSortDecrescente(String[] s)
    {
	int N=s.length;
	String[] sOrdinato=new String[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	boolean scambioAvvenuto=false;
	do{
	    scambioAvvenuto=false;
	    for(int i=0;i<N-1;i++)
	    {
		if(sOrdinato[i].compareToIgnoreCase(sOrdinato[i+1])<0)
		{
		    scambia(sOrdinato, i, i+1);
		    scambioAvvenuto=true;
		}
	    }
	}while(scambioAvvenuto);
	return sOrdinato;
    }
//ORDINATORE LIBRI
    /**
     * Scambia due libri in pos1 e pos2 in un array di Libri (array)
     * @param array
     * @param pos1
     * @param pos2
     */
    public static void scambia(Libro[] array, int pos1, int pos2)
    {
	Libro s;
	s=array[pos1];
	array[pos1]=array[pos2];
	array[pos2]=s;
    }
    
    /**
     * Restituisce un array di libri in ordine alfabetico crescente (A-Z)
     * @param s array da ordinare
     * @return array in ordine alfabetico crescente
     */
    public static Libro[] alfabeticoCrescente(Libro[] s)
    {
	int N=s.length;
	Libro[] sOrdinato=new Libro[N];
	for(int i=0;i<N;i++)
	    sOrdinato[i]=s[i];
	for(int i=0;i<N-1;i++)
	{
	    for(int j=i;j<N;j++)
	    {
		if(sOrdinato[i].getTitolo().compareToIgnoreCase(sOrdinato[j].getTitolo())>0)
		    scambia(sOrdinato, i, j);
	    }
	}
	return sOrdinato;
    }
}