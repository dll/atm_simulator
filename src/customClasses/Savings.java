package customClasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Savings extends Account {
	public final static double FEE = 0.50;
	
	public Savings(String myDescription)
	{
		super(myDescription);
	}
	
	
	//mandatory method because defined as abstract in parent
	public void withdraw(String myAmount, String myDescription)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		 
		currentBalance = currentBalance - (Double.parseDouble(myAmount) + FEE) ;
		Transaction transaction = new Transaction();
		transaction.setAmount(-Double.parseDouble(myAmount) - FEE );
		transaction.setDescription(myDescription);
		transaction.setDate(now);
		transactions.add(transaction);
	}
	
	
}
