package customClasses;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction 
{
	private double amount;
	private String description;
	private LocalDateTime transactionDate;
	
	
	public Transaction()
	{
		amount = 0;
		description = "";
		transactionDate = LocalDateTime.now();
	}
	
	//--------------gets and sets
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double myAmount)
	{
		amount = myAmount;
	}
	public LocalDateTime getDate()
	{
		return transactionDate;
	}
	public void setDate(LocalDateTime myDate)
	{
		transactionDate = myDate;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String myDescription)
	{
		description = myDescription;
	}
}
