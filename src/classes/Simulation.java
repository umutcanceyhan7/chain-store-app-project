package classes;
import java.io.FileNotFoundException;

import chainStoreApp.ChainStoreApp.STORES;

public class Simulation {
	
	 private StoreQuery query;
	
	 public Simulation() throws FileNotFoundException
	 {  
		 this.query=new StoreQuery();
	 }
      
	 
	 public void printEachMonth() throws FileNotFoundException
	 {
		  int months = 12;
		  for(int i=1;i<=months;i++)
		  {   
			  STORES mostProfStore=query.findMostProfitableStoreForEachMonth(i);
			  System.out.println("Most profitable store in month "+(i)+" : "+mostProfStore );}
		  
	 }
	  
	 public void run() throws FileNotFoundException
	  {
	  System.out.println("The most profitable item for the year: " + query.findMostProfitableItemForYear());
	  System.out.println("The least profitable item for the year: "+ query.findLeastProfitableItemForYear());
	  System.out.println("Most profitable category for the year: "+ query.findMostProfitableCategoryForYear());
	  System.out.println("Least profitable category for the year: "+query.findLeastProfitableCategoryForYear());
	  System.out.println("Best selling item for the whole year : "+ query.findBestSellingItemForWholeYear());
	  System.out.println("Most profitable item for single sale: "+ query.findMostProfitableItemForSingleSale());
/**	  for(int i=0;i<12;i++)
	  {   
		  String mostProfStore=query.findMostProfitableStoreForEachMonth(i);
		  System.out.println("Most profitable store in month "+(i+1)+" :"+mostProfStore );}*/
	  
	  printEachMonth();
	  }
	 

}