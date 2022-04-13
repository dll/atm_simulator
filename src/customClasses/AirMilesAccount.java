package customClasses;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AirMilesAccount extends Account implements java.io.Serializable
{
	private final static double FEE = 0.75;
	private int airmilesBalance;
	
	
	public AirMilesAccount(String myDescription)
	{
		super(myDescription);
		airmilesBalance = 10;
	}
	
	//-------------------------gets/sets
	public int getAirmilesBalance()
	{
		return airmilesBalance;
	}
	
	//------------------------PRIVATE METHODS
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
	
	//override deposit method from parent
	public void deposit(String myAmount, String myDescription)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
				
		int airmilesToAdd = (int) (Double.parseDouble(myAmount) / 30);
		
		System.out.println(airmilesToAdd);
		
		airmilesBalance += airmilesToAdd;
		
		currentBalance += Double.parseDouble(myAmount);
		Transaction transaction = new Transaction();
		transaction.setAmount(Double.parseDouble(myAmount));
		transaction.setDescription(myDescription);
		transaction.setDate(now);
		transactions.add(transaction);
	}
}
