package modelController;
import java.awt.Color;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import customClasses.TextFieldValidator;
import views.*;

public class Controller {

	//For descriptions validation
	TextFieldValidator tfvDescription;
	TextFieldValidator tfvAmount;
	
	private Model model;
	private ViewMenu viewMenu;
	private ViewCreate viewCreate;
	private ViewDeposit viewDeposit;
	private ViewView viewView;
	private ViewSelect viewSelect;
	private ViewDelete viewDelete;
	private ViewWithdraw viewWithdraw;
	
	private final String VALIDDESCPATTERN = "^[0-9A-Za-z\\s]+$";
	private final String VALIDAMOUNTPATTERN = "\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d\\.\\d\\d";
	private String errorMessage = "";
	
	public Controller(Model myModel, ViewMenu myViewMenu, ViewCreate myViewCreate,ViewDeposit myViewDeposit, ViewView myViewView, ViewSelect myViewSelect, ViewDelete myViewDelete,ViewWithdraw myViewWithDraw) 
	{
		model = myModel;
		viewMenu = myViewMenu;
		viewCreate = myViewCreate;
		viewDeposit = myViewDeposit;
		viewView = myViewView;
		viewSelect = myViewSelect;
		viewDelete =  myViewDelete;
		viewWithdraw = myViewWithDraw;
		
		viewMenu.addCreateListener((ActionEvent e) -> onClickCreate(e));
		viewMenu.addDepositActionListener((ActionEvent e) -> onClickDeposit(e));
		viewMenu.addViewActionListener((ActionEvent e) -> onClickView(e));
		viewMenu.addSelectActionListener((ActionEvent e) -> onClickSelect(e));
		viewMenu.addDeleteActionListener((ActionEvent e) -> onClickDelete(e));
		viewMenu.addWithdrawActionListener((ActionEvent e) -> onClickWithdraw(e));
		viewMenu.addQuitActionListener((ActionEvent e) -> onClickQuit(e));
		//viewMenu.addLoadListener((WindowEvent e) -> onWindowLoad(e));
		
		viewCreate.addCancelListener((ActionEvent e) -> onClickCancel(e));
		viewCreate.addOkListener((ActionEvent e) -> onClickOk(e));
		
		viewDeposit.addOkActionListener((ActionEvent e) -> onClickOkDeposit(e));
		viewDeposit.addCancelActionListener((ActionEvent e) -> onClickCancelDeposit(e));
		
		viewView.addOkActionListener((ActionEvent e) -> onClickOkView(e));
		
		viewSelect.addOkActionListener((ActionEvent e) -> onClickOkSelect(e));
		viewSelect.addCancelActionListener((ActionEvent e) -> onClickCancelSelect(e));
		
		viewDelete.addDeleteActionListener((ActionEvent e) -> onClickDeleteDelete(e));
		viewDelete.addCancelActionListener((ActionEvent e) -> onClickCancelDelete(e));
		
		viewWithdraw.addOkActionListener((ActionEvent e) -> onClickOkWithdraw(e));
		viewWithdraw.addCancelActionListener((ActionEvent e) -> onClickCancelWithdraw(e));
	}
	
	//----------------------------------------event handlers
	public boolean validateFields(JTextField myDescription, JTextField myAmount)
	{
		tfvDescription = new TextFieldValidator(myDescription, "STRING");
		tfvDescription.setRegExp(VALIDDESCPATTERN);
		
		tfvAmount = new TextFieldValidator(myAmount,"MONEY");
		tfvAmount.setRegExp(VALIDAMOUNTPATTERN);

		
		if(!tfvDescription.check())
		{
			errorMessage = "The description should only be letters and numbers.";
		}
		if(!tfvAmount.check())
		{
			errorMessage = "The amount should be in money format with the proper value.";
		}
		if(!tfvDescription.check() && !tfvAmount.check())
		{
			errorMessage = "The description should only be letters or number and the amount should be in money format.";
		}
		
		
		if(tfvDescription.check() && tfvAmount.check())
		{
			tfvDescription.reset();
			tfvAmount.reset();
			return true;
		}
		return false;
			
	}
	
	
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
	
