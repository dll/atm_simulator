package customClasses;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

//abstract class because of the withdraw method

public abstract class Account implements java.io.Serializable
{
	//Protected for it to be accessible anywhere
	protected String description;
	protected double currentBalance;
	
	protected ArrayList<Transaction> transactions;
	
	
	public Account(String myDescription)
	{
		description = myDescription;
		currentBalance = 0;
		
		transactions = new ArrayList<Transaction>();
	}
	//--------------------------get/sets
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String myDescription)
	{
		description = myDescription;
	}
	public double getCurrentBalance()
	{
		return currentBalance;
	}
	
	public void setCurrentBalance(double myCurrentBalance)
	{
		currentBalance = myCurrentBalance;
	}
	
	public ArrayList<Transaction> getTransactions()
	{
		return transactions;
	}
	
	
	//Deposit transaction
	public void deposit(String myAmount, String myDescription)
	{
		
		//Get todays date
		LocalDateTime now = LocalDateTime.now(); 
		
		currentBalance += Double.parseDouble(myAmount);
		Transaction transaction = new Transaction();
		transaction.setAmount(Double.parseDouble(myAmount));
		transaction.setDescription(myDescription);
		transaction.setDate(now);
		transactions.add(transaction);
	}
	
	
	//---------------------------------------abstract methods
    
	//Withdraw method
	public abstract void withdraw(String myAmount, String myDescription);
    
	//Method to get Fee
	public abstract Double getFee();
	
	
    
	
	
}