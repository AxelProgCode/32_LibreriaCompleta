/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.util.Scanner;

/**
 *
 * @author Studente
 */
public class Menu
{
    private String[] elencoVoci;
    private int numeroVoci;
    /**
     * Costruttore
     * @param elencoVoci
     */
    public Menu(String[] elencoVoci)
    {
	numeroVoci=elencoVoci.length;
	this.elencoVoci=new String[numeroVoci];
	for(int i=0;i<numeroVoci;i++)
	    this.elencoVoci[i]=elencoVoci[i];
    }
    /**
     * Fa visualizzare le voci del menu
     */
    public void visualizzaMenu()
    {
	System.out.println("MENU:");
	for(int i=0;i<numeroVoci;i++)
	    System.out.println(elencoVoci[i]);
    }
    /**
     * Permette all'utente di scegliere una voce del menu
     * @return metodo invocato
     */
    public int sceltaMenu()
    {
	String inputUtente;
	int sceltaUtente=0;
	boolean inputUtenteOK=true;
	
	do{
	    Scanner tastiera=new Scanner(System.in);
	    inputUtenteOK=true;
	    visualizzaMenu();
	    System.out.print("Scelta --> ");
	    inputUtente=tastiera.nextLine();
	    //verifico se l'inputUtente è un numero compreso tra 0 e 9
	    for(int i=0;i<inputUtente.length();i++)
	    {
		if(inputUtente.charAt(i)>='0' && inputUtente.charAt(i)<='9')
		    i++;
		else
		{
		    inputUtenteOK=false;
		    break; 
		}
	    }
	    //verifico se il numero inserito è compreso nelle voci del menu
	    if(inputUtenteOK)
	    {
		sceltaUtente=Integer.parseInt(inputUtente);
		if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
		    inputUtenteOK=false;
	    }

	    if(!inputUtenteOK)
		System.out.println("Valore inserito non valido, riprova.");
	}while(!inputUtenteOK);
	return sceltaUtente;
    }
}