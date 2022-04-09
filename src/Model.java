import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Model {
	
	ArrayList<Account> accounts;
	private int currentAccountIndex;
	private Savings savingsAccount;
	
	Account ac;
	public Model()
	{
		accounts = new ArrayList<Account>();
		currentAccountIndex = 0;
	}
	
	
	//------------------------------------------------get/set methods
	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}
	
	
	
	public void createAccount(String description, String amount, String Type)
	{
		if(Type == "SAVINGS")
		{
			savingsAccount = new Savings(description);
			savingsAccount.setCurrentBalance(Double.parseDouble(amount));
			accounts.add(savingsAccount);
			currentAccountIndex =  accounts.size() - 1;
			
			System.out.println(currentAccountIndex);
		}
		else
		{
			//create airmiles account
		}
	}
	
	public void deposit(String description, String amount)
	{
		accounts.get(currentAccountIndex).deposit(description, amount);
		
		int x = 0;
	}
	
	public String reportCurrentAccountTransactions()
	{
		String strOutput = "Current Balance: $" +  accounts.get(currentAccountIndex).getCurrentBalance();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");  
		 
		
		for (int n=0; n < accounts.get(currentAccountIndex).getTransactions().size(); n++) 
		{
			strOutput += "\n";
			strOutput += dtf.format(accounts.get(currentAccountIndex).getTransactions().get(n).getDate());
			strOutput += " $" + accounts.get(currentAccountIndex).getTransactions().get(n).getAmount();
			strOutput += " [";
			strOutput += accounts.get(currentAccountIndex).getTransactions().get(n).getDescription();
			strOutput += "]";
			
		}
		return strOutput;
	}
	
	//-------------------------------------------------private methods
	
	
	//------------------------------------------------public methods
	
	
}
