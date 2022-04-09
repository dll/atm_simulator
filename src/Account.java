import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

//abstract class because of the withdraw method
public abstract class Account 
{
	//Protected for it to be accessible anywhere
	protected String description;
	protected double currentBalance;
	//private Transaction transaction; 
	
	ArrayList<Transaction> transactions;
	
	
	public Account(String myDescription)
	{
		description = myDescription;
		currentBalance = 0;
		//transaction = new Transaction();
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
	
	public void deposit(String myAmount, String myDescription)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		
		currentBalance += Double.parseDouble(myAmount);
		Transaction transaction = new Transaction();
		transaction.setAmount(Double.parseDouble(myAmount));
		transaction.setDescription(myDescription);
		transaction.setDate(now);
		transactions.add(transaction);
	}
	
	
	//---------------------------------------abstract methods
    public abstract void withdraw(float amount);
	
	
}