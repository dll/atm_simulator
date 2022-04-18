package customClasses;

//following singleton design
//Can't construct more than one
//global access
import java.io.*;
import java.util.ArrayList;


public class FileManager {
	
	//variable instance
	private static FileManager instance = null;
	
	private String filename;
	
	//private constructor
	private FileManager()
	{
		filename = "data.dat";
	}
	
	//---------------------------------------------------get/set methods
	public void setFileName(String value)
	{
		filename = value;
	}
	
	//--------------------------------------------------public methods
	public void save( ArrayList<Account> myAccounts)
	{
		
		try 
		{
		
			File file = new File(filename);
			
			// fileStream going to work with file object
			//this stream object does the writing into the file
			FileOutputStream fileStream = new FileOutputStream(file);
			
			//this stream object does the converting of the data into the correct format to write to the file
			ObjectOutputStream dataStream = new ObjectOutputStream(fileStream);
			
			//loop and save all accounts in list
			for(int i=0; i<myAccounts.size(); i++)
			{
				dataStream.writeObject(myAccounts.get(i));
			}
			
			//close datastream
			dataStream.close();
		} 
		catch(Exception e)
		{
			System.out.println("Binary file output error:" + e.getMessage());
		}
		
	}
	
	//returns Object or null in case it does not find data
	public ArrayList<Account> load()
	{
		
		ArrayList<Account> myObjectsArray;
		myObjectsArray = new ArrayList<Account>();
		
		try 
		{
			File file = new File(filename);
			
			//if the file exits
			if (file.exists())
			{
				FileInputStream fileStream = new FileInputStream(file);
				
				ObjectInputStream dataStream = new ObjectInputStream(fileStream);
	
			    Account account =null;
	
			    boolean flag = true;
			    //go through file retrieving the objects
			    while(flag){
			        if(fileStream.available() != 0)
			        {
			        	//datacast to account 
			        	account = (Account)(dataStream.readObject());    
			        	myObjectsArray.add(account);
			        }
			        else
			        {
				        flag = false;
				        
			        }
			    }
			    
			    dataStream.close();
			    return myObjectsArray;     
			}			
			else
			{
				return null;
			}
		} 
		catch(Exception e)
		{
			System.out.println("Binary file output error:" + e.getMessage());
			return null;
		}
	
	}
	
	//----------------------------------------------------class methods
	public static FileManager getInstance()
	{
		if (instance == null)
		{
			instance = new FileManager();
		}
		return instance;
	}
	
	public void deleteFileContent()
	{
		try 
		{
			new FileOutputStream(filename).close();
		}
		catch(Exception e)
		{
			System.out.println("Binary file output error:" + e.getMessage());
		}
		
	}
	
}
