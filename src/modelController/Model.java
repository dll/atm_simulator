package modelController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import customClasses.Account;
import customClasses.Savings;


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
	
	//Function that returns the descriptions of the accounts
	public DefaultListModel getAccountDescriptions()
	{
		DefaultListModel listModel;
		
		listModel = new DefaultListModel();
		
		for(int i=0; i<accounts.size(); i++)
		{
			listModel.addElement(accounts.get(i).getDescription());
		}
		
		return listModel;
	}
	
	public void setCurrentAccountIndex(int myCurrentAccountIndex)
	{
		currentAccountIndex = myCurrentAccountIndex;
	}
	
	//------------------------------------------------public methods
	public void createAccount(String description, String amount, String Type)
	{
		if(Type == "Savings Account")
		{
			savingsAccount = new Savings(description);
			savingsAccount.setCurrentBalance(Double.parseDouble(amount));
			accounts.add(savingsAccount);
			currentAccountIndex =  accounts.size() - 1;
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
		
		
		String strOutput = "Account Description:  " + accounts.get(currentAccountIndex).getDescription() + "\n";
				strOutput += "Current Balance: $" +  accounts.get(currentAccountIndex).getCurrentBalance();
		
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
	
	public String getCurrentAccountDesctiption()
	{
		
		
		return accounts.get(currentAccountIndex).getDescription();
				
	}
	
	public void deleteAccount()
	{
		accounts.remove(currentAccountIndex);
	}
	
	//-------------------------------------------------private methods
	
	

	
	
}
