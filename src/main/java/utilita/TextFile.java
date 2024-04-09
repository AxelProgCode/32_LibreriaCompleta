/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;
import eccezioni.FileException;
import java.io.*;

/**
 * La classe rappresenta un file di testo
 * La classe consente di:
 * - scrivere una stringa sul file di testo (anche in append)
 * - leggere una stringa dal file di testo
 * - chiudere il file di testo
 * @author Studente
 */
public class TextFile
{
    private char mode; //R=reader/lettura - W=writer/scrittura
    private BufferedReader reader;
    private BufferedWriter writer;
    
    /**
     * Costruttore (senza append)
     * @param nomeFile nome del file da creare o aprire
     * @param mode modalità di apertura: 'R' per lettura o 'W' per scrittura
     * @throws FileNotFoundException se non trova il file, ma se aperto in scrittura viene creato
     * @throws IOException se non è possibile accedere al file
     */
    public TextFile(String nomeFile, char mode) throws FileNotFoundException, IOException
    {
	this.mode='R'; //modalità di default
	if(mode=='W' || mode=='w')
	    this.mode='W';
	if(this.mode=='R')
	    reader=new BufferedReader(new FileReader(nomeFile));
	else
	    writer=new BufferedWriter(new FileWriter(nomeFile));
    }
    
    /**
     * Costruttore (con append)
     * @param nomeFile nome del file da creare o aprire
     * @param mode modalità di apertura: 'R' per lettura o 'W' per scrittura
     * @param append "true" per aprire il file in scrittura in append o "false" per aprire il file in scrittura senza append
     * @throws FileNotFoundException se non trova il file, ma se aperto in scrittura viene creato
     * @throws IOException se non è possibile accedere al file
     */
    public TextFile(String nomeFile, char mode, boolean append) throws FileNotFoundException, IOException
    {
	this.mode='R'; //modalità di default
	if(mode=='W' || mode=='w')
	    this.mode='W';
	if(this.mode=='R')
	    reader=new BufferedReader(new FileReader(nomeFile));
	else
	    writer=new BufferedWriter(new FileWriter(nomeFile,append));
    }
    
    /**
     * Scrive una stringa sul file
     * @param line stringa da scrivere sul file
     * @throws FileException se il file è aperto in lettura
     * @throws IOException se non è possibile accedere al file
     */
    public void toFile(String line) throws FileException, IOException
    {
	if(mode=='R')
	    throw new FileException("Errore: file aperto in lettura!");
	writer.write(line);
	writer.newLine();
    }
    
    /**
     * Legge una riga dal file
     * La prima volta che viene invocato questo metodo viene letta la prima riga del file
     * e ogni volta che viene invocato nuovamente viene letta la stringa successiva
     * @return una riga del file
     * @throws FileException se il file è aperto in scrittura o si è raggiunta la fine del file
     * @throws IOException se non è possibile accedere al file
     */
    public String fromFile() throws FileException, IOException
    {
	if(mode=='W')
	    throw new FileException("Errore: file aperto in scrittura!");
	String s=reader.readLine();
	if(s==null)
	    throw new FileException("Fine del file!");
	return s;
    }
    
    /**
     * Chiude il file
     * @throws IOException se non è possibile accedere al file
     */
    public void closeFile() throws IOException
    {
	if(mode=='R')
	    reader.close();
	else
	    writer.close();
    }
}