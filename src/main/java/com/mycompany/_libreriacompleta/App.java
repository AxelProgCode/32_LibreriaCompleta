/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreriacompleta;

import java.io.*;
import utilita.*;
import eccezioni.*;

/**
 *
 * @author Studente
 */
public class App
{
    public static void main(String[] args)
    {
        int numeroVociMenu=12;
	int voceMenuScelta;
	String[] vociMenu=new String[numeroVociMenu];
	ConsoleInput tastiera=new ConsoleInput();
	Scaffale s1=new Scaffale();
        String titolo,autore,datiLibro;
	String[] elencoTitoliAutore;
        Libro[] elencoLibriOrdinatiAlfabeticamente;
        Libro lib;
	TextFile f1;
        String nomeFileCSV="Libri.csv";
	String nomeFileBIN="Libreria.bin";
        int numeroPagine,ripiano,posizione;
	
	vociMenu[0]="0 --> Esci";
	vociMenu[1]="1 --> Visualizza tutti i volumi dello scaffale";
	vociMenu[2]="2 --> Aggiungi volume (ripiano, posizione)";
	vociMenu[3]="3 --> Cerca volume (ripiano, posizione)";
	vociMenu[4]="4 --> Elimina volume (ripiano, posizione)";
	vociMenu[5]="5 --> Mostra titoli di uno specifico autore (autore)";
	vociMenu[6]="6 --> Mostra elenco libri ordinati alfabeticamente per titolo (A-Z)";
        vociMenu[7]="7 --> Esporta libri su file in formato CSV";
	vociMenu[8]="8 --> Importa libri da file in formato CSV";
	vociMenu[9]="9 --> Salva dati";
	vociMenu[10]="10 --> Carica dati";
	vociMenu[11]="11 --> Salva & Esci";
	
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
		    System.out.println("Inserisci dati libro:");
		    try
		    {
			System.out.print("Titolo --> ");
			titolo=tastiera.readString();
			System.out.print("Autore --> ");
			autore=tastiera.readString();
			do{
			    try
			    {
				System.out.print("Numero pagine --> ");
				numeroPagine=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
			do{
			    try
			    {
				System.out.print("Ripiano (0..4) --> ");
				ripiano=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
			do{
			    try
			    {
				System.out.print("Posizione (0..14) --> ");
				posizione=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
                        lib=new Libro(titolo,autore,numeroPagine);
                        s1.setLibro(lib,ripiano,posizione);
                        System.out.println("Libro inserito correttamente!");
                    }
                    catch(IOException e)
                    {
                        System.out.println("Errore: Impossibile leggere da tastiera.");
                    }
                    catch(EccezioneRipianoNonValido e)
                    {
                        System.out.println("Errore: Ripiano non valido!");
                    }
                    catch(EccezionePosizioneNonValida e)
                    {
                        System.out.println("Errore: Posizione non valida!");
                    }
                    catch(EccezionePosizioneOccupata e)
                    {
                        System.out.println("Errore: Posizione occupata!");
                    }
		    break;
		case 3:
		    try
		    {
			do{
			    try
			    {
				System.out.print("Ripiano (0..4) --> ");
				ripiano=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
			do{
			    try
			    {
				System.out.print("Posizione (0..14) --> ");
				posizione=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
                        lib=s1.getLibro(ripiano,posizione);
                        System.out.println("Libro trovato:\n"+lib.toString());
		    }
		    catch(IOException e)
		    {
			System.out.println("Errore: impossibile leggere da tastiera!");
		    }
                    catch(EccezioneRipianoNonValido e)
                    {
                        System.out.println("Errore: Ripiano non valido!");
                    }
                    catch(EccezionePosizioneNonValida e)
                    {
                        System.out.println("Errore: Posizione non valida!");
                    }
                    catch(EccezionePosizioneVuota e)
                    {
                        System.out.println("Errore: Nessun libro presente!");
                    }
		    break;
		case 4:
		    try
		    {
			do{
			    try
			    {
				System.out.print("Inserisci il ripiano del libro da eliminare (0..4): ");
				ripiano=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
			do{
			    try
			    {
				System.out.print("Inserisci la posizione del libro da eliminare (0..14): ");
				posizione=tastiera.readInt();
				break;
			    }
			    catch(NumberFormatException e)
			    {
				System.out.println("Errore: input non corretto!");
			    }
			}while(true);
			s1.rimuoviLibro(ripiano, posizione);
			System.out.println("Libro eliminato correttamente!");
			}
			catch(IOException e)
			{
			    System.out.println("Errore: impossibile leggere da tastiera!");
			}
			catch(EccezioneRipianoNonValido e)
			{
			    System.out.println("Errore: ripiano non valido!");
			}
			catch(EccezionePosizioneNonValida e)
			{
			    System.out.println("Errore: posizione non valida!");
			}
			catch(EccezionePosizioneVuota e)
			{
			    System.out.println("Errore: posizione già vuota!");
			}
		    break;
		case 5:
		    try
		    {
			System.out.print("Inserisci autore: ");
			autore=tastiera.readString();
			elencoTitoliAutore=s1.elencoTitoliAutore(autore);
			if(elencoTitoliAutore!=null)
			{
                            System.out.println("Titoli:");
			    for(int i=0;i<elencoTitoliAutore.length;i++)
				System.out.println("\t"+elencoTitoliAutore[i]);
			}
			else
			    System.out.println("Nessun libro presente per l'autore scelto");
		    }
		    catch(IOException e)
		    {
			System.out.println("Errore: impossibile leggere da tastiera!");
		    }
		    break;
		case 6:
		    System.out.println("Elenco libri ordinati per titolo (A-Z):");
		    elencoLibriOrdinatiAlfabeticamente=s1.elencoLibriOrdinatiPerTitoloAZ();
		    for(int i=0;i<elencoLibriOrdinatiAlfabeticamente.length;i++)
		    {
			System.out.println("\n"+elencoLibriOrdinatiAlfabeticamente[i].toString());
		    }
		    break;
		case 7:
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
		    break;
		case 8:
		    try
		    {
			f1=new TextFile(nomeFileCSV, 'R');
			System.out.println("Caricamento...");
			do{
			    try
			    {
				String rigaLetta=f1.fromFile();
				String[] datiVolume=rigaLetta.split(";");
				ripiano=Integer.parseInt(datiVolume[0]);
				posizione=Integer.parseInt(datiVolume[1]);
				titolo=datiVolume[2];
				autore=datiVolume[3];
				numeroPagine=Integer.parseInt(datiVolume[4]);
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
		    break;
		case 9:
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
		    break;
		case 10:
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
		    break;
		case 11:
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
		    break;
		default:
		    System.out.println("Valore inserito non valido, riprova.");
	    }
	}while(voceMenuScelta!=0);
    }
}