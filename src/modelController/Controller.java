package modelController;
import java.awt.event.*;
import java.util.ArrayList;

import views.*;

public class Controller {

	private Model model;
	private ViewMenu viewMenu;
	private ViewCreate viewCreate;
	private ViewDeposit viewDeposit;
	private ViewView viewView;
	private ViewSelect viewSelect;
	private ViewDelete viewDelete;
	
	public Controller(Model myModel, ViewMenu myViewMenu, ViewCreate myViewCreate,ViewDeposit myViewDeposit, ViewView myViewView, ViewSelect myViewSelect, ViewDelete myViewDelete) 
	{
		model = myModel;
		viewMenu = myViewMenu;
		viewCreate = myViewCreate;
		viewDeposit = myViewDeposit;
		viewView = myViewView;
		viewSelect = myViewSelect;
		viewDelete =  myViewDelete;
		
		viewMenu.addCreateListener((ActionEvent e) -> onClickCreate(e));
		viewMenu.addDepositActionListener((ActionEvent e) -> onClickDeposit(e));
		viewMenu.addViewActionListener((ActionEvent e) -> onClickView(e));
		viewMenu.addSelectActionListener((ActionEvent e) -> onClickSelect(e));
		viewMenu.addDeleteActionListener((ActionEvent e) -> onClickDelete(e));
		
		viewCreate.addCancelListener((ActionEvent e) -> onClickCancel(e));
		viewCreate.addOkListener((ActionEvent e) -> onClickOk(e));
		
		viewDeposit.addOkActionListener((ActionEvent e) -> onClickOkDeposit(e));
		viewDeposit.addCancelActionListener((ActionEvent e) -> onClickCancelDeposit(e));
		
		viewView.addOkActionListener((ActionEvent e) -> onClickOkView(e));
		
		viewSelect.addOkActionListener((ActionEvent e) -> onClickOkSelect(e));
		viewSelect.addCancelActionListener((ActionEvent e) -> onClickCancelSelect(e));
		
		viewDelete.addDeleteActionListener((ActionEvent e) -> onClickDeleteDelete(e));
		viewDelete.addCancelActionListener((ActionEvent e) -> onClickCancelDelete(e));
	}
	
	//----------------------------------------event handlers
	
	//MENU
	//Create button from the Menu View
	public void onClickCreate(ActionEvent e) 
	{
		viewMenu.setVisible(false);
		viewCreate.setVisible(true);
	}
	
	public void onClickDeposit(ActionEvent e) 
	{
		viewMenu.setVisible(false);
		viewDeposit.setVisible(true);
	}
	
	public void onClickView(ActionEvent e)
	{
		viewView.showReport(model.reportCurrentAccountTransactions());
		viewMenu.setVisible(false);
		viewView.setVisible(true);
		
	}
	
	public void onClickSelect(ActionEvent e)
	{
		//populate list with the accounts descriptions
		viewSelect.populateList(model.getAccountDescriptions());
		viewMenu.setVisible(false);
		viewSelect.setVisible(true);
	}

	public void onClickDelete(ActionEvent e) 
	{
		viewDelete.setDescription(model.getCurrentAccountDesctiption());
		viewMenu.setVisible(false);
		viewDelete.setVisible(true);
	}
	
	//CREATE VIEW
	//Ok button in Create View
	public void onClickOk(ActionEvent e) 
	{
		String description = "";
		String startingBalance;
		String accountType ="";
		try 
		{
			description = viewCreate.getDescription();
			startingBalance = viewCreate.getStartingBalance(); 
			accountType = viewCreate.getAccountType();
			model.createAccount(description, startingBalance,accountType);
			
			viewCreate.setVisible(false);
			viewMenu.setVisible(true);
			
		} 
		catch(NumberFormatException except)
		{
			//viewCreate.showError("Bad input: '" + userInput + "'");
		}
		
	}
	//Cancel button from the Create View
	public void onClickCancel(ActionEvent e) 
	{
		viewCreate.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	
	//DEPOSIT VIEW	
	//OK button in deposit view
	public void onClickOkDeposit(ActionEvent e)
	{
		String depositAmount =  viewDeposit.getAmount();
		String description = viewDeposit.getDescription(); 
		
		model.deposit(depositAmount, description);
		
		viewDeposit.setVisible(false);
		viewMenu.setVisible(true);
		viewDeposit.reset();
	}
	
	public void onClickCancelDeposit(ActionEvent e) 
	{
		viewDeposit.reset();
		viewDeposit.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	//VIEW View
	//Ok button in view view
	public void onClickOkView(ActionEvent e)
	{
		viewView.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	//VIEW Select
	//Ok button in view select
	public void onClickOkSelect(ActionEvent e)
	{
		model.setCurrentAccountIndex(viewSelect.getAccountSelectedIndex());
		viewView.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	public void onClickCancelSelect(ActionEvent e) 
	{
		viewSelect.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	//VIEW Delete
	
	public void onClickDeleteDelete(ActionEvent e)
	{
		model.deleteAccount();
		System.out.println(model.getAccounts().size()-1);
		model.setCurrentAccountIndex(model.getAccounts().size()-1);
		viewDelete.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	
	public void onClickCancelDelete(ActionEvent e) 
	{
		viewDelete.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	
}
