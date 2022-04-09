import java.awt.event.*;
import java.util.ArrayList;

import Views.ViewCreate;

public class Controller {

	private Model model;
	private ViewMenu viewMenu;
	private ViewCreate viewCreate;
	private ViewDeposit viewDeposit;
	private ViewView viewView;
	
	public Controller(Model myModel, ViewMenu myViewMenu, ViewCreate myViewCreate,ViewDeposit myViewDeposit, ViewView myViewView) 
	{
		model = myModel;
		viewMenu = myViewMenu;
		viewCreate = myViewCreate;
		viewDeposit = myViewDeposit;
		viewView = myViewView;
		
		viewMenu.addCreateListener((ActionEvent e) -> onClickCreate(e));
		viewMenu.addDepositActionListener((ActionEvent e) -> onClickDeposit(e));
		viewMenu.addViewActionListener((ActionEvent e) -> onClickView(e));
		viewCreate.addCancelListener((ActionEvent e) -> onClickCancel(e));
		viewCreate.addOkListener((ActionEvent e) -> onClickOk(e));
		viewDeposit.addOkActionListener((ActionEvent e) -> onClickOkDeposit(e));
		viewDeposit.addCancelActionListener((ActionEvent e) -> onClickCancelDeposit(e));
		viewView.addOkActionListener((ActionEvent e) -> onClickOkView(e));
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
	
	//CREATE VIEW
	//Ok button in Create View
	public void onClickOk(ActionEvent e) 
	{
		String description = "";
		String startingBalance;
		try 
		{
			description = viewCreate.getDescription();
			startingBalance = viewCreate.getStartingBalance(); 
			
			model.createAccount(description, startingBalance,"SAVINGS");
			
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
	
	//VIEW view
	//Ok button in view view
	public void onClickOkView(ActionEvent e)
	{
		viewView.setVisible(false);
		viewMenu.setVisible(true);
	}
	
}
