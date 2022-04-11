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
			
			//this stream object dose the converting of the data into the correct format to write to the file
			ObjectOutputStream dataStream = new ObjectOutputStream(fileStream);
			
			//serialize and write Bicycle object to the file
			
			
			for(int i=0; i<myAccounts.size(); i++)
			{
				dataStream.writeObject(myAccounts.get(i));
			}
			
			
			//if not closed there might be data in a buffer that didn't pass yet, this flushes
			dataStream.close();
		} 
		catch(Exception e)
		{
			System.out.println("Binary file output error:" + e.getMessage());
		}
		
	}
	
	//returns Object so pretty much anything
	public ArrayList<Object> load()
	{
		System.out.println("load");
		
		ArrayList<Object> myObjectsArray;
		myObjectsArray = new ArrayList<Object>();
		
		try 
		{
			File file = new File(filename);
			
			if (file.exists())
			{
				FileInputStream fileStream = new FileInputStream(file);
				
				ObjectInputStream dataStream = new ObjectInputStream(fileStream);
	
			    Object object =null;
	
			    boolean flag = true;
	
			    while(flag){
			        if(fileStream.available() != 0)
			        {
			        	object = dataStream.readObject();    
			        	myObjectsArray.add(object);
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
	
}
