/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.*;

/**
 * Classe che rappresenta un menu
 * La classe consente di:
 * - visualizzare le voci del menu
 * - far scegliere all'utente una voce del menu
 * - restituire il valore associato alla voce scelta dall'utente
 * elencoVoci: array di stringhe dove ogni stringa rappresenta una
 * voce del menu, ad ogni voce del menu è associato un valore intero
 * numeroVoci: valore intero che rappresenta il numero delle voci presenti
 * @author Studente
 */
public class Menu
{
    private String[] elencoVoci;
    private int numeroVoci;
    /**
     * Costruttore
     * @param elencoVoci Rappresenta l'elenco delle voci da cui è costituito il menu
     */
    public Menu(String[] elencoVoci)
    {
	numeroVoci=elencoVoci.length;
	this.elencoVoci=new String[numeroVoci];
	for(int i=0;i<numeroVoci;i++)
	    this.elencoVoci[i]=elencoVoci[i];
    }
    /**
     * Visualizza le voci del menu
     */
    public void visualizzaMenu()
    {
	System.out.println("MENU:");
	for(int i=0;i<numeroVoci;i++)
	    System.out.println(elencoVoci[i]);
    }
    /**
     * Permette all'utente di scegliere una voce del menu
     * I valori interi associati alle voci del menu
     * vanno da 0 al numeroVoci-1
     * @return valore intero associato alla voce scelta
     */
    public int sceltaMenu()
    {
	int sceltaUtente=0;
	boolean inputUtenteOK=true;
	
	do{
	    ConsoleInput tastiera=new ConsoleInput();
	    inputUtenteOK=true;
	    visualizzaMenu();
	    System.out.print("Scelta --> ");
	    try
	    {
		sceltaUtente=tastiera.readInt();
		//verifico se il numero inserito è compreso nelle voci del menu
		if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
		{
		    inputUtenteOK=false;
		    System.out.println("Errore: voce non presente!");
		}
	    }
	    catch(IOException e)
	    {
		System.out.println("Errore: impossibile leggere da tastiera!");
	    }
	    catch(NumberFormatException e)
	    {
		System.out.println("Errore: valore inserito non valido (formato non corretto), riprova.");
		inputUtenteOK=false;
	    }
	}while(!inputUtenteOK);
	return sceltaUtente;
    }
}