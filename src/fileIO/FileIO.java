package fileIO;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {
	// FIX FOLDER NAMES

	public double[][] getTransactionStores(String filename) throws FileNotFoundException 
	{     
		 	
		  Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
	      int rows = 32;
	      int columns = 37;
	      double[][] storesArray = new double[rows][columns];
	      while(sc.hasNextLine()) {
	         for (int i=0; i<storesArray.length; i++) {
	            String[] line = sc.nextLine().trim().split(",");
	            
	            for (int j=0; j<line.length; j++) {
	               
	            	storesArray[i][j] = Double.parseDouble(line[j]);    
	     
	     	         }
	         	}
	      }
	   return storesArray;
	   }
	
	public String[][] getItems(String filename) throws FileNotFoundException
	{
		
		  Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
	      int rows = 32;
	      int columns = 3;
	      String[][] itemsArray = new String[rows][columns];
	      while(sc.hasNextLine()) {
	         for (int i=0; i<itemsArray.length; i++) {
	            String[] line = sc.nextLine().trim().split(",");
	            for (int j=0; j<line.length; j++) {
	               itemsArray[i][j] = line[j];
	               
	            }
	         }
	      }
	    return itemsArray;
		
	}
		
		
	}
