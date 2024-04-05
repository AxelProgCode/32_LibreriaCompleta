/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreriacompleta;

import java.util.Scanner;
import utilita.Menu;

/**
 *
 * @author Studente
 */
public class App
{
    public static void main(String[] args)
    {
        int numeroVociMenu=7;
	int voceMenuScelta;
	String[] vociMenu=new String[numeroVociMenu];
	Scanner tastiera=new Scanner(System.in);
	Scaffale s1=new Scaffale();
	String titolo,autore;
	Libro[] elencoLibriOrdinatiAlfabeticamente;
	String[] elencoTitoliAutore;
	int numeroPagine,ripiano,posizione;
	int esito;
	
	vociMenu[0]="0 --> Esci";
	vociMenu[1]="1 --> Visualizza tutti i volumi dello scaffale";
	vociMenu[2]="2 --> Aggiungi volume (ripiano, posizione)";
	vociMenu[3]="3 --> Cerca volume (ripiano, posizione)";
	vociMenu[4]="4 --> Elimina volume (ripiano, posizione)";
	vociMenu[5]="5 --> Mostra titoli di uno specifico autore (autore)";
	vociMenu[6]="6 --> Mostra elenco libri ordinati alfabeticamente per titolo (A-Z)";
	
	Menu menu=new Menu(vociMenu);
	
	do{
	    voceMenuScelta=menu.sceltaMenu();
	    switch(voceMenuScelta)
	    {
		case 0:
		    System.out.println("Arrivederci!");
		    break;
		case 1:
		    System.out.println(s1.toString());
		    break;
		case 2:
		    System.out.print("Inserisci dati libro: (invio per continuare...)");
		    tastiera.nextLine(); //svuoto buffer
		    System.out.print("Titolo --> ");
		    titolo=tastiera.nextLine();
		    System.out.print("Autore --> ");
		    autore=tastiera.nextLine();
		    System.out.print("Numero pagine --> ");
		    numeroPagine=tastiera.nextInt();
		    Libro lib=new Libro(titolo,autore,numeroPagine);
		    System.out.print("Ripiano (0..4) --> ");
		    ripiano=tastiera.nextInt();
		    System.out.print("Posizione (0..14) --> ");
		    posizione=tastiera.nextInt();
		    esito=s1.setLibro(lib, ripiano, posizione);
		    switch(esito)
		    {
			case -1:
			    System.out.println("Posizione non valida!");
			    break;
			case -2:
			    System.out.println("Posizione occupata!");
			    break;
			case -3:
			    System.out.println("Ripiano non valido!");
			    break;
			default:
			    System.out.println("Libro inserito correttamente!");
		    }
		    break;
		case 3:
		    System.out.print("Ripiano (0..4) --> ");
		    ripiano=tastiera.nextInt();
		    System.out.print("Posizione (0..14) --> ");
		    posizione=tastiera.nextInt();
		    lib=s1.getLibro(ripiano, posizione);
		    if(lib==null)
			System.out.println("Libro non trovato!");
		    else
			System.out.println("Libro trovato:\n"+lib.toString());
		    break;
		case 4:
		    System.out.print("Inserisci il ripiano del libro da eliminare: ");
                    ripiano=tastiera.nextInt();
		    System.out.print("Inserisci la posizione del libro da eliminare: ");
		    posizione=tastiera.nextInt();
                    esito=s1.rimuoviLibro(ripiano,posizione);
                    if(esito==-3)
			System.out.println("Ripiano non valido!");
		    else if(esito==-1)
			System.out.println("Posizione non valida!");
		    else if(esito==-2)
			System.out.println("Posione già vuota!");
		    else
			System.out.println("Libro eliminato correttamente!");
		    break;
		case 5:
		    System.out.print("Inserisci autore: ");
		    autore=tastiera.nextLine();
		    elencoTitoliAutore=s1.elencoTitoliAutore(autore);
		    if(elencoTitoliAutore!=null)
		    {
			for(int i=0;i<elencoTitoliAutore.length;i++)
			    System.out.println(elencoTitoliAutore[i]);
		    }
		    break;
		case 6:
		    System.out.println("Elenco libri ordinati per titolo (A-Z):");
		    elencoLibriOrdinatiAlfabeticamente=s1.elencoLibriOrdinatiPerTitoloAZ();
		    for(int i=0;i<elencoLibriOrdinatiAlfabeticamente.length;i++)
		    {
			System.out.println("");
			System.out.println(elencoLibriOrdinatiAlfabeticamente[i].toString());
		    }
		    break;
		default:
		    System.out.println("Valore inserito non valido, riprova.");
	    }
	}while(voceMenuScelta!=0);
    }
}