	public void onClickWithdraw(ActionEvent e) 
	{
		viewMenu.setVisible(false);
		viewWithdraw.setVisible(true);
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
	
	public void onClickQuit(ActionEvent e) 
	{
		if(model.getAccounts().size() > 0)
		{
			model.saveAccounts();
			viewMenu.dispose();
		}
		else
		{
			viewMenu.dispose();
		}
	}
	
	public void onWindowLoad(WindowEvent e) 
	{
		model.loadAccounts();
	}
	//CREATE VIEW
	//Ok button in Create View
	public void onClickOk(ActionEvent e) 
	{
		
		if(validateFields(viewCreate.getDescription(),viewCreate.getStartingBalance()))
		{
			
			viewCreate.setError("");
			String description = "";
			String startingBalance= "";
			String accountType ="";
			
			description = viewCreate.getDescription().getText();
			startingBalance = viewCreate.getStartingBalance().getText(); 
			accountType = viewCreate.getAccountType();
			model.createAccount(description, startingBalance,accountType);
				
			viewCreate.reset();
			viewMenu.enableButtons();
			viewCreate.setVisible(false);
			viewMenu.setVisible(true);	
		}
		else
		{
			viewCreate.setError(errorMessage);
		}
		
	}
	//Cancel button from the Create View
	public void onClickCancel(ActionEvent e) 
	{
		if (tfvDescription != null)
		{
			tfvDescription.reset();
		}
		if (tfvAmount != null)
		{
			tfvAmount.reset();
		}
		
		
		viewCreate.reset();
		viewCreate.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	
	//DEPOSIT VIEW	
	//OK button in deposit view
	public void onClickOkDeposit(ActionEvent e)
	{
		
		if(validateFields(viewDeposit.getDescription(),viewDeposit.getAmount()))
		{
		
			viewDeposit.setError("");
			String depositAmount =  viewDeposit.getAmount().getText();
			String description = viewDeposit.getDescription().getText();
			
			model.deposit(depositAmount, description);
			
			viewDeposit.setVisible(false);
			viewMenu.setVisible(true);
			viewDeposit.reset();
		}
		else
		{
			viewDeposit.setError(errorMessage);
		}
	}
	
	public void onClickCancelDeposit(ActionEvent e) 
	{
		if (tfvDescription != null)
		{
			tfvDescription.reset();
		}
		if (tfvAmount != null)
		{
			tfvAmount.reset();
		}
		
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
		if(viewSelect.getAccountSelectedIndex() != -1)
		{
			viewSelect.setError("");
			model.setCurrentAccountIndex(viewSelect.getAccountSelectedIndex());
			viewSelect.setVisible(false);
			viewMenu.setVisible(true);
		}
		else
		{
			viewSelect.setError("Select an account to continue");
		}
		
	}
	
	public void onClickCancelSelect(ActionEvent e) 
	{
		viewSelect.setError("");
		viewSelect.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	//VIEW Delete
	
	public void onClickDeleteDelete(ActionEvent e)
	{
		model.deleteAccount();
		System.out.println(model.getAccounts().size()-1);
		model.setCurrentAccountIndex(model.getAccounts().size()-1);
		
		//delete file content if no accounts exist
		if(model.accounts.size()==0)
		{
			model.deleteFileContent();
			viewMenu.disableButtons();
		}
		viewDelete.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	
	public void onClickCancelDelete(ActionEvent e) 
	{
		viewDelete.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	//WITHDRAW VIEW	
	//OK button in deposit view
	public void onClickOkWithdraw(ActionEvent e)
	{
		boolean withrawValidated = false;
		
		
		if (validateFields(viewWithdraw.getDescription(),viewWithdraw.getAmount()) && model.validateAmountWithdraw(viewWithdraw.getAmount().getText()))
		{
			String depositAmount =  viewWithdraw.getAmount().getText();
			String description = viewWithdraw.getDescription().getText(); 
			
			model.withdraw(depositAmount, description);
			
			viewWithdraw.setVisible(false);
			viewMenu.setVisible(true);
			viewWithdraw.reset();
		}
		else
		{
			if (validateFields(viewWithdraw.getDescription(),viewWithdraw.getAmount()))
			{
				viewWithdraw.getAmount().setBorder(BorderFactory.createLineBorder(Color.RED));
				viewWithdraw.setError("The withdraw amount should be lower than the current amount");
			}
			else
			{
				viewWithdraw.setError(errorMessage);
			}
			
		}
	}
	
	public void onClickCancelWithdraw(ActionEvent e) 
	{
		if (tfvDescription != null)
		{
			tfvDescription.reset();
		}
		if (tfvAmount != null)
		{
			tfvAmount.reset();
		}
		
		viewWithdraw.reset();
		viewWithdraw.setVisible(false);
		viewMenu.setVisible(true);
	}
	
}